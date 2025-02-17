package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
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
 * Local position/attitude estimate from a vision source.
 */
@GeneratedMavMessage(
  id = 102u,
  crcExtra = -98,
)
public data class VisionPositionEstimate(
  /**
   * Timestamp (UNIX time or time since system boot)
   */
  @GeneratedMavField(type = "uint64_t")
  public val usec: ULong = 0uL,
  /**
   * Local X position
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * Local Y position
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * Local Z position
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
  /**
   * Roll angle
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Pitch angle
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw angle
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * Row-major representation of pose 6x6 cross-covariance matrix upper right triangle (states: x,
   * y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries are the second ROW,
   * etc.). If unknown, assign NaN value to first element in the array.
   */
  @GeneratedMavField(
    type = "float[21]",
    extension = true,
  )
  public val covariance: List<Float> = emptyList(),
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
) : MavMessage<VisionPositionEstimate> {
  public override val instanceCompanion: MavMessage.MavCompanion<VisionPositionEstimate> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt64(usec)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt64(usec)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloatArray(covariance, 84)
    encoder.encodeUInt8(resetCounter)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<VisionPositionEstimate> {
    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 117

    public override val id: UInt = 102u

    public override val crcExtra: Byte = -98

    public override fun deserialize(bytes: ByteArray): VisionPositionEstimate {
      val decoder = MavDataDecoder.wrap(bytes)

      val usec = decoder.safeDecodeUInt64()
      val x = decoder.safeDecodeFloat()
      val y = decoder.safeDecodeFloat()
      val z = decoder.safeDecodeFloat()
      val roll = decoder.safeDecodeFloat()
      val pitch = decoder.safeDecodeFloat()
      val yaw = decoder.safeDecodeFloat()
      val covariance = decoder.safeDecodeFloatArray(84)
      val resetCounter = decoder.safeDecodeUInt8()

      return VisionPositionEstimate(
        usec = usec,
        x = x,
        y = y,
        z = z,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        covariance = covariance,
        resetCounter = resetCounter,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): VisionPositionEstimate =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var usec: ULong = 0uL

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var covariance: List<Float> = emptyList()

    public var resetCounter: UByte = 0u

    public fun build(): VisionPositionEstimate = VisionPositionEstimate(
      usec = usec,
      x = x,
      y = y,
      z = z,
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      covariance = covariance,
      resetCounter = resetCounter,
    )
  }
}
