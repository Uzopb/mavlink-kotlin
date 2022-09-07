package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Camera Capture Feedback.
 */
@GeneratedMavMessage(
  id = 180,
  crc = 52,
)
public data class CameraFeedback(
  /**
   * Image timestamp (since UNIX epoch), as passed in by CAMERA_STATUS message (or autopilot if no
   * CCB).
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
  /**
   * Camera ID.
   */
  public val camIdx: Int = 0,
  /**
   * Image index.
   */
  public val imgIdx: Int = 0,
  /**
   * Latitude.
   */
  public val lat: Int = 0,
  /**
   * Longitude.
   */
  public val lng: Int = 0,
  /**
   * Altitude (MSL).
   */
  public val altMsl: Float = 0F,
  /**
   * Altitude (Relative to HOME location).
   */
  public val altRel: Float = 0F,
  /**
   * Camera Roll angle (earth frame, +-180).
   */
  public val roll: Float = 0F,
  /**
   * Camera Pitch angle (earth frame, +-180).
   */
  public val pitch: Float = 0F,
  /**
   * Camera Yaw (earth frame, 0-360, true).
   */
  public val yaw: Float = 0F,
  /**
   * Focal Length.
   */
  public val focLen: Float = 0F,
  /**
   * Feedback flags.
   */
  public val flags: MavEnumValue<CameraFeedbackFlags> = MavEnumValue.fromValue(0),
  /**
   * Completed image captures.
   */
  public val completedCaptures: Int = 0,
) : MavMessage<CameraFeedback> {
  public override val instanceMetadata: MavMessage.Metadata<CameraFeedback> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    outputBuffer.encodeFloat(altMsl)
    outputBuffer.encodeFloat(altRel)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(focLen)
    outputBuffer.encodeUint16(imgIdx)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(camIdx)
    outputBuffer.encodeEnumValue(flags.value, 1)
    outputBuffer.encodeUint16(completedCaptures)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 180

    private const val CRC: Int = 52

    private const val SIZE: Int = 47

    private val DESERIALIZER: MavDeserializer<CameraFeedback> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val lat = inputBuffer.decodeInt32()
      val lng = inputBuffer.decodeInt32()
      val altMsl = inputBuffer.decodeFloat()
      val altRel = inputBuffer.decodeFloat()
      val roll = inputBuffer.decodeFloat()
      val pitch = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val focLen = inputBuffer.decodeFloat()
      val imgIdx = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val camIdx = inputBuffer.decodeUint8()
      val flags = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = CameraFeedbackFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val completedCaptures = inputBuffer.decodeUint16()

      CameraFeedback(
        timeUsec = timeUsec,
        targetSystem = targetSystem,
        camIdx = camIdx,
        imgIdx = imgIdx,
        lat = lat,
        lng = lng,
        altMsl = altMsl,
        altRel = altRel,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        focLen = focLen,
        flags = flags,
        completedCaptures = completedCaptures,
      )
    }


    private val METADATA: MavMessage.Metadata<CameraFeedback> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CameraFeedback> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: BigInteger = BigInteger.ZERO

    public var targetSystem: Int = 0

    public var camIdx: Int = 0

    public var imgIdx: Int = 0

    public var lat: Int = 0

    public var lng: Int = 0

    public var altMsl: Float = 0F

    public var altRel: Float = 0F

    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var focLen: Float = 0F

    public var flags: MavEnumValue<CameraFeedbackFlags> = MavEnumValue.fromValue(0)

    public var completedCaptures: Int = 0

    public fun build(): CameraFeedback = CameraFeedback(
      timeUsec = timeUsec,
      targetSystem = targetSystem,
      camIdx = camIdx,
      imgIdx = imgIdx,
      lat = lat,
      lng = lng,
      altMsl = altMsl,
      altRel = altRel,
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      focLen = focLen,
      flags = flags,
      completedCaptures = completedCaptures,
    )
  }
}
