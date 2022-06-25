package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * Read a configured an OSD parameter slot.
 */
public data class OsdParamShowConfig(
  /**
   * Request ID - copied to reply.
   */
  public val requestId: Long = 0L,
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  public val targetComponent: Int = 0,
  /**
   * OSD parameter screen index.
   */
  public val osdScreen: Int = 0,
  /**
   * OSD parameter display index.
   */
  public val osdIndex: Int = 0,
) : MavMessage<OsdParamShowConfig> {
  public override val instanceMetadata: MavMessage.Metadata<OsdParamShowConfig> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(requestId)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(osdScreen)
    outputBuffer.encodeUint8(osdIndex)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 11035

    private const val CRC: Int = 128

    private val DESERIALIZER: MavDeserializer<OsdParamShowConfig> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val requestId = inputBuffer.decodeUint32()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val osdScreen = inputBuffer.decodeUint8()
      val osdIndex = inputBuffer.decodeUint8()
      OsdParamShowConfig(
        requestId = requestId,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        osdScreen = osdScreen,
        osdIndex = osdIndex,
      )
    }


    private val METADATA: MavMessage.Metadata<OsdParamShowConfig> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OsdParamShowConfig> = METADATA
  }
}
