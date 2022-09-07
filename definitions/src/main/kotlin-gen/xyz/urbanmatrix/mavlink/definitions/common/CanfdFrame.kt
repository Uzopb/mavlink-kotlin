package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array

/**
 * A forwarded CANFD frame as requested by MAV_CMD_CAN_FORWARD. These are separated from CAN_FRAME
 * as they need different handling (eg. TAO handling)
 */
@GeneratedMavMessage(
  id = 387,
  crc = 4,
)
public data class CanfdFrame(
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  public val targetComponent: Int = 0,
  /**
   * bus number
   */
  public val bus: Int = 0,
  /**
   * Frame length
   */
  public val len: Int = 0,
  /**
   * Frame ID
   */
  public val id: Long = 0L,
  /**
   * Frame data
   */
  public val `data`: List<Int> = emptyList(),
) : MavMessage<CanfdFrame> {
  public override val instanceMetadata: MavMessage.Metadata<CanfdFrame> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(id)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(bus)
    outputBuffer.encodeUint8(len)
    outputBuffer.encodeUint8Array(data, 64)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 387

    private const val CRC: Int = 4

    private const val SIZE: Int = 72

    private val DESERIALIZER: MavDeserializer<CanfdFrame> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val id = inputBuffer.decodeUint32()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val bus = inputBuffer.decodeUint8()
      val len = inputBuffer.decodeUint8()
      val data = inputBuffer.decodeUint8Array(64)

      CanfdFrame(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        bus = bus,
        len = len,
        id = id,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<CanfdFrame> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CanfdFrame> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var bus: Int = 0

    public var len: Int = 0

    public var id: Long = 0L

    public var `data`: List<Int> = emptyList()

    public fun build(): CanfdFrame = CanfdFrame(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      bus = bus,
      len = len,
      id = id,
      data = data,
    )
  }
}
