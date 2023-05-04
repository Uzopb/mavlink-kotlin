package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt8Array
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt8Array
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
import kotlin.collections.List

/**
 * Flexifunction type and parameters for component at function index from buffer
 */
@GeneratedMavMessage(
  id = 152u,
  crcExtra = 101,
)
public data class FlexifunctionBufferFunction(
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
   * Total count of functions
   */
  @GeneratedMavField(type = "uint16_t")
  public val funcCount: UShort = 0u,
  /**
   * Address in the flexifunction data, Set to 0xFFFF to use address in target memory
   */
  @GeneratedMavField(type = "uint16_t")
  public val dataAddress: UShort = 0u,
  /**
   * Size of the 
   */
  @GeneratedMavField(type = "uint16_t")
  public val dataSize: UShort = 0u,
  /**
   * Settings data
   */
  @GeneratedMavField(type = "int8_t[48]")
  public val `data`: List<Byte> = emptyList(),
) : MavMessage<FlexifunctionBufferFunction> {
  public override val instanceMetadata: MavMessage.Metadata<FlexifunctionBufferFunction> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(funcIndex)
    outputBuffer.encodeUInt16(funcCount)
    outputBuffer.encodeUInt16(dataAddress)
    outputBuffer.encodeUInt16(dataSize)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeInt8Array(data, 48)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(funcIndex)
    outputBuffer.encodeUInt16(funcCount)
    outputBuffer.encodeUInt16(dataAddress)
    outputBuffer.encodeUInt16(dataSize)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeInt8Array(data, 48)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 152u

    private const val CRC_EXTRA: Byte = 101

    private const val SIZE_V1: Int = 58

    private const val SIZE_V2: Int = 58

    private val DESERIALIZER: MavDeserializer<FlexifunctionBufferFunction> = MavDeserializer {
        bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val funcIndex = inputBuffer.decodeUInt16()
      val funcCount = inputBuffer.decodeUInt16()
      val dataAddress = inputBuffer.decodeUInt16()
      val dataSize = inputBuffer.decodeUInt16()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val data = inputBuffer.decodeInt8Array(48)

      FlexifunctionBufferFunction(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        funcIndex = funcIndex,
        funcCount = funcCount,
        dataAddress = dataAddress,
        dataSize = dataSize,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<FlexifunctionBufferFunction> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FlexifunctionBufferFunction> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): FlexifunctionBufferFunction =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var funcIndex: UShort = 0u

    public var funcCount: UShort = 0u

    public var dataAddress: UShort = 0u

    public var dataSize: UShort = 0u

    public var `data`: List<Byte> = emptyList()

    public fun build(): FlexifunctionBufferFunction = FlexifunctionBufferFunction(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      funcIndex = funcIndex,
      funcCount = funcCount,
      dataAddress = dataAddress,
      dataSize = dataSize,
      data = data,
    )
  }
}