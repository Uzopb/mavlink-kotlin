package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class MavOdidVerAcc(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The vertical accuracy is unknown.
   */
  MAV_ODID_VER_ACC_UNKNOWN(0L),
  /**
   * The vertical accuracy is smaller than 150 meter.
   */
  MAV_ODID_VER_ACC_150_METER(1L),
  /**
   * The vertical accuracy is smaller than 45 meter.
   */
  MAV_ODID_VER_ACC_45_METER(2L),
  /**
   * The vertical accuracy is smaller than 25 meter.
   */
  MAV_ODID_VER_ACC_25_METER(3L),
  /**
   * The vertical accuracy is smaller than 10 meter.
   */
  MAV_ODID_VER_ACC_10_METER(4L),
  /**
   * The vertical accuracy is smaller than 3 meter.
   */
  MAV_ODID_VER_ACC_3_METER(5L),
  /**
   * The vertical accuracy is smaller than 1 meter.
   */
  MAV_ODID_VER_ACC_1_METER(6L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidVerAcc? = when (v) {
      0L -> MAV_ODID_VER_ACC_UNKNOWN
      1L -> MAV_ODID_VER_ACC_150_METER
      2L -> MAV_ODID_VER_ACC_45_METER
      3L -> MAV_ODID_VER_ACC_25_METER
      4L -> MAV_ODID_VER_ACC_10_METER
      5L -> MAV_ODID_VER_ACC_3_METER
      6L -> MAV_ODID_VER_ACC_1_METER
      else -> null
    }
  }
}
