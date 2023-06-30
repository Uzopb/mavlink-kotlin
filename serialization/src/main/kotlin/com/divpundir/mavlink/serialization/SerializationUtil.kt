package com.divpundir.mavlink.serialization

/**
 * Writes the given [Byte]/Int8 to the buffer's current position, and then increments the position.
 */
public fun DataEncoder.encodeInt8(value: Byte) {
    this.encodeByte(value)
}

/**
 * Writes the given [UByte]/UInt8 to the buffer's current position, and then increments the position.
 */
public fun DataEncoder.encodeUInt8(value: UByte) {
    this.encodeByte(value.toByte())
}

/**
 * Writes the given [Short]/Int16 to the buffer's current position in little-endian order, and then increments the
 * position.
 */
public fun DataEncoder.encodeInt16(value: Short) {
    this.encodeShort(value)
}

/**
 * Writes the given [UShort]/UInt16 to the buffer's current position in little-endian order, and then increments the
 * position.
 */
public fun DataEncoder.encodeUInt16(value: UShort) {
    this.encodeShort(value.toShort())
}

/**
 * Writes the given [Int]/Int32 to the buffer's current position in little-endian order, and then increments the
 * position.
 */
public fun DataEncoder.encodeInt32(value: Int) {
    this.encodeInt(value)
}

/**
 * Writes the given [UInt]/UInt32 to the buffer's current position in little-endian order, and then increments the
 * position.
 */
public fun DataEncoder.encodeUInt32(value: UInt) {
    this.encodeInt(value.toInt())
}

/**
 * Writes the given [Long]/Int64 to the buffer's current position in little-endian order, and then increments the
 * position.
 */
public fun DataEncoder.encodeInt64(value: Long) {
    this.encodeLong(value)
}

/**
 * Writes the given [ULong]/UInt64 to the buffer's current position in little-endian order, and then increments the
 * position.
 */
public fun DataEncoder.encodeUInt64(value: ULong) {
    this.encodeLong(value.toLong())
}

/**
 * Writes the given [Float]/Float32 to the buffer's current position in little-endian order, and then increments the
 * position.
 */
public fun DataEncoder.encodeFloat(value: Float) {
    this.encodeInt(value.toBits())
}

/**
 * Writes the given [Double]/Float64 to the buffer's current position in little-endian order, and then increments the
 * position.
 */
public fun DataEncoder.encodeDouble(value: Double) {
    this.encodeLong(value.toBits())
}

/**
 * Writes the given [Char]/UInt64 to the buffer's current position, and then increments the position.
 */
public fun DataEncoder.encodeChar(value: Char) {
    this.encodeByte(value.code.toByte())
}

/**
 * Writes the given [String] to the buffer's current position, and then increments the position. If the encoded [String]
 * is shorter than the [length] parameter then the remaining positions are filled with empty characters.
 */
public fun DataEncoder.encodeString(value: String, length: Int) {
    val data = value.toByteArray(charset = Charsets.UTF_8).copyOf(newSize = length)
    this.encodeByteArray(data)
}

/**
 * Encodes the given [List] of [Byte]/Int8 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun DataEncoder.encodeInt8Array(arr: List<Byte>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / Byte.SIZE_BYTES, 0, DataEncoder::encodeInt8)

/**
 * Encodes the given [List] of [UByte]/UInt8 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun DataEncoder.encodeUInt8Array(arr: List<UByte>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / UByte.SIZE_BYTES, 0u, DataEncoder::encodeUInt8)

/**
 * Encodes the given [List] of [Short]/Int16 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun DataEncoder.encodeInt16Array(arr: List<Short>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / Short.SIZE_BYTES, 0, DataEncoder::encodeInt16)

/**
 * Encodes the given [List] of [UShort]/UInt16 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun DataEncoder.encodeUInt16Array(arr: List<UShort>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / UShort.SIZE_BYTES, 0u, DataEncoder::encodeUInt16)

/**
 * Encodes the given [List] of [Int]/Int32 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun DataEncoder.encodeInt32Array(arr: List<Int>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / Int.SIZE_BYTES, 0, DataEncoder::encodeInt32)

/**
 * Encodes the given [List] of [UInt]/UInt32 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun DataEncoder.encodeUInt32Array(arr: List<UInt>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / UInt.SIZE_BYTES, 0u, DataEncoder::encodeUInt32)

/**
 * Encodes the given [List] of [Long]/Int64 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun DataEncoder.encodeInt64Array(arr: List<Long>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / Long.SIZE_BYTES, 0L, DataEncoder::encodeInt64)

/**
 * Encodes the given [List] of [ULong]/UInt64 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun DataEncoder.encodeUInt64Array(arr: List<ULong>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / ULong.SIZE_BYTES, 0uL, DataEncoder::encodeUInt64)

/**
 * Encodes the given [List] of [Float]/Float32 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun DataEncoder.encodeFloatArray(arr: List<Float>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / Float.SIZE_BYTES, 0F, DataEncoder::encodeFloat)

/**
 * Encodes the given [List] of [Double]/Float64 into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun DataEncoder.encodeDoubleArray(arr: List<Double>, dataSize: Int): Unit =
    encodeArray(arr, dataSize / Double.SIZE_BYTES, 0.0, DataEncoder::encodeDouble)

/**
 * Encodes the given [UInt] MAVLink enum value into a [ByteArray] of size [dataSize], writes it to the buffer's current
 * position in little-endian order, and then increments the position.
 */
public fun DataEncoder.encodeEnumValue(value: UInt, dataSize: Int) {
    when (dataSize) {
        UByte.SIZE_BYTES -> encodeUInt8(value.toUByte())
        UShort.SIZE_BYTES -> encodeUInt16(value.toUShort())
        UInt.SIZE_BYTES -> encodeUInt32(value)
        else -> {}
    }
}

/**
 * Encodes the given [UInt] MAVLink bitmask value into a [ByteArray] of size [dataSize], writes it to the buffer's
 * current position in little-endian order, and then increments the position.
 */
public fun DataEncoder.encodeBitmaskValue(value: UInt, dataSize: Int) {
    when (dataSize) {
        UByte.SIZE_BYTES -> encodeUInt8(value.toUByte())
        UShort.SIZE_BYTES -> encodeUInt16(value.toUShort())
        UInt.SIZE_BYTES -> encodeUInt32(value)
        else -> {}
    }
}

/**
 * Encodes the given [Long] into a [ByteArray] of size [dataSize], writes it to the buffer's current position in
 * little-endian order, and then increments the position.
 */
public fun DataEncoder.encodeIntegerValue(value: Long, dataSize: Int) {
    for (shift in 0 until dataSize) {
        this.encodeByte(((value shr (shift * 8)) and 0xFF).toByte())
    }
}

/**
 * Returns a new [ByteArray] with all the trailing zeros removed.
 */
public fun ByteArray.truncateZeros(): ByteArray {
    for (index in lastIndex downTo 0) {
        if (this[index] != 0.toByte()) {
            return this.copyOfRange(0, index + 1)
        }
    }
    return ByteArray(0)
}

private inline fun <T : Any> DataEncoder.encodeArray(
    arr: List<T>,
    elementCount: Int,
    defaultValue: T,
    encode: DataEncoder.(T) -> Unit
) {
    for (i in 0 until elementCount) this.encode(if (i < arr.size) arr[i] else defaultValue)
}
