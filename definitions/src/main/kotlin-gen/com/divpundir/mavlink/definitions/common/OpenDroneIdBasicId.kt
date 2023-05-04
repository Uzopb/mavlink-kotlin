package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeEnumValue
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
import kotlin.Unit
import kotlin.collections.List

/**
 * Data for filling the OpenDroneID Basic ID message. This and the below messages are primarily
 * meant for feeding data to/from an OpenDroneID implementation. E.g.
 * https://github.com/opendroneid/opendroneid-core-c. These messages are compatible with the ASTM F3411
 * Remote ID standard and the ASD-STAN prEN 4709-002 Direct Remote ID standard. Additional information
 * and usage of these messages is documented at https://mavlink.io/en/services/opendroneid.html.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 12900u,
  crcExtra = 114,
)
public data class OpenDroneIdBasicId(
  /**
   * System ID (0 for broadcast).
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID (0 for broadcast).
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Only used for drone ID data received from other UAs. See detailed description at
   * https://mavlink.io/en/services/opendroneid.html. 
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val idOrMac: List<UByte> = emptyList(),
  /**
   * Indicates the format for the uas_id field of this message.
   */
  @GeneratedMavField(type = "uint8_t")
  public val idType: MavEnumValue<MavOdidIdType> = MavEnumValue.fromValue(0u),
  /**
   * Indicates the type of UA (Unmanned Aircraft).
   */
  @GeneratedMavField(type = "uint8_t")
  public val uaType: MavEnumValue<MavOdidUaType> = MavEnumValue.fromValue(0u),
  /**
   * UAS (Unmanned Aircraft System) ID following the format specified by id_type. Shall be filled
   * with nulls in the unused portion of the field.
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val uasId: List<UByte> = emptyList(),
) : MavMessage<OpenDroneIdBasicId> {
  public override val instanceMetadata: MavMessage.Metadata<OpenDroneIdBasicId> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8Array(idOrMac, 20)
    outputBuffer.encodeEnumValue(idType.value, 1)
    outputBuffer.encodeEnumValue(uaType.value, 1)
    outputBuffer.encodeUInt8Array(uasId, 20)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8Array(idOrMac, 20)
    outputBuffer.encodeEnumValue(idType.value, 1)
    outputBuffer.encodeEnumValue(uaType.value, 1)
    outputBuffer.encodeUInt8Array(uasId, 20)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 12900u

    private const val CRC_EXTRA: Byte = 114

    private const val SIZE_V1: Int = 44

    private const val SIZE_V2: Int = 44

    private val DESERIALIZER: MavDeserializer<OpenDroneIdBasicId> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val idOrMac = inputBuffer.decodeUInt8Array(20)
      val idType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidIdType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val uaType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidUaType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val uasId = inputBuffer.decodeUInt8Array(20)

      OpenDroneIdBasicId(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idOrMac = idOrMac,
        idType = idType,
        uaType = uaType,
        uasId = uasId,
      )
    }


    private val METADATA: MavMessage.Metadata<OpenDroneIdBasicId> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OpenDroneIdBasicId> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): OpenDroneIdBasicId =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var idOrMac: List<UByte> = emptyList()

    public var idType: MavEnumValue<MavOdidIdType> = MavEnumValue.fromValue(0u)

    public var uaType: MavEnumValue<MavOdidUaType> = MavEnumValue.fromValue(0u)

    public var uasId: List<UByte> = emptyList()

    public fun build(): OpenDroneIdBasicId = OpenDroneIdBasicId(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      idOrMac = idOrMac,
      idType = idType,
      uaType = uaType,
      uasId = uasId,
    )
  }
}