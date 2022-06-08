package com.urbanmatrix.mavlink.generator.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

data class MavlinkModel(
    val name: String,
    val includes: List<String>,
    val version: Int,
    val dialect: Int,
    val enums: List<EnumModel>,
    val messages: List<MessageModel>
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "mavlink")
data class MavlinkXml(

    @JacksonXmlProperty(localName = "version", isAttribute = true)
    val version: Int,

    @JacksonXmlProperty(localName = "dialect", isAttribute = true)
    val dialect: Int,

    @JacksonXmlElementWrapper(localName = "enums")
    val enums: List<EnumXml>,

    @JacksonXmlElementWrapper(localName = "messages")
    val messages: List<MessageXml>
) {
    val includes = mutableListOf<String>()

    @JsonSetter("include")
    fun addInclude(include: String) {
        includes += include
    }

    fun toModel(name: String) = MavlinkModel(
        name,
        includes,
        version,
        dialect,
        enums.map { it.toModel() },
        messages.map { it.toModel() }
    )
}
