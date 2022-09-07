package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * An ack for a LOGGING_DATA_ACKED message
 */
@GeneratedMavMessage(
  id = 268,
  crc = 14,
)
public data class LoggingAck(
  /**
   * system ID of the target
   */
  public val targetSystem: Int = 0,
  /**
   * component ID of the target
   */
  public val targetComponent: Int = 0,
  /**
   * sequence number (must match the one in LOGGING_DATA_ACKED)
   */
  public val sequence: Int = 0,
) : MavMessage<LoggingAck> {
  public override val instanceMetadata: MavMessage.Metadata<LoggingAck> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(sequence)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 268

    private const val CRC: Int = 14

    private const val SIZE: Int = 4

    private val DESERIALIZER: MavDeserializer<LoggingAck> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sequence = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

      LoggingAck(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        sequence = sequence,
      )
    }


    private val METADATA: MavMessage.Metadata<LoggingAck> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<LoggingAck> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var sequence: Int = 0

    public fun build(): LoggingAck = LoggingAck(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      sequence = sequence,
    )
  }
}
