package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * Request a chunk of a log
 */
public data class LogRequestData(
  /**
   * Offset into the log
   */
  public val ofs: Long = 0L,
  /**
   * Number of bytes
   */
  public val count: Long = 0L,
  /**
   * Log id (from LOG_ENTRY reply)
   */
  public val id: Int = 0,
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
) : MavMessage<LogRequestData> {
  public override val instanceMetadata: MavMessage.Metadata<LogRequestData> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(12).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(ofs)
    outputBuffer.encodeUint32(count)
    outputBuffer.encodeUint16(id)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 119

    private const val CRC: Int = 116

    private val DESERIALIZER: MavDeserializer<LogRequestData> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val ofs = inputBuffer.decodeUint32()
      val count = inputBuffer.decodeUint32()
      val id = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      LogRequestData(
        ofs = ofs,
        count = count,
        id = id,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
      )
    }


    private val METADATA: MavMessage.Metadata<LogRequestData> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<LogRequestData> = METADATA
  }
}
