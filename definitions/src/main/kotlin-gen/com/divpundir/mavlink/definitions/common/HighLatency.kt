package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.minimal.MavModeFlag
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Message appropriate for high latency connections like Iridium
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 234u,
  crcExtra = -106,
)
public data class HighLatency(
  /**
   * Bitmap of enabled system modes.
   */
  @GeneratedMavField(type = "uint8_t")
  public val baseMode: MavBitmaskValue<MavModeFlag> = MavBitmaskValue.fromValue(0u),
  /**
   * A bitfield for use for autopilot-specific flags.
   */
  @GeneratedMavField(type = "uint32_t")
  public val customMode: UInt = 0u,
  /**
   * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val landedState: MavEnumValue<MavLandedState> = MavEnumValue.fromValue(0u),
  /**
   * roll
   */
  @GeneratedMavField(type = "int16_t")
  public val roll: Short = 0,
  /**
   * pitch
   */
  @GeneratedMavField(type = "int16_t")
  public val pitch: Short = 0,
  /**
   * heading
   */
  @GeneratedMavField(type = "uint16_t")
  public val heading: UShort = 0u,
  /**
   * throttle (percentage)
   */
  @GeneratedMavField(type = "int8_t")
  public val throttle: Byte = 0,
  /**
   * heading setpoint
   */
  @GeneratedMavField(type = "int16_t")
  public val headingSp: Short = 0,
  /**
   * Latitude
   */
  @GeneratedMavField(type = "int32_t")
  public val latitude: Int = 0,
  /**
   * Longitude
   */
  @GeneratedMavField(type = "int32_t")
  public val longitude: Int = 0,
  /**
   * Altitude above mean sea level
   */
  @GeneratedMavField(type = "int16_t")
  public val altitudeAmsl: Short = 0,
  /**
   * Altitude setpoint relative to the home position
   */
  @GeneratedMavField(type = "int16_t")
  public val altitudeSp: Short = 0,
  /**
   * airspeed
   */
  @GeneratedMavField(type = "uint8_t")
  public val airspeed: UByte = 0u,
  /**
   * airspeed setpoint
   */
  @GeneratedMavField(type = "uint8_t")
  public val airspeedSp: UByte = 0u,
  /**
   * groundspeed
   */
  @GeneratedMavField(type = "uint8_t")
  public val groundspeed: UByte = 0u,
  /**
   * climb rate
   */
  @GeneratedMavField(type = "int8_t")
  public val climbRate: Byte = 0,
  /**
   * Number of satellites visible. If unknown, set to UINT8_MAX
   */
  @GeneratedMavField(type = "uint8_t")
  public val gpsNsat: UByte = 0u,
  /**
   * GPS Fix type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val gpsFixType: MavEnumValue<GpsFixType> = MavEnumValue.fromValue(0u),
  /**
   * Remaining battery (percentage)
   */
  @GeneratedMavField(type = "uint8_t")
  public val batteryRemaining: UByte = 0u,
  /**
   * Autopilot temperature (degrees C)
   */
  @GeneratedMavField(type = "int8_t")
  public val temperature: Byte = 0,
  /**
   * Air temperature (degrees C) from airspeed sensor
   */
  @GeneratedMavField(type = "int8_t")
  public val temperatureAir: Byte = 0,
  /**
   * failsafe (each bit represents a failsafe where 0=ok, 1=failsafe active (bit0:RC, bit1:batt,
   * bit2:GPS, bit3:GCS, bit4:fence)
   */
  @GeneratedMavField(type = "uint8_t")
  public val failsafe: UByte = 0u,
  /**
   * current waypoint number
   */
  @GeneratedMavField(type = "uint8_t")
  public val wpNum: UByte = 0u,
  /**
   * distance to target
   */
  @GeneratedMavField(type = "uint16_t")
  public val wpDistance: UShort = 0u,
) : MavMessage<HighLatency> {
  public override val instanceCompanion: MavMessage.MavCompanion<HighLatency> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt32(customMode)
    encoder.encodeInt32(latitude)
    encoder.encodeInt32(longitude)
    encoder.encodeInt16(roll)
    encoder.encodeInt16(pitch)
    encoder.encodeUInt16(heading)
    encoder.encodeInt16(headingSp)
    encoder.encodeInt16(altitudeAmsl)
    encoder.encodeInt16(altitudeSp)
    encoder.encodeUInt16(wpDistance)
    encoder.encodeBitmaskValue(baseMode.value, 1)
    encoder.encodeEnumValue(landedState.value, 1)
    encoder.encodeInt8(throttle)
    encoder.encodeUInt8(airspeed)
    encoder.encodeUInt8(airspeedSp)
    encoder.encodeUInt8(groundspeed)
    encoder.encodeInt8(climbRate)
    encoder.encodeUInt8(gpsNsat)
    encoder.encodeEnumValue(gpsFixType.value, 1)
    encoder.encodeUInt8(batteryRemaining)
    encoder.encodeInt8(temperature)
    encoder.encodeInt8(temperatureAir)
    encoder.encodeUInt8(failsafe)
    encoder.encodeUInt8(wpNum)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt32(customMode)
    encoder.encodeInt32(latitude)
    encoder.encodeInt32(longitude)
    encoder.encodeInt16(roll)
    encoder.encodeInt16(pitch)
    encoder.encodeUInt16(heading)
    encoder.encodeInt16(headingSp)
    encoder.encodeInt16(altitudeAmsl)
    encoder.encodeInt16(altitudeSp)
    encoder.encodeUInt16(wpDistance)
    encoder.encodeBitmaskValue(baseMode.value, 1)
    encoder.encodeEnumValue(landedState.value, 1)
    encoder.encodeInt8(throttle)
    encoder.encodeUInt8(airspeed)
    encoder.encodeUInt8(airspeedSp)
    encoder.encodeUInt8(groundspeed)
    encoder.encodeInt8(climbRate)
    encoder.encodeUInt8(gpsNsat)
    encoder.encodeEnumValue(gpsFixType.value, 1)
    encoder.encodeUInt8(batteryRemaining)
    encoder.encodeInt8(temperature)
    encoder.encodeInt8(temperatureAir)
    encoder.encodeUInt8(failsafe)
    encoder.encodeUInt8(wpNum)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HighLatency> {
    private const val SIZE_V1: Int = 40

    private const val SIZE_V2: Int = 40

    public override val id: UInt = 234u

    public override val crcExtra: Byte = -106

    public override fun deserialize(bytes: ByteArray): HighLatency {
      val decoder = MavDataDecoder.wrap(bytes)

      val customMode = decoder.safeDecodeUInt32()
      val latitude = decoder.safeDecodeInt32()
      val longitude = decoder.safeDecodeInt32()
      val roll = decoder.safeDecodeInt16()
      val pitch = decoder.safeDecodeInt16()
      val heading = decoder.safeDecodeUInt16()
      val headingSp = decoder.safeDecodeInt16()
      val altitudeAmsl = decoder.safeDecodeInt16()
      val altitudeSp = decoder.safeDecodeInt16()
      val wpDistance = decoder.safeDecodeUInt16()
      val baseMode = decoder.safeDecodeBitmaskValue(1).let { value ->
        val flags = MavModeFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val landedState = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavLandedState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val throttle = decoder.safeDecodeInt8()
      val airspeed = decoder.safeDecodeUInt8()
      val airspeedSp = decoder.safeDecodeUInt8()
      val groundspeed = decoder.safeDecodeUInt8()
      val climbRate = decoder.safeDecodeInt8()
      val gpsNsat = decoder.safeDecodeUInt8()
      val gpsFixType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = GpsFixType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val batteryRemaining = decoder.safeDecodeUInt8()
      val temperature = decoder.safeDecodeInt8()
      val temperatureAir = decoder.safeDecodeInt8()
      val failsafe = decoder.safeDecodeUInt8()
      val wpNum = decoder.safeDecodeUInt8()

      return HighLatency(
        baseMode = baseMode,
        customMode = customMode,
        landedState = landedState,
        roll = roll,
        pitch = pitch,
        heading = heading,
        throttle = throttle,
        headingSp = headingSp,
        latitude = latitude,
        longitude = longitude,
        altitudeAmsl = altitudeAmsl,
        altitudeSp = altitudeSp,
        airspeed = airspeed,
        airspeedSp = airspeedSp,
        groundspeed = groundspeed,
        climbRate = climbRate,
        gpsNsat = gpsNsat,
        gpsFixType = gpsFixType,
        batteryRemaining = batteryRemaining,
        temperature = temperature,
        temperatureAir = temperatureAir,
        failsafe = failsafe,
        wpNum = wpNum,
        wpDistance = wpDistance,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): HighLatency =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var baseMode: MavBitmaskValue<MavModeFlag> = MavBitmaskValue.fromValue(0u)

    public var customMode: UInt = 0u

    public var landedState: MavEnumValue<MavLandedState> = MavEnumValue.fromValue(0u)

    public var roll: Short = 0

    public var pitch: Short = 0

    public var heading: UShort = 0u

    public var throttle: Byte = 0

    public var headingSp: Short = 0

    public var latitude: Int = 0

    public var longitude: Int = 0

    public var altitudeAmsl: Short = 0

    public var altitudeSp: Short = 0

    public var airspeed: UByte = 0u

    public var airspeedSp: UByte = 0u

    public var groundspeed: UByte = 0u

    public var climbRate: Byte = 0

    public var gpsNsat: UByte = 0u

    public var gpsFixType: MavEnumValue<GpsFixType> = MavEnumValue.fromValue(0u)

    public var batteryRemaining: UByte = 0u

    public var temperature: Byte = 0

    public var temperatureAir: Byte = 0

    public var failsafe: UByte = 0u

    public var wpNum: UByte = 0u

    public var wpDistance: UShort = 0u

    public fun build(): HighLatency = HighLatency(
      baseMode = baseMode,
      customMode = customMode,
      landedState = landedState,
      roll = roll,
      pitch = pitch,
      heading = heading,
      throttle = throttle,
      headingSp = headingSp,
      latitude = latitude,
      longitude = longitude,
      altitudeAmsl = altitudeAmsl,
      altitudeSp = altitudeSp,
      airspeed = airspeed,
      airspeedSp = airspeedSp,
      groundspeed = groundspeed,
      climbRate = climbRate,
      gpsNsat = gpsNsat,
      gpsFixType = gpsFixType,
      batteryRemaining = batteryRemaining,
      temperature = temperature,
      temperatureAir = temperatureAir,
      failsafe = failsafe,
      wpNum = wpNum,
      wpDistance = wpDistance,
    )
  }
}
