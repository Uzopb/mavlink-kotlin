package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
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
 * PID tuning information.
 */
@GeneratedMavMessage(
  id = 194u,
  crcExtra = 98,
)
public data class PidTuning(
  /**
   * Axis.
   */
  @GeneratedMavField(type = "uint8_t")
  public val axis: MavEnumValue<PidTuningAxis> = MavEnumValue.fromValue(0u),
  /**
   * Desired rate.
   */
  @GeneratedMavField(type = "float")
  public val desired: Float = 0F,
  /**
   * Achieved rate.
   */
  @GeneratedMavField(type = "float")
  public val achieved: Float = 0F,
  /**
   * FF component.
   */
  @GeneratedMavField(type = "float")
  public val ff: Float = 0F,
  /**
   * P component.
   */
  @GeneratedMavField(type = "float")
  public val p: Float = 0F,
  /**
   * I component.
   */
  @GeneratedMavField(type = "float")
  public val i: Float = 0F,
  /**
   * D component.
   */
  @GeneratedMavField(type = "float")
  public val d: Float = 0F,
  /**
   * Slew rate.
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val srate: Float = 0F,
  /**
   * P/D oscillation modifier.
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val pdmod: Float = 0F,
) : MavMessage<PidTuning> {
  public override val instanceMetadata: MavMessage.Metadata<PidTuning> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(desired)
    outputBuffer.encodeFloat(achieved)
    outputBuffer.encodeFloat(ff)
    outputBuffer.encodeFloat(p)
    outputBuffer.encodeFloat(i)
    outputBuffer.encodeFloat(d)
    outputBuffer.encodeEnumValue(axis.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(desired)
    outputBuffer.encodeFloat(achieved)
    outputBuffer.encodeFloat(ff)
    outputBuffer.encodeFloat(p)
    outputBuffer.encodeFloat(i)
    outputBuffer.encodeFloat(d)
    outputBuffer.encodeEnumValue(axis.value, 1)
    outputBuffer.encodeFloat(srate)
    outputBuffer.encodeFloat(pdmod)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 194u

    private const val CRC_EXTRA: Byte = 98

    private const val SIZE_V1: Int = 25

    private const val SIZE_V2: Int = 33

    private val DESERIALIZER: MavDeserializer<PidTuning> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val desired = inputBuffer.decodeFloat()
      val achieved = inputBuffer.decodeFloat()
      val ff = inputBuffer.decodeFloat()
      val p = inputBuffer.decodeFloat()
      val i = inputBuffer.decodeFloat()
      val d = inputBuffer.decodeFloat()
      val axis = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = PidTuningAxis.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val srate = inputBuffer.decodeFloat()
      val pdmod = inputBuffer.decodeFloat()

      PidTuning(
        axis = axis,
        desired = desired,
        achieved = achieved,
        ff = ff,
        p = p,
        i = i,
        d = d,
        srate = srate,
        pdmod = pdmod,
      )
    }


    private val METADATA: MavMessage.Metadata<PidTuning> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<PidTuning> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): PidTuning =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var axis: MavEnumValue<PidTuningAxis> = MavEnumValue.fromValue(0u)

    public var desired: Float = 0F

    public var achieved: Float = 0F

    public var ff: Float = 0F

    public var p: Float = 0F

    public var i: Float = 0F

    public var d: Float = 0F

    public var srate: Float = 0F

    public var pdmod: Float = 0F

    public fun build(): PidTuning = PidTuning(
      axis = axis,
      desired = desired,
      achieved = achieved,
      ff = ff,
      p = p,
      i = i,
      d = d,
      srate = srate,
      pdmod = pdmod,
    )
  }
}