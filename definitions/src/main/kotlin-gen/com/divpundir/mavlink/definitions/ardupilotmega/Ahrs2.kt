package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Status of secondary AHRS filter if available.
 */
@GeneratedMavMessage(
  id = 178u,
  crcExtra = 47,
)
public data class Ahrs2(
  /**
   * Roll angle.
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Pitch angle.
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw angle.
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * Altitude (MSL).
   */
  @GeneratedMavField(type = "float")
  public val altitude: Float = 0F,
  /**
   * Latitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val lng: Int = 0,
) : MavMessage<Ahrs2> {
  public override val instanceCompanion: MavMessage.MavCompanion<Ahrs2> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(altitude)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(altitude)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Ahrs2> {
    private const val SIZE_V1: Int = 24

    private const val SIZE_V2: Int = 24

    public override val id: UInt = 178u

    public override val crcExtra: Byte = 47

    public override fun deserialize(bytes: ByteArray): Ahrs2 {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val roll = inputBuffer.decodeFloat()
      val pitch = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val altitude = inputBuffer.decodeFloat()
      val lat = inputBuffer.decodeInt32()
      val lng = inputBuffer.decodeInt32()

      return Ahrs2(
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        altitude = altitude,
        lat = lat,
        lng = lng,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Ahrs2 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var altitude: Float = 0F

    public var lat: Int = 0

    public var lng: Int = 0

    public fun build(): Ahrs2 = Ahrs2(
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      altitude = altitude,
      lat = lat,
      lng = lng,
    )
  }
}
