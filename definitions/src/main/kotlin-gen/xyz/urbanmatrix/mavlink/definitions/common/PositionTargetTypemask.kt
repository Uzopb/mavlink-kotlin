package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Bitmap to indicate which dimensions should be ignored by the vehicle: a value of
 * 0b0000000000000000 or 0b0000001000000000 indicates that none of the setpoint dimensions should be
 * ignored. If bit 9 is set the floats afx afy afz should be interpreted as force instead of
 * acceleration.
 */
@GeneratedMavEnum(bitmask = true)
public enum class PositionTargetTypemask(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * Ignore position x
   */
  @GeneratedMavEnumEntry
  X_IGNORE(1L),
  /**
   * Ignore position y
   */
  @GeneratedMavEnumEntry
  Y_IGNORE(2L),
  /**
   * Ignore position z
   */
  @GeneratedMavEnumEntry
  Z_IGNORE(4L),
  /**
   * Ignore velocity x
   */
  @GeneratedMavEnumEntry
  VX_IGNORE(8L),
  /**
   * Ignore velocity y
   */
  @GeneratedMavEnumEntry
  VY_IGNORE(16L),
  /**
   * Ignore velocity z
   */
  @GeneratedMavEnumEntry
  VZ_IGNORE(32L),
  /**
   * Ignore acceleration x
   */
  @GeneratedMavEnumEntry
  AX_IGNORE(64L),
  /**
   * Ignore acceleration y
   */
  @GeneratedMavEnumEntry
  AY_IGNORE(128L),
  /**
   * Ignore acceleration z
   */
  @GeneratedMavEnumEntry
  AZ_IGNORE(256L),
  /**
   * Use force instead of acceleration
   */
  @GeneratedMavEnumEntry
  FORCE_SET(512L),
  /**
   * Ignore yaw
   */
  @GeneratedMavEnumEntry
  YAW_IGNORE(1024L),
  /**
   * Ignore yaw rate
   */
  @GeneratedMavEnumEntry
  YAW_RATE_IGNORE(2048L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): PositionTargetTypemask? = when (v) {
      1L -> X_IGNORE
      2L -> Y_IGNORE
      4L -> Z_IGNORE
      8L -> VX_IGNORE
      16L -> VY_IGNORE
      32L -> VZ_IGNORE
      64L -> AX_IGNORE
      128L -> AY_IGNORE
      256L -> AZ_IGNORE
      512L -> FORCE_SET
      1024L -> YAW_IGNORE
      2048L -> YAW_RATE_IGNORE
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<PositionTargetTypemask> = buildList {
      if (v and 1L == 1L) add(X_IGNORE)
      if (v and 2L == 2L) add(Y_IGNORE)
      if (v and 4L == 4L) add(Z_IGNORE)
      if (v and 8L == 8L) add(VX_IGNORE)
      if (v and 16L == 16L) add(VY_IGNORE)
      if (v and 32L == 32L) add(VZ_IGNORE)
      if (v and 64L == 64L) add(AX_IGNORE)
      if (v and 128L == 128L) add(AY_IGNORE)
      if (v and 256L == 256L) add(AZ_IGNORE)
      if (v and 512L == 512L) add(FORCE_SET)
      if (v and 1024L == 1024L) add(YAW_IGNORE)
      if (v and 2048L == 2048L) add(YAW_RATE_IGNORE)
    }
  }
}
