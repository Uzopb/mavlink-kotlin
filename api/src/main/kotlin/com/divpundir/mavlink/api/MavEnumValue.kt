package com.divpundir.mavlink.api

/**
 * Wrapper class for a [MavEnum].
 */
public class MavEnumValue<E : MavEnum> private constructor(public val entry: E?, public val value: UInt) {

    public companion object {

        @JvmStatic
        public fun <E : MavEnum> of(entry: E): MavEnumValue<E> = MavEnumValue(entry, entry.value)

        @JvmStatic
        public fun <E : MavEnum> fromValue(value: UInt): MavEnumValue<E> = MavEnumValue(null, value)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MavEnumValue<*>

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String {
        return "MavEnumValue(entry=$entry, value=$value)"
    }
}