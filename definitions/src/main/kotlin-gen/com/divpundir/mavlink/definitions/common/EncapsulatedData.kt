package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * Data packet for images sent using the Image Transmission Protocol:
 * https://mavlink.io/en/services/image_transmission.html.
 */
@GeneratedMavMessage(
  id = 131u,
  crcExtra = -33,
)
public data class EncapsulatedData(
  /**
   * sequence number (starting with 0 on every transmission)
   */
  @GeneratedMavField(type = "uint16_t")
  public val seqnr: UShort = 0u,
  /**
   * image data bytes
   */
  @GeneratedMavField(type = "uint8_t[253]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<EncapsulatedData> {
  public override val instanceCompanion: MavMessage.MavCompanion<EncapsulatedData> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt16(seqnr)
    encoder.encodeUInt8Array(data, 253)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt16(seqnr)
    encoder.encodeUInt8Array(data, 253)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<EncapsulatedData> {
    private const val SIZE_V1: Int = 255

    private const val SIZE_V2: Int = 255

    public override val id: UInt = 131u

    public override val crcExtra: Byte = -33

    public override fun deserialize(bytes: ByteArray): EncapsulatedData {
      val decoder = MavDataDecoder.wrap(bytes)

      val seqnr = decoder.safeDecodeUInt16()
      val data = decoder.safeDecodeUInt8Array(253)

      return EncapsulatedData(
        seqnr = seqnr,
        data = data,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): EncapsulatedData =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var seqnr: UShort = 0u

    public var `data`: List<UByte> = emptyList()

    public fun build(): EncapsulatedData = EncapsulatedData(
      seqnr = seqnr,
      data = data,
    )
  }
}
