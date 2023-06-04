package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16Array
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt16Array
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * Terrain data sent from GCS. The lat/lon and grid_spacing must be the same as a lat/lon from a
 * TERRAIN_REQUEST. See terrain protocol docs: https://mavlink.io/en/services/terrain.html
 */
@GeneratedMavMessage(
  id = 134u,
  crcExtra = -27,
)
public data class TerrainData(
  /**
   * Latitude of SW corner of first grid
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude of SW corner of first grid
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Grid spacing
   */
  @GeneratedMavField(type = "uint16_t")
  public val gridSpacing: UShort = 0u,
  /**
   * bit within the terrain request mask
   */
  @GeneratedMavField(type = "uint8_t")
  public val gridbit: UByte = 0u,
  /**
   * Terrain data MSL
   */
  @GeneratedMavField(type = "int16_t[16]")
  public val `data`: List<Short> = emptyList(),
) : MavMessage<TerrainData> {
  public override val instanceCompanion: MavMessage.MavCompanion<TerrainData> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeUInt16(gridSpacing)
    outputBuffer.encodeInt16Array(data, 32)
    outputBuffer.encodeUInt8(gridbit)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeUInt16(gridSpacing)
    outputBuffer.encodeInt16Array(data, 32)
    outputBuffer.encodeUInt8(gridbit)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<TerrainData> {
    private const val SIZE_V1: Int = 43

    private const val SIZE_V2: Int = 43

    public override val id: UInt = 134u

    public override val crcExtra: Byte = -27

    public override fun deserialize(bytes: ByteArray): TerrainData {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val gridSpacing = inputBuffer.decodeUInt16()
      val data = inputBuffer.decodeInt16Array(32)
      val gridbit = inputBuffer.decodeUInt8()

      return TerrainData(
        lat = lat,
        lon = lon,
        gridSpacing = gridSpacing,
        gridbit = gridbit,
        data = data,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): TerrainData =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var lat: Int = 0

    public var lon: Int = 0

    public var gridSpacing: UShort = 0u

    public var gridbit: UByte = 0u

    public var `data`: List<Short> = emptyList()

    public fun build(): TerrainData = TerrainData(
      lat = lat,
      lon = lon,
      gridSpacing = gridSpacing,
      gridbit = gridbit,
      data = data,
    )
  }
}
