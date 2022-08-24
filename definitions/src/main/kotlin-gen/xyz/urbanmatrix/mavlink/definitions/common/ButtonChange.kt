package xyz.urbanmatrix.mavlink.definitions.common

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
 * Report button state change.
 */
@GeneratedMavMessage(
  id = 257,
  crc = 131,
)
public data class ButtonChange(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * Time of last change of button state.
   */
  public val lastChangeMs: Long = 0L,
  /**
   * Bitmap for state of buttons.
   */
  public val state: Int = 0,
) : MavMessage<ButtonChange> {
  public override val instanceMetadata: MavMessage.Metadata<ButtonChange> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeUint32(lastChangeMs)
    outputBuffer.encodeUint8(state)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 257

    private const val CRC: Int = 131

    private const val SIZE: Int = 9

    private val DESERIALIZER: MavDeserializer<ButtonChange> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val lastChangeMs = inputBuffer.decodeUint32()
      val state = inputBuffer.decodeUint8()

      ButtonChange(
        timeBootMs = timeBootMs,
        lastChangeMs = lastChangeMs,
        state = state,
      )
    }


    private val METADATA: MavMessage.Metadata<ButtonChange> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ButtonChange> = METADATA
  }
}