package com.urbanmatrix.mavlink.generator.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText

sealed class FieldModel : Comparable<FieldModel>{

    abstract val position: Int
    abstract val type: String
    abstract val name: String
    abstract val extension: Boolean
    abstract val display: String?
    abstract val units: String?
    abstract val invalid: String?
    abstract val printFormat: String?
    abstract val content: String?

    data class Primitive(
        override val position: Int,
        override val type: String,
        override val name: String,
        override val extension: Boolean,
        override val display: String?,
        override val units: String?,
        override val invalid: String?,
        override val printFormat: String?,
        override val content: String?
    ) : FieldModel()

    data class PrimitiveArray(
        val primitiveType: String,
        val arrayLength: Int,
        override val position: Int,
        override val type: String,
        override val name: String,
        override val extension: Boolean,
        override val display: String?,
        override val units: String?,
        override val invalid: String?,
        override val printFormat: String?,
        override val content: String?
    ) : FieldModel()

    data class Enum(
        val enumType: String,
        override val position: Int,
        override val type: String,
        override val name: String,
        override val extension: Boolean,
        override val display: String?,
        override val units: String?,
        override val invalid: String?,
        override val printFormat: String?,
        override val content: String?
    ) : FieldModel()

    val unitSize: Int
        get() {
            val t = when (this) {
                is Enum, is Primitive -> type
                is PrimitiveArray -> primitiveType
            }
            return when (t) {
                "char" -> 1
                "float" -> 4
                "double" -> 8
                "uint8_t_mavlink_version" -> 1
                "uint8_t", "int8_t" -> 1
                "uint16_t", "int16_t" -> 2
                "uint32_t", "int32_t" -> 4
                "uint64_t", "int64_t" -> 8
                else -> throw RuntimeException("Invalid type: $t")
            }
        }

    val size: Int
        get() = when (this) {
            is Enum -> unitSize
            is Primitive -> unitSize
            is PrimitiveArray -> unitSize * arrayLength
        }

    override fun compareTo(other: FieldModel): Int {
        if (this.extension && !other.extension) return 1

        if (!this.extension && other.extension) return -1

        if (!this.extension && this.unitSize != other.unitSize) {
            other.unitSize - this.unitSize
        }

        return this.position - other.position
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "field")
data class FieldXml(

    @JacksonXmlProperty(localName = "type", isAttribute = true)
    val type: String,

    @JacksonXmlProperty(localName = "name", isAttribute = true)
    val name: String,

    @JacksonXmlProperty(localName = "enum", isAttribute = true)
    val enum: String?,

    @JacksonXmlProperty(localName = "display", isAttribute = true)
    val display: String?,

    @JacksonXmlProperty(localName = "units", isAttribute = true)
    val units: String?,

    @JacksonXmlProperty(localName = "invalid", isAttribute = true)
    val invalid: String?,

    @JacksonXmlProperty(localName = "print_format", isAttribute = true)
    val printFormat: String?,
) {
    @JacksonXmlText
    var content: String? = null

    var position: Int = -1

    var extension: Boolean = false

    fun toModel(): FieldModel {
        return if (enum == null) {
            if (type.endsWith("]")) {
                val primitiveType = type.substringBefore("[")
                val arrayLength = type.substringAfter("[").substringBefore("]").toInt()

                FieldModel.PrimitiveArray(
                    primitiveType,
                    arrayLength,
                    position,
                    type,
                    name,
                    extension,
                    display,
                    units,
                    invalid,
                    printFormat,
                    content
                )
            } else {
                FieldModel.Primitive(
                    position,
                    type,
                    name,
                    extension,
                    display,
                    units,
                    invalid,
                    printFormat,
                    content
                )
            }
        } else {
            FieldModel.Enum(
                enum,
                position,
                type,
                name,
                extension,
                display,
                units,
                invalid,
                printFormat,
                content
            )
        }
    }
}
