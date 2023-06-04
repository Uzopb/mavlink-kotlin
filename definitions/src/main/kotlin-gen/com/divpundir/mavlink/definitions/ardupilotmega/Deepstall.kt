package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.encodeEnumValue
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
 * Deepstall path planning.
 */
@GeneratedMavMessage(
  id = 195u,
  crcExtra = 120,
)
public data class Deepstall(
  /**
   * Landing latitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val landingLat: Int = 0,
  /**
   * Landing longitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val landingLon: Int = 0,
  /**
   * Final heading start point, latitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val pathLat: Int = 0,
  /**
   * Final heading start point, longitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val pathLon: Int = 0,
  /**
   * Arc entry point, latitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val arcEntryLat: Int = 0,
  /**
   * Arc entry point, longitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val arcEntryLon: Int = 0,
  /**
   * Altitude.
   */
  @GeneratedMavField(type = "float")
  public val altitude: Float = 0F,
  /**
   * Distance the aircraft expects to travel during the deepstall.
   */
  @GeneratedMavField(type = "float")
  public val expectedTravelDistance: Float = 0F,
  /**
   * Deepstall cross track error (only valid when in DEEPSTALL_STAGE_LAND).
   */
  @GeneratedMavField(type = "float")
  public val crossTrackError: Float = 0F,
  /**
   * Deepstall stage.
   */
  @GeneratedMavField(type = "uint8_t")
  public val stage: MavEnumValue<DeepstallStage> = MavEnumValue.fromValue(0u),
) : MavMessage<Deepstall> {
  public override val instanceCompanion: MavMessage.MavCompanion<Deepstall> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(landingLat)
    outputBuffer.encodeInt32(landingLon)
    outputBuffer.encodeInt32(pathLat)
    outputBuffer.encodeInt32(pathLon)
    outputBuffer.encodeInt32(arcEntryLat)
    outputBuffer.encodeInt32(arcEntryLon)
    outputBuffer.encodeFloat(altitude)
    outputBuffer.encodeFloat(expectedTravelDistance)
    outputBuffer.encodeFloat(crossTrackError)
    outputBuffer.encodeEnumValue(stage.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(landingLat)
    outputBuffer.encodeInt32(landingLon)
    outputBuffer.encodeInt32(pathLat)
    outputBuffer.encodeInt32(pathLon)
    outputBuffer.encodeInt32(arcEntryLat)
    outputBuffer.encodeInt32(arcEntryLon)
    outputBuffer.encodeFloat(altitude)
    outputBuffer.encodeFloat(expectedTravelDistance)
    outputBuffer.encodeFloat(crossTrackError)
    outputBuffer.encodeEnumValue(stage.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Deepstall> {
    private const val SIZE_V1: Int = 37

    private const val SIZE_V2: Int = 37

    public override val id: UInt = 195u

    public override val crcExtra: Byte = 120

    public override fun deserialize(bytes: ByteArray): Deepstall {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val landingLat = inputBuffer.decodeInt32()
      val landingLon = inputBuffer.decodeInt32()
      val pathLat = inputBuffer.decodeInt32()
      val pathLon = inputBuffer.decodeInt32()
      val arcEntryLat = inputBuffer.decodeInt32()
      val arcEntryLon = inputBuffer.decodeInt32()
      val altitude = inputBuffer.decodeFloat()
      val expectedTravelDistance = inputBuffer.decodeFloat()
      val crossTrackError = inputBuffer.decodeFloat()
      val stage = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = DeepstallStage.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return Deepstall(
        landingLat = landingLat,
        landingLon = landingLon,
        pathLat = pathLat,
        pathLon = pathLon,
        arcEntryLat = arcEntryLat,
        arcEntryLon = arcEntryLon,
        altitude = altitude,
        expectedTravelDistance = expectedTravelDistance,
        crossTrackError = crossTrackError,
        stage = stage,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Deepstall =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var landingLat: Int = 0

    public var landingLon: Int = 0

    public var pathLat: Int = 0

    public var pathLon: Int = 0

    public var arcEntryLat: Int = 0

    public var arcEntryLon: Int = 0

    public var altitude: Float = 0F

    public var expectedTravelDistance: Float = 0F

    public var crossTrackError: Float = 0F

    public var stage: MavEnumValue<DeepstallStage> = MavEnumValue.fromValue(0u)

    public fun build(): Deepstall = Deepstall(
      landingLat = landingLat,
      landingLon = landingLon,
      pathLat = pathLat,
      pathLon = pathLon,
      arcEntryLat = arcEntryLat,
      arcEntryLon = arcEntryLon,
      altitude = altitude,
      expectedTravelDistance = expectedTravelDistance,
      crossTrackError = crossTrackError,
      stage = stage,
    )
  }
}
