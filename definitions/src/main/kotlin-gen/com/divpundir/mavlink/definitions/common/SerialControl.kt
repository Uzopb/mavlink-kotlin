package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * Control a serial port. This can be used for raw access to an onboard serial peripheral such as a
 * GPS or telemetry radio. It is designed to make it possible to update the devices firmware via
 * MAVLink messages or change the devices settings. A message with zero bytes can be used to change
 * just the baudrate.
 */
@GeneratedMavMessage(
  id = 126u,
  crcExtra = -36,
)
public data class SerialControl(
  /**
   * Serial control device type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val device: MavEnumValue<SerialControlDev> = MavEnumValue.fromValue(0u),
  /**
   * Bitmap of serial control flags.
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: MavBitmaskValue<SerialControlFlag> = MavBitmaskValue.fromValue(0u),
  /**
   * Timeout for reply data
   */
  @GeneratedMavField(type = "uint16_t")
  public val timeout: UShort = 0u,
  /**
   * Baudrate of transfer. Zero means no change.
   */
  @GeneratedMavField(type = "uint32_t")
  public val baudrate: UInt = 0u,
  /**
   * how many bytes in this transfer
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: UByte = 0u,
  /**
   * serial data
   */
  @GeneratedMavField(type = "uint8_t[70]")
  public val `data`: List<UByte> = emptyList(),
  /**
   * System ID
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val targetComponent: UByte = 0u,
) : MavMessage<SerialControl> {
  public override val instanceCompanion: MavMessage.MavCompanion<SerialControl> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(baudrate)
    outputBuffer.encodeUInt16(timeout)
    outputBuffer.encodeEnumValue(device.value, 1)
    outputBuffer.encodeBitmaskValue(flags.value, 1)
    outputBuffer.encodeUInt8(count)
    outputBuffer.encodeUInt8Array(data, 70)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(baudrate)
    outputBuffer.encodeUInt16(timeout)
    outputBuffer.encodeEnumValue(device.value, 1)
    outputBuffer.encodeBitmaskValue(flags.value, 1)
    outputBuffer.encodeUInt8(count)
    outputBuffer.encodeUInt8Array(data, 70)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialControl> {
    private const val SIZE_V1: Int = 79

    private const val SIZE_V2: Int = 81

    public override val id: UInt = 126u

    public override val crcExtra: Byte = -36

    public override fun deserialize(bytes: ByteArray): SerialControl {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val baudrate = inputBuffer.decodeUInt32()
      val timeout = inputBuffer.decodeUInt16()
      val device = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = SerialControlDev.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val flags = inputBuffer.decodeBitmaskValue(1).let { value ->
        val flags = SerialControlFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val count = inputBuffer.decodeUInt8()
      val data = inputBuffer.decodeUInt8Array(70)
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()

      return SerialControl(
        device = device,
        flags = flags,
        timeout = timeout,
        baudrate = baudrate,
        count = count,
        data = data,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialControl =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var device: MavEnumValue<SerialControlDev> = MavEnumValue.fromValue(0u)

    public var flags: MavBitmaskValue<SerialControlFlag> = MavBitmaskValue.fromValue(0u)

    public var timeout: UShort = 0u

    public var baudrate: UInt = 0u

    public var count: UByte = 0u

    public var `data`: List<UByte> = emptyList()

    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public fun build(): SerialControl = SerialControl(
      device = device,
      flags = flags,
      timeout = timeout,
      baudrate = baudrate,
      count = count,
      data = data,
      targetSystem = targetSystem,
      targetComponent = targetComponent,
    )
  }
}
