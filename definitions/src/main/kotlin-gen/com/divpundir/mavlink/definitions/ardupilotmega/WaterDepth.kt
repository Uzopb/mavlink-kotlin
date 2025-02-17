package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Water depth
 */
@GeneratedMavMessage(
  id = 11_038u,
  crcExtra = 47,
)
public data class WaterDepth(
  /**
   * Timestamp (time since system boot)
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Onboard ID of the sensor
   */
  @GeneratedMavField(type = "uint8_t")
  public val id: UByte = 0u,
  /**
   * Sensor data healthy (0=unhealthy, 1=healthy)
   */
  @GeneratedMavField(type = "uint8_t")
  public val healthy: UByte = 0u,
  /**
   * Latitude
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude
   */
  @GeneratedMavField(type = "int32_t")
  public val lng: Int = 0,
  /**
   * Altitude (MSL) of vehicle
   */
  @GeneratedMavField(type = "float")
  public val alt: Float = 0F,
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
   * Distance (uncorrected)
   */
  @GeneratedMavField(type = "float")
  public val distance: Float = 0F,
  /**
   * Water temperature
   */
  @GeneratedMavField(type = "float")
  public val temperature: Float = 0F,
) : MavMessage<WaterDepth> {
  public override val instanceCompanion: MavMessage.MavCompanion<WaterDepth> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lng)
    encoder.encodeFloat(alt)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(distance)
    encoder.encodeFloat(temperature)
    encoder.encodeUInt8(id)
    encoder.encodeUInt8(healthy)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lng)
    encoder.encodeFloat(alt)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(distance)
    encoder.encodeFloat(temperature)
    encoder.encodeUInt8(id)
    encoder.encodeUInt8(healthy)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<WaterDepth> {
    private const val SIZE_V1: Int = 38

    private const val SIZE_V2: Int = 38

    public override val id: UInt = 11_038u

    public override val crcExtra: Byte = 47

    public override fun deserialize(bytes: ByteArray): WaterDepth {
      val decoder = MavDataDecoder.wrap(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val lat = decoder.safeDecodeInt32()
      val lng = decoder.safeDecodeInt32()
      val alt = decoder.safeDecodeFloat()
      val roll = decoder.safeDecodeFloat()
      val pitch = decoder.safeDecodeFloat()
      val yaw = decoder.safeDecodeFloat()
      val distance = decoder.safeDecodeFloat()
      val temperature = decoder.safeDecodeFloat()
      val id = decoder.safeDecodeUInt8()
      val healthy = decoder.safeDecodeUInt8()

      return WaterDepth(
        timeBootMs = timeBootMs,
        id = id,
        healthy = healthy,
        lat = lat,
        lng = lng,
        alt = alt,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        distance = distance,
        temperature = temperature,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): WaterDepth =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var id: UByte = 0u

    public var healthy: UByte = 0u

    public var lat: Int = 0

    public var lng: Int = 0

    public var alt: Float = 0F

    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var distance: Float = 0F

    public var temperature: Float = 0F

    public fun build(): WaterDepth = WaterDepth(
      timeBootMs = timeBootMs,
      id = id,
      healthy = healthy,
      lat = lat,
      lng = lng,
      alt = alt,
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      distance = distance,
      temperature = temperature,
    )
  }
}
