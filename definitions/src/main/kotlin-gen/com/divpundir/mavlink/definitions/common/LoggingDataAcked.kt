package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * A message containing logged data which requires a LOGGING_ACK to be sent back
 */
@GeneratedMavMessage(
  id = 267u,
  crcExtra = 35,
)
public data class LoggingDataAcked(
  /**
   * system ID of the target
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * component ID of the target
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * sequence number (can wrap)
   */
  @GeneratedMavField(type = "uint16_t")
  public val sequence: UShort = 0u,
  /**
   * data length
   */
  @GeneratedMavField(type = "uint8_t")
  public val length: UByte = 0u,
  /**
   * offset into data where first message starts. This can be used for recovery, when a previous
   * message got lost (set to UINT8_MAX if no start exists).
   */
  @GeneratedMavField(type = "uint8_t")
  public val firstMessageOffset: UByte = 0u,
  /**
   * logged data
   */
  @GeneratedMavField(type = "uint8_t[249]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<LoggingDataAcked> {
  public override val instanceMetadata: MavMessage.Metadata<LoggingDataAcked> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(sequence)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(length)
    outputBuffer.encodeUInt8(firstMessageOffset)
    outputBuffer.encodeUInt8Array(data, 249)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(sequence)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(length)
    outputBuffer.encodeUInt8(firstMessageOffset)
    outputBuffer.encodeUInt8Array(data, 249)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 267u

    private const val CRC_EXTRA: Byte = 35

    private const val SIZE_V1: Int = 255

    private const val SIZE_V2: Int = 255

    private val DESERIALIZER: MavDeserializer<LoggingDataAcked> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sequence = inputBuffer.decodeUInt16()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val length = inputBuffer.decodeUInt8()
      val firstMessageOffset = inputBuffer.decodeUInt8()
      val data = inputBuffer.decodeUInt8Array(249)

      LoggingDataAcked(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        sequence = sequence,
        length = length,
        firstMessageOffset = firstMessageOffset,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<LoggingDataAcked> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<LoggingDataAcked> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): LoggingDataAcked =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var sequence: UShort = 0u

    public var length: UByte = 0u

    public var firstMessageOffset: UByte = 0u

    public var `data`: List<UByte> = emptyList()

    public fun build(): LoggingDataAcked = LoggingDataAcked(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      sequence = sequence,
      length = length,
      firstMessageOffset = firstMessageOffset,
      data = data,
    )
  }
}