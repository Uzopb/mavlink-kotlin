package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long

/**
 * Information about the status of a video stream. It may be requested using
 * MAV_CMD_REQUEST_MESSAGE.
 */
public data class VideoStreamStatus(
  /**
   * Frame rate
   */
  public val framerate: Float = 0F,
  /**
   * Bit rate
   */
  public val bitrate: Long = 0L,
  /**
   * Bitmap of stream status flags
   */
  public val flags: MavEnumValue<VideoStreamStatusFlags> = MavEnumValue.fromValue(0),
  /**
   * Horizontal resolution
   */
  public val resolutionH: Int = 0,
  /**
   * Vertical resolution
   */
  public val resolutionV: Int = 0,
  /**
   * Video image rotation clockwise
   */
  public val rotation: Int = 0,
  /**
   * Horizontal Field of view
   */
  public val hfov: Int = 0,
  /**
   * Video Stream ID (1 for first, 2 for second, etc.)
   */
  public val streamId: Int = 0,
) : MavMessage<VideoStreamStatus> {
  public override val instanceMetadata: MavMessage.Metadata<VideoStreamStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(19).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(framerate)
    outputBuffer.encodeUint32(bitrate)
    outputBuffer.encodeEnumValue(flags.value, 2)
    outputBuffer.encodeUint16(resolutionH)
    outputBuffer.encodeUint16(resolutionV)
    outputBuffer.encodeUint16(rotation)
    outputBuffer.encodeUint16(hfov)
    outputBuffer.encodeUint8(streamId)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 270

    private const val CRC: Int = 59

    private val DESERIALIZER: MavDeserializer<VideoStreamStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val framerate = inputBuffer.decodeFloat()
      val bitrate = inputBuffer.decodeUint32()
      val flags = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = VideoStreamStatusFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val resolutionH = inputBuffer.decodeUint16()
      val resolutionV = inputBuffer.decodeUint16()
      val rotation = inputBuffer.decodeUint16()
      val hfov = inputBuffer.decodeUint16()
      val streamId = inputBuffer.decodeUint8()
      VideoStreamStatus(
        framerate = framerate,
        bitrate = bitrate,
        flags = flags,
        resolutionH = resolutionH,
        resolutionV = resolutionV,
        rotation = rotation,
        hfov = hfov,
        streamId = streamId,
      )
    }


    private val METADATA: MavMessage.Metadata<VideoStreamStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<VideoStreamStatus> = METADATA
  }
}
