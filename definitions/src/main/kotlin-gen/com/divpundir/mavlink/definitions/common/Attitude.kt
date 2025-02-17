package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * The attitude in the aeronautical frame (right-handed, Z-down, Y-right, X-front, ZYX, intrinsic).
 */
@GeneratedMavMessage(
  id = 30u,
  crcExtra = 39,
)
public data class Attitude(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Roll angle (-pi..+pi)
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Pitch angle (-pi..+pi)
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw angle (-pi..+pi)
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
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
) : MavMessage<Attitude> {
  public override val instanceCompanion: MavMessage.MavCompanion<Attitude> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(rollspeed)
    encoder.encodeFloat(pitchspeed)
    encoder.encodeFloat(yawspeed)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(rollspeed)
    encoder.encodeFloat(pitchspeed)
    encoder.encodeFloat(yawspeed)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Attitude> {
    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    public override val id: UInt = 30u

    public override val crcExtra: Byte = 39

    public override fun deserialize(bytes: ByteArray): Attitude {
      val decoder = MavDataDecoder.wrap(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val roll = decoder.safeDecodeFloat()
      val pitch = decoder.safeDecodeFloat()
      val yaw = decoder.safeDecodeFloat()
      val rollspeed = decoder.safeDecodeFloat()
      val pitchspeed = decoder.safeDecodeFloat()
      val yawspeed = decoder.safeDecodeFloat()

      return Attitude(
        timeBootMs = timeBootMs,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        rollspeed = rollspeed,
        pitchspeed = pitchspeed,
        yawspeed = yawspeed,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Attitude =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var rollspeed: Float = 0F

    public var pitchspeed: Float = 0F

    public var yawspeed: Float = 0F

    public fun build(): Attitude = Attitude(
      timeBootMs = timeBootMs,
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      rollspeed = rollspeed,
      pitchspeed = pitchspeed,
      yawspeed = yawspeed,
    )
  }
}
