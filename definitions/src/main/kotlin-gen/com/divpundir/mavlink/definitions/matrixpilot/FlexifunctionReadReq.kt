package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Reqest reading of flexifunction data
 */
@GeneratedMavMessage(
  id = 151u,
  crcExtra = 26,
)
public data class FlexifunctionReadReq(
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
   * Type of flexifunction data requested
   */
  @GeneratedMavField(type = "int16_t")
  public val readReqType: Short = 0,
  /**
   * index into data where needed
   */
  @GeneratedMavField(type = "int16_t")
  public val dataIndex: Short = 0,
) : MavMessage<FlexifunctionReadReq> {
  public override val instanceCompanion: MavMessage.MavCompanion<FlexifunctionReadReq> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(readReqType)
    outputBuffer.encodeInt16(dataIndex)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(readReqType)
    outputBuffer.encodeInt16(dataIndex)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FlexifunctionReadReq> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    public override val id: UInt = 151u

    public override val crcExtra: Byte = 26

    public override fun deserialize(bytes: ByteArray): FlexifunctionReadReq {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val readReqType = inputBuffer.decodeInt16()
      val dataIndex = inputBuffer.decodeInt16()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()

      return FlexifunctionReadReq(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        readReqType = readReqType,
        dataIndex = dataIndex,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FlexifunctionReadReq =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var readReqType: Short = 0

    public var dataIndex: Short = 0

    public fun build(): FlexifunctionReadReq = FlexifunctionReadReq(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      readReqType = readReqType,
      dataIndex = dataIndex,
    )
  }
}
