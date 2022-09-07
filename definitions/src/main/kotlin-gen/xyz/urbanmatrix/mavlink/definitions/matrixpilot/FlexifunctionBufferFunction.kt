package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt8Array
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeInt8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Flexifunction type and parameters for component at function index from buffer
 */
@GeneratedMavMessage(
  id = 152,
  crc = 101,
)
public data class FlexifunctionBufferFunction(
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * Function index
   */
  public val funcIndex: Int = 0,
  /**
   * Total count of functions
   */
  public val funcCount: Int = 0,
  /**
   * Address in the flexifunction data, Set to 0xFFFF to use address in target memory
   */
  public val dataAddress: Int = 0,
  /**
   * Size of the 
   */
  public val dataSize: Int = 0,
  /**
   * Settings data
   */
  public val `data`: List<Int> = emptyList(),
) : MavMessage<FlexifunctionBufferFunction> {
  public override val instanceMetadata: MavMessage.Metadata<FlexifunctionBufferFunction> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(funcIndex)
    outputBuffer.encodeUint16(funcCount)
    outputBuffer.encodeUint16(dataAddress)
    outputBuffer.encodeUint16(dataSize)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeInt8Array(data, 48)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 152

    private const val CRC: Int = 101

    private const val SIZE: Int = 58

    private val DESERIALIZER: MavDeserializer<FlexifunctionBufferFunction> = MavDeserializer {
        bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val funcIndex = inputBuffer.decodeUint16()
      val funcCount = inputBuffer.decodeUint16()
      val dataAddress = inputBuffer.decodeUint16()
      val dataSize = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
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
        CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FlexifunctionBufferFunction> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var funcIndex: Int = 0

    public var funcCount: Int = 0

    public var dataAddress: Int = 0

    public var dataSize: Int = 0

    public var `data`: List<Int> = emptyList()

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
