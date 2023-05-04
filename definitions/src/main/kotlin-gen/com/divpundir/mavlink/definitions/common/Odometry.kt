package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List

/**
 * Odometry message to communicate odometry information with an external interface. Fits ROS REP 147
 * standard for aerial vehicles (http://www.ros.org/reps/rep-0147.html).
 */
@GeneratedMavMessage(
  id = 331u,
  crcExtra = 91,
)
public data class Odometry(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Coordinate frame of reference for the pose data.
   */
  @GeneratedMavField(type = "uint8_t")
  public val frameId: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u),
  /**
   * Coordinate frame of reference for the velocity in free space (twist) data.
   */
  @GeneratedMavField(type = "uint8_t")
  public val childFrameId: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u),
  /**
   * X Position
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * Y Position
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * Z Position
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
  /**
   * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation)
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
  /**
   * X linear speed
   */
  @GeneratedMavField(type = "float")
  public val vx: Float = 0F,
  /**
   * Y linear speed
   */
  @GeneratedMavField(type = "float")
  public val vy: Float = 0F,
  /**
   * Z linear speed
   */
  @GeneratedMavField(type = "float")
  public val vz: Float = 0F,
  /**
   * Roll angular speed
   */
  @GeneratedMavField(type = "float")
  public val rollspeed: Float = 0F,
  /**
   * Pitch angular speed
   */
  @GeneratedMavField(type = "float")
  public val pitchspeed: Float = 0F,
  /**
   * Yaw angular speed
   */
  @GeneratedMavField(type = "float")
  public val yawspeed: Float = 0F,
  /**
   * Row-major representation of a 6x6 pose cross-covariance matrix upper right triangle (states: x,
   * y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries are the second ROW,
   * etc.). If unknown, assign NaN value to first element in the array.
   */
  @GeneratedMavField(type = "float[21]")
  public val poseCovariance: List<Float> = emptyList(),
  /**
   * Row-major representation of a 6x6 velocity cross-covariance matrix upper right triangle
   * (states: vx, vy, vz, rollspeed, pitchspeed, yawspeed; first six entries are the first ROW, next
   * five entries are the second ROW, etc.). If unknown, assign NaN value to first element in the
   * array.
   */
  @GeneratedMavField(type = "float[21]")
  public val velocityCovariance: List<Float> = emptyList(),
  /**
   * Estimate reset counter. This should be incremented when the estimate resets in any of the
   * dimensions (position, velocity, attitude, angular speed). This is designed to be used when e.g an
   * external SLAM system detects a loop-closure and the estimate jumps.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val resetCounter: UByte = 0u,
  /**
   * Type of estimator that is providing the odometry.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val estimatorType: MavEnumValue<MavEstimatorType> = MavEnumValue.fromValue(0u),
) : MavMessage<Odometry> {
  public override val instanceMetadata: MavMessage.Metadata<Odometry> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeFloat(vx)
    outputBuffer.encodeFloat(vy)
    outputBuffer.encodeFloat(vz)
    outputBuffer.encodeFloat(rollspeed)
    outputBuffer.encodeFloat(pitchspeed)
    outputBuffer.encodeFloat(yawspeed)
    outputBuffer.encodeFloatArray(poseCovariance, 84)
    outputBuffer.encodeFloatArray(velocityCovariance, 84)
    outputBuffer.encodeEnumValue(frameId.value, 1)
    outputBuffer.encodeEnumValue(childFrameId.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeFloat(vx)
    outputBuffer.encodeFloat(vy)
    outputBuffer.encodeFloat(vz)
    outputBuffer.encodeFloat(rollspeed)
    outputBuffer.encodeFloat(pitchspeed)
    outputBuffer.encodeFloat(yawspeed)
    outputBuffer.encodeFloatArray(poseCovariance, 84)
    outputBuffer.encodeFloatArray(velocityCovariance, 84)
    outputBuffer.encodeEnumValue(frameId.value, 1)
    outputBuffer.encodeEnumValue(childFrameId.value, 1)
    outputBuffer.encodeUInt8(resetCounter)
    outputBuffer.encodeEnumValue(estimatorType.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 331u

    private const val CRC_EXTRA: Byte = 91

    private const val SIZE_V1: Int = 230

    private const val SIZE_V2: Int = 232

    private val DESERIALIZER: MavDeserializer<Odometry> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val x = inputBuffer.decodeFloat()
      val y = inputBuffer.decodeFloat()
      val z = inputBuffer.decodeFloat()
      val q = inputBuffer.decodeFloatArray(16)
      val vx = inputBuffer.decodeFloat()
      val vy = inputBuffer.decodeFloat()
      val vz = inputBuffer.decodeFloat()
      val rollspeed = inputBuffer.decodeFloat()
      val pitchspeed = inputBuffer.decodeFloat()
      val yawspeed = inputBuffer.decodeFloat()
      val poseCovariance = inputBuffer.decodeFloatArray(84)
      val velocityCovariance = inputBuffer.decodeFloatArray(84)
      val frameId = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val childFrameId = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val resetCounter = inputBuffer.decodeUInt8()
      val estimatorType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavEstimatorType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      Odometry(
        timeUsec = timeUsec,
        frameId = frameId,
        childFrameId = childFrameId,
        x = x,
        y = y,
        z = z,
        q = q,
        vx = vx,
        vy = vy,
        vz = vz,
        rollspeed = rollspeed,
        pitchspeed = pitchspeed,
        yawspeed = yawspeed,
        poseCovariance = poseCovariance,
        velocityCovariance = velocityCovariance,
        resetCounter = resetCounter,
        estimatorType = estimatorType,
      )
    }


    private val METADATA: MavMessage.Metadata<Odometry> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Odometry> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Odometry =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var frameId: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u)

    public var childFrameId: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u)

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public var q: List<Float> = emptyList()

    public var vx: Float = 0F

    public var vy: Float = 0F

    public var vz: Float = 0F

    public var rollspeed: Float = 0F

    public var pitchspeed: Float = 0F

    public var yawspeed: Float = 0F

    public var poseCovariance: List<Float> = emptyList()

    public var velocityCovariance: List<Float> = emptyList()

    public var resetCounter: UByte = 0u

    public var estimatorType: MavEnumValue<MavEstimatorType> = MavEnumValue.fromValue(0u)

    public fun build(): Odometry = Odometry(
      timeUsec = timeUsec,
      frameId = frameId,
      childFrameId = childFrameId,
      x = x,
      y = y,
      z = z,
      q = q,
      vx = vx,
      vy = vy,
      vz = vz,
      rollspeed = rollspeed,
      pitchspeed = pitchspeed,
      yawspeed = yawspeed,
      poseCovariance = poseCovariance,
      velocityCovariance = velocityCovariance,
      resetCounter = resetCounter,
      estimatorType = estimatorType,
    )
  }
}