package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting
 */
@GeneratedMavMessage(
  id = 128u,
  crcExtra = -30,
)
public data class Gps2Rtk(
  /**
   * Time since boot of last baseline message received.
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeLastBaselineMs: UInt = 0u,
  /**
   * Identification of connected RTK receiver.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rtkReceiverId: UByte = 0u,
  /**
   * GPS Week Number of last baseline
   */
  @GeneratedMavField(type = "uint16_t")
  public val wn: UShort = 0u,
  /**
   * GPS Time of Week of last baseline
   */
  @GeneratedMavField(type = "uint32_t")
  public val tow: UInt = 0u,
  /**
   * GPS-specific health report for RTK data.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rtkHealth: UByte = 0u,
  /**
   * Rate of baseline messages being received by GPS
   */
  @GeneratedMavField(type = "uint8_t")
  public val rtkRate: UByte = 0u,
  /**
   * Current number of sats used for RTK calculation.
   */
  @GeneratedMavField(type = "uint8_t")
  public val nsats: UByte = 0u,
  /**
   * Coordinate system of baseline
   */
  @GeneratedMavField(type = "uint8_t")
  public val baselineCoordsType: MavEnumValue<RtkBaselineCoordinateSystem> =
      MavEnumValue.fromValue(0u),
  /**
   * Current baseline in ECEF x or NED north component.
   */
  @GeneratedMavField(type = "int32_t")
  public val baselineAMm: Int = 0,
  /**
   * Current baseline in ECEF y or NED east component.
   */
  @GeneratedMavField(type = "int32_t")
  public val baselineBMm: Int = 0,
  /**
   * Current baseline in ECEF z or NED down component.
   */
  @GeneratedMavField(type = "int32_t")
  public val baselineCMm: Int = 0,
  /**
   * Current estimate of baseline accuracy.
   */
  @GeneratedMavField(type = "uint32_t")
  public val accuracy: UInt = 0u,
  /**
   * Current number of integer ambiguity hypotheses.
   */
  @GeneratedMavField(type = "int32_t")
  public val iarNumHypotheses: Int = 0,
) : MavMessage<Gps2Rtk> {
  public override val instanceCompanion: MavMessage.MavCompanion<Gps2Rtk> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt32(timeLastBaselineMs)
    encoder.encodeUInt32(tow)
    encoder.encodeInt32(baselineAMm)
    encoder.encodeInt32(baselineBMm)
    encoder.encodeInt32(baselineCMm)
    encoder.encodeUInt32(accuracy)
    encoder.encodeInt32(iarNumHypotheses)
    encoder.encodeUInt16(wn)
    encoder.encodeUInt8(rtkReceiverId)
    encoder.encodeUInt8(rtkHealth)
    encoder.encodeUInt8(rtkRate)
    encoder.encodeUInt8(nsats)
    encoder.encodeEnumValue(baselineCoordsType.value, 1)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt32(timeLastBaselineMs)
    encoder.encodeUInt32(tow)
    encoder.encodeInt32(baselineAMm)
    encoder.encodeInt32(baselineBMm)
    encoder.encodeInt32(baselineCMm)
    encoder.encodeUInt32(accuracy)
    encoder.encodeInt32(iarNumHypotheses)
    encoder.encodeUInt16(wn)
    encoder.encodeUInt8(rtkReceiverId)
    encoder.encodeUInt8(rtkHealth)
    encoder.encodeUInt8(rtkRate)
    encoder.encodeUInt8(nsats)
    encoder.encodeEnumValue(baselineCoordsType.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Gps2Rtk> {
    private const val SIZE_V1: Int = 35

    private const val SIZE_V2: Int = 35

    public override val id: UInt = 128u

    public override val crcExtra: Byte = -30

    public override fun deserialize(bytes: ByteArray): Gps2Rtk {
      val decoder = MavDataDecoder.wrap(bytes)

      val timeLastBaselineMs = decoder.safeDecodeUInt32()
      val tow = decoder.safeDecodeUInt32()
      val baselineAMm = decoder.safeDecodeInt32()
      val baselineBMm = decoder.safeDecodeInt32()
      val baselineCMm = decoder.safeDecodeInt32()
      val accuracy = decoder.safeDecodeUInt32()
      val iarNumHypotheses = decoder.safeDecodeInt32()
      val wn = decoder.safeDecodeUInt16()
      val rtkReceiverId = decoder.safeDecodeUInt8()
      val rtkHealth = decoder.safeDecodeUInt8()
      val rtkRate = decoder.safeDecodeUInt8()
      val nsats = decoder.safeDecodeUInt8()
      val baselineCoordsType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = RtkBaselineCoordinateSystem.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return Gps2Rtk(
        timeLastBaselineMs = timeLastBaselineMs,
        rtkReceiverId = rtkReceiverId,
        wn = wn,
        tow = tow,
        rtkHealth = rtkHealth,
        rtkRate = rtkRate,
        nsats = nsats,
        baselineCoordsType = baselineCoordsType,
        baselineAMm = baselineAMm,
        baselineBMm = baselineBMm,
        baselineCMm = baselineCMm,
        accuracy = accuracy,
        iarNumHypotheses = iarNumHypotheses,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Gps2Rtk =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeLastBaselineMs: UInt = 0u

    public var rtkReceiverId: UByte = 0u

    public var wn: UShort = 0u

    public var tow: UInt = 0u

    public var rtkHealth: UByte = 0u

    public var rtkRate: UByte = 0u

    public var nsats: UByte = 0u

    public var baselineCoordsType: MavEnumValue<RtkBaselineCoordinateSystem> =
        MavEnumValue.fromValue(0u)

    public var baselineAMm: Int = 0

    public var baselineBMm: Int = 0

    public var baselineCMm: Int = 0

    public var accuracy: UInt = 0u

    public var iarNumHypotheses: Int = 0

    public fun build(): Gps2Rtk = Gps2Rtk(
      timeLastBaselineMs = timeLastBaselineMs,
      rtkReceiverId = rtkReceiverId,
      wn = wn,
      tow = tow,
      rtkHealth = rtkHealth,
      rtkRate = rtkRate,
      nsats = nsats,
      baselineCoordsType = baselineCoordsType,
      baselineAMm = baselineAMm,
      baselineBMm = baselineBMm,
      baselineCMm = baselineCMm,
      accuracy = accuracy,
      iarNumHypotheses = iarNumHypotheses,
    )
  }
}
