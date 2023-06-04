package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
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

/**
 * Flexifunction type and parameters for component at function index from buffer
 */
@GeneratedMavMessage(
  id = 153u,
  crcExtra = 109,
)
public data class FlexifunctionBufferFunctionAck(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Function index
   */
  @GeneratedMavField(type = "uint16_t")
  public val funcIndex: UShort = 0u,
  /**
   * result of acknowledge, 0=fail, 1=good
   */
  @GeneratedMavField(type = "uint16_t")
  public val result: UShort = 0u,
) : MavMessage<FlexifunctionBufferFunctionAck> {
  public override val instanceCompanion: MavMessage.MavCompanion<FlexifunctionBufferFunctionAck> =
      Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(funcIndex)
    outputBuffer.encodeUInt16(result)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(funcIndex)
    outputBuffer.encodeUInt16(result)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FlexifunctionBufferFunctionAck> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    public override val id: UInt = 153u

    public override val crcExtra: Byte = 109

    public override fun deserialize(bytes: ByteArray): FlexifunctionBufferFunctionAck {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val funcIndex = inputBuffer.decodeUInt16()
      val result = inputBuffer.decodeUInt16()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()

      return FlexifunctionBufferFunctionAck(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        funcIndex = funcIndex,
        result = result,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FlexifunctionBufferFunctionAck =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var funcIndex: UShort = 0u

    public var result: UShort = 0u

    public fun build(): FlexifunctionBufferFunctionAck = FlexifunctionBufferFunctionAck(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      funcIndex = funcIndex,
      result = result,
    )
  }
}
