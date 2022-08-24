package xyz.urbanmatrix.mavlink.definitions.avssuas

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 *  Drone operation mode.
 */
@GeneratedMavMessage(
  id = 60053,
  crc = 45,
)
public data class AvssDroneOperationMode(
  /**
   * Timestamp (time since FC boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * DJI M300 operation mode
   */
  public val m300OperationMode: Int = 0,
  /**
   * horsefly operation mode
   */
  public val horseflyOperationMode: Int = 0,
) : MavMessage<AvssDroneOperationMode> {
  public override val instanceMetadata: MavMessage.Metadata<AvssDroneOperationMode> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeUint8(m300OperationMode)
    outputBuffer.encodeUint8(horseflyOperationMode)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 60053

    private const val CRC: Int = 45

    private const val SIZE: Int = 6

    private val DESERIALIZER: MavDeserializer<AvssDroneOperationMode> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val m300OperationMode = inputBuffer.decodeUint8()
      val horseflyOperationMode = inputBuffer.decodeUint8()

      AvssDroneOperationMode(
        timeBootMs = timeBootMs,
        m300OperationMode = m300OperationMode,
        horseflyOperationMode = horseflyOperationMode,
      )
    }


    private val METADATA: MavMessage.Metadata<AvssDroneOperationMode> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AvssDroneOperationMode> = METADATA
  }
}