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
 * The offset in X, Y, Z and yaw between the LOCAL_POSITION_NED messages of MAV X and the global
 * coordinate frame in NED coordinates. Coordinate frame is right-handed, Z-axis down (aeronautical
 * frame, NED / north-east-down convention)
 */
@GeneratedMavMessage(
  id = 89u,
  crcExtra = -25,
)
public data class LocalPositionNedSystemGlobalOffset(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
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
   * Roll
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Pitch
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
) : MavMessage<LocalPositionNedSystemGlobalOffset> {
  public override val instanceCompanion: MavMessage.MavCompanion<LocalPositionNedSystemGlobalOffset>
      = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
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
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LocalPositionNedSystemGlobalOffset> {
    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    public override val id: UInt = 89u

    public override val crcExtra: Byte = -25

    public override fun deserialize(bytes: ByteArray): LocalPositionNedSystemGlobalOffset {
      val decoder = MavDataDecoder.wrap(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val x = decoder.safeDecodeFloat()
      val y = decoder.safeDecodeFloat()
      val z = decoder.safeDecodeFloat()
      val roll = decoder.safeDecodeFloat()
      val pitch = decoder.safeDecodeFloat()
      val yaw = decoder.safeDecodeFloat()

      return LocalPositionNedSystemGlobalOffset(
        timeBootMs = timeBootMs,
        x = x,
        y = y,
        z = z,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit):
        LocalPositionNedSystemGlobalOffset = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public fun build(): LocalPositionNedSystemGlobalOffset = LocalPositionNedSystemGlobalOffset(
      timeBootMs = timeBootMs,
      x = x,
      y = y,
      z = z,
      roll = roll,
      pitch = pitch,
      yaw = yaw,
    )
  }
}
