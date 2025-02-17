package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit

/**
 * Send a key-value pair as integer. The use of this message is discouraged for normal packets, but
 * a quite efficient way for testing new messages and getting experimental debug output.
 */
@GeneratedMavMessage(
  id = 252u,
  crcExtra = 44,
)
public data class NamedValueInt(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Name of the debug variable
   */
  @GeneratedMavField(type = "char[10]")
  public val name: String = "",
  /**
   * Signed integer value
   */
  @GeneratedMavField(type = "int32_t")
  public val `value`: Int = 0,
) : MavMessage<NamedValueInt> {
  public override val instanceCompanion: MavMessage.MavCompanion<NamedValueInt> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt32(value)
    encoder.encodeString(name, 10)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt32(value)
    encoder.encodeString(name, 10)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<NamedValueInt> {
    private const val SIZE_V1: Int = 18

    private const val SIZE_V2: Int = 18

    public override val id: UInt = 252u

    public override val crcExtra: Byte = 44

    public override fun deserialize(bytes: ByteArray): NamedValueInt {
      val decoder = MavDataDecoder.wrap(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val value = decoder.safeDecodeInt32()
      val name = decoder.safeDecodeString(10)

      return NamedValueInt(
        timeBootMs = timeBootMs,
        name = name,
        value = value,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): NamedValueInt =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var name: String = ""

    public var `value`: Int = 0

    public fun build(): NamedValueInt = NamedValueInt(
      timeBootMs = timeBootMs,
      name = name,
      value = value,
    )
  }
}
