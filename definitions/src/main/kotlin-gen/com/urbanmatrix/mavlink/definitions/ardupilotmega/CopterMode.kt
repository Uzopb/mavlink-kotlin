package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * A mapping of copter flight modes for custom_mode field of heartbeat.
 */
@GeneratedMavEnum
public enum class CopterMode(
  public override val `value`: Long,
) : MavEnum {
  COPTER_MODE_STABILIZE(0L),
  COPTER_MODE_ACRO(1L),
  COPTER_MODE_ALT_HOLD(2L),
  COPTER_MODE_AUTO(3L),
  COPTER_MODE_GUIDED(4L),
  COPTER_MODE_LOITER(5L),
  COPTER_MODE_RTL(6L),
  COPTER_MODE_CIRCLE(7L),
  COPTER_MODE_LAND(9L),
  COPTER_MODE_DRIFT(11L),
  COPTER_MODE_SPORT(13L),
  COPTER_MODE_FLIP(14L),
  COPTER_MODE_AUTOTUNE(15L),
  COPTER_MODE_POSHOLD(16L),
  COPTER_MODE_BRAKE(17L),
  COPTER_MODE_THROW(18L),
  COPTER_MODE_AVOID_ADSB(19L),
  COPTER_MODE_GUIDED_NOGPS(20L),
  COPTER_MODE_SMART_RTL(21L),
  COPTER_MODE_FLOWHOLD(22L),
  COPTER_MODE_FOLLOW(23L),
  COPTER_MODE_ZIGZAG(24L),
  COPTER_MODE_SYSTEMID(25L),
  COPTER_MODE_AUTOROTATE(26L),
  COPTER_MODE_AUTO_RTL(27L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): CopterMode? = when (v) {
      0L -> COPTER_MODE_STABILIZE
      1L -> COPTER_MODE_ACRO
      2L -> COPTER_MODE_ALT_HOLD
      3L -> COPTER_MODE_AUTO
      4L -> COPTER_MODE_GUIDED
      5L -> COPTER_MODE_LOITER
      6L -> COPTER_MODE_RTL
      7L -> COPTER_MODE_CIRCLE
      9L -> COPTER_MODE_LAND
      11L -> COPTER_MODE_DRIFT
      13L -> COPTER_MODE_SPORT
      14L -> COPTER_MODE_FLIP
      15L -> COPTER_MODE_AUTOTUNE
      16L -> COPTER_MODE_POSHOLD
      17L -> COPTER_MODE_BRAKE
      18L -> COPTER_MODE_THROW
      19L -> COPTER_MODE_AVOID_ADSB
      20L -> COPTER_MODE_GUIDED_NOGPS
      21L -> COPTER_MODE_SMART_RTL
      22L -> COPTER_MODE_FLOWHOLD
      23L -> COPTER_MODE_FOLLOW
      24L -> COPTER_MODE_ZIGZAG
      25L -> COPTER_MODE_SYSTEMID
      26L -> COPTER_MODE_AUTOROTATE
      27L -> COPTER_MODE_AUTO_RTL
      else -> null
    }
  }
}
