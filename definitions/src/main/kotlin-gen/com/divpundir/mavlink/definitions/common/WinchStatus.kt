package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * Winch status.
 */
@GeneratedMavMessage(
  id = 9_005u,
  crcExtra = 117,
)
public data class WinchStatus(
  /**
   * Timestamp (synced to UNIX time or since system boot).
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Length of line released. NaN if unknown
   */
  @GeneratedMavField(type = "float")
  public val lineLength: Float = 0F,
  /**
   * Speed line is being released or retracted. Positive values if being released, negative values
   * if being retracted, NaN if unknown
   */
  @GeneratedMavField(type = "float")
  public val speed: Float = 0F,
  /**
   * Tension on the line. NaN if unknown
   */
  @GeneratedMavField(type = "float")
  public val tension: Float = 0F,
  /**
   * Voltage of the battery supplying the winch. NaN if unknown
   */
  @GeneratedMavField(type = "float")
  public val voltage: Float = 0F,
  /**
   * Current draw from the winch. NaN if unknown
   */
  @GeneratedMavField(type = "float")
  public val current: Float = 0F,
  /**
   * Temperature of the motor. INT16_MAX if unknown
   */
  @GeneratedMavField(type = "int16_t")
  public val temperature: Short = 0,
  /**
   * Status flags
   */
  @GeneratedMavField(type = "uint32_t")
  public val status: MavBitmaskValue<MavWinchStatusFlag> = MavBitmaskValue.fromValue(0u),
) : MavMessage<WinchStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<WinchStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(lineLength)
    outputBuffer.encodeFloat(speed)
    outputBuffer.encodeFloat(tension)
    outputBuffer.encodeFloat(voltage)
    outputBuffer.encodeFloat(current)
    outputBuffer.encodeBitmaskValue(status.value, 4)
    outputBuffer.encodeInt16(temperature)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(lineLength)
    outputBuffer.encodeFloat(speed)
    outputBuffer.encodeFloat(tension)
    outputBuffer.encodeFloat(voltage)
    outputBuffer.encodeFloat(current)
    outputBuffer.encodeBitmaskValue(status.value, 4)
    outputBuffer.encodeInt16(temperature)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<WinchStatus> {
    private const val SIZE_V1: Int = 34

    private const val SIZE_V2: Int = 34

    public override val id: UInt = 9_005u

    public override val crcExtra: Byte = 117

    public override fun deserialize(bytes: ByteArray): WinchStatus {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val lineLength = inputBuffer.decodeFloat()
      val speed = inputBuffer.decodeFloat()
      val tension = inputBuffer.decodeFloat()
      val voltage = inputBuffer.decodeFloat()
      val current = inputBuffer.decodeFloat()
      val status = inputBuffer.decodeBitmaskValue(4).let { value ->
        val flags = MavWinchStatusFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val temperature = inputBuffer.decodeInt16()

      return WinchStatus(
        timeUsec = timeUsec,
        lineLength = lineLength,
        speed = speed,
        tension = tension,
        voltage = voltage,
        current = current,
        temperature = temperature,
        status = status,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): WinchStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var lineLength: Float = 0F

    public var speed: Float = 0F

    public var tension: Float = 0F

    public var voltage: Float = 0F

    public var current: Float = 0F

    public var temperature: Short = 0

    public var status: MavBitmaskValue<MavWinchStatusFlag> = MavBitmaskValue.fromValue(0u)

    public fun build(): WinchStatus = WinchStatus(
      timeUsec = timeUsec,
      lineLength = lineLength,
      speed = speed,
      tension = tension,
      voltage = voltage,
      current = current,
      temperature = temperature,
      status = status,
    )
  }
}
