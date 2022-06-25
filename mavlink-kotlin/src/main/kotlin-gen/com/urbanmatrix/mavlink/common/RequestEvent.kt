package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Request one or more events to be (re-)sent. If first_sequence==last_sequence, only a single event
 * is requested. Note that first_sequence can be larger than last_sequence (because the sequence number
 * can wrap). Each sequence will trigger an EVENT or EVENT_ERROR response.
 */
public data class RequestEvent(
  /**
   * First sequence number of the requested event.
   */
  public val firstSequence: Int = 0,
  /**
   * Last sequence number of the requested event.
   */
  public val lastSequence: Int = 0,
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
) : MavMessage<RequestEvent> {
  public override val instanceMetadata: MavMessage.Metadata<RequestEvent> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(6).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(firstSequence)
    outputBuffer.encodeUint16(lastSequence)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 412

    private const val CRC: Int = 33

    private val DESERIALIZER: MavDeserializer<RequestEvent> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val firstSequence = inputBuffer.decodeUint16()
      val lastSequence = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      RequestEvent(
        firstSequence = firstSequence,
        lastSequence = lastSequence,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
      )
    }


    private val METADATA: MavMessage.Metadata<RequestEvent> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RequestEvent> = METADATA
  }
}
