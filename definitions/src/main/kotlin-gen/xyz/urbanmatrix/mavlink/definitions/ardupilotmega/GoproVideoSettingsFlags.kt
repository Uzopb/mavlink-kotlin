package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

@GeneratedMavEnum(bitmask = true)
public enum class GoproVideoSettingsFlags(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * 0=NTSC, 1=PAL.
   */
  @GeneratedMavEnumEntry
  GOPRO_VIDEO_SETTINGS_TV_MODE(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproVideoSettingsFlags? = when (v) {
      1L -> GOPRO_VIDEO_SETTINGS_TV_MODE
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<GoproVideoSettingsFlags> = buildList {
      if (v and 1L == 1L) add(GOPRO_VIDEO_SETTINGS_TV_MODE)
    }
  }
}
