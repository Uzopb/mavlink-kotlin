package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
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
 * Setpoint in roll, pitch, yaw and thrust from the operator
 */
@GeneratedMavMessage(
  id = 81u,
  crcExtra = 106,
)
public data class ManualSetpoint(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Desired roll rate
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Desired pitch rate
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Desired yaw rate
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * Collective thrust, normalized to 0 .. 1
   */
  @GeneratedMavField(type = "float")
  public val thrust: Float = 0F,
  /**
   * Flight mode switch position, 0.. 255
   */
  @GeneratedMavField(type = "uint8_t")
  public val modeSwitch: UByte = 0u,
  /**
   * Override mode switch position, 0.. 255
   */
  @GeneratedMavField(type = "uint8_t")
  public val manualOverrideSwitch: UByte = 0u,
) : MavMessage<ManualSetpoint> {
  public override val instanceCompanion: MavMessage.MavCompanion<ManualSetpoint> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(thrust)
    encoder.encodeUInt8(modeSwitch)
    encoder.encodeUInt8(manualOverrideSwitch)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(thrust)
    encoder.encodeUInt8(modeSwitch)
    encoder.encodeUInt8(manualOverrideSwitch)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ManualSetpoint> {
    private const val SIZE_V1: Int = 22

    private const val SIZE_V2: Int = 22

    public override val id: UInt = 81u

    public override val crcExtra: Byte = 106

    public override fun deserialize(bytes: ByteArray): ManualSetpoint {
      val decoder = MavDataDecoder.wrap(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val roll = decoder.safeDecodeFloat()
      val pitch = decoder.safeDecodeFloat()
      val yaw = decoder.safeDecodeFloat()
      val thrust = decoder.safeDecodeFloat()
      val modeSwitch = decoder.safeDecodeUInt8()
      val manualOverrideSwitch = decoder.safeDecodeUInt8()

      return ManualSetpoint(
        timeBootMs = timeBootMs,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        thrust = thrust,
        modeSwitch = modeSwitch,
        manualOverrideSwitch = manualOverrideSwitch,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ManualSetpoint =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var thrust: Float = 0F

    public var modeSwitch: UByte = 0u

    public var manualOverrideSwitch: UByte = 0u

    public fun build(): ManualSetpoint = ManualSetpoint(
      timeBootMs = timeBootMs,
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      thrust = thrust,
      modeSwitch = modeSwitch,
      manualOverrideSwitch = manualOverrideSwitch,
    )
  }
}
