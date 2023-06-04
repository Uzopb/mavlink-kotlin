package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit

/**
 * Status of the SatCom link
 */
@GeneratedMavMessage(
  id = 8_015u,
  crcExtra = 23,
)
public data class SatcomLinkStatus(
  /**
   * Timestamp
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   * Timestamp of the last successful sbd session
   */
  @GeneratedMavField(type = "uint64_t")
  public val lastHeartbeat: ULong = 0uL,
  /**
   * Number of failed sessions
   */
  @GeneratedMavField(type = "uint16_t")
  public val failedSessions: UShort = 0u,
  /**
   * Number of successful sessions
   */
  @GeneratedMavField(type = "uint16_t")
  public val successfulSessions: UShort = 0u,
  /**
   * Signal quality
   */
  @GeneratedMavField(type = "uint8_t")
  public val signalQuality: UByte = 0u,
  /**
   * Ring call pending
   */
  @GeneratedMavField(type = "uint8_t")
  public val ringPending: UByte = 0u,
  /**
   * Transmission session pending
   */
  @GeneratedMavField(type = "uint8_t")
  public val txSessionPending: UByte = 0u,
  /**
   * Receiving session pending
   */
  @GeneratedMavField(type = "uint8_t")
  public val rxSessionPending: UByte = 0u,
) : MavMessage<SatcomLinkStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<SatcomLinkStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeUInt64(lastHeartbeat)
    outputBuffer.encodeUInt16(failedSessions)
    outputBuffer.encodeUInt16(successfulSessions)
    outputBuffer.encodeUInt8(signalQuality)
    outputBuffer.encodeUInt8(ringPending)
    outputBuffer.encodeUInt8(txSessionPending)
    outputBuffer.encodeUInt8(rxSessionPending)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeUInt64(lastHeartbeat)
    outputBuffer.encodeUInt16(failedSessions)
    outputBuffer.encodeUInt16(successfulSessions)
    outputBuffer.encodeUInt8(signalQuality)
    outputBuffer.encodeUInt8(ringPending)
    outputBuffer.encodeUInt8(txSessionPending)
    outputBuffer.encodeUInt8(rxSessionPending)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SatcomLinkStatus> {
    private const val SIZE_V1: Int = 24

    private const val SIZE_V2: Int = 24

    public override val id: UInt = 8_015u

    public override val crcExtra: Byte = 23

    public override fun deserialize(bytes: ByteArray): SatcomLinkStatus {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUInt64()
      val lastHeartbeat = inputBuffer.decodeUInt64()
      val failedSessions = inputBuffer.decodeUInt16()
      val successfulSessions = inputBuffer.decodeUInt16()
      val signalQuality = inputBuffer.decodeUInt8()
      val ringPending = inputBuffer.decodeUInt8()
      val txSessionPending = inputBuffer.decodeUInt8()
      val rxSessionPending = inputBuffer.decodeUInt8()

      return SatcomLinkStatus(
        timestamp = timestamp,
        lastHeartbeat = lastHeartbeat,
        failedSessions = failedSessions,
        successfulSessions = successfulSessions,
        signalQuality = signalQuality,
        ringPending = ringPending,
        txSessionPending = txSessionPending,
        rxSessionPending = rxSessionPending,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SatcomLinkStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: ULong = 0uL

    public var lastHeartbeat: ULong = 0uL

    public var failedSessions: UShort = 0u

    public var successfulSessions: UShort = 0u

    public var signalQuality: UByte = 0u

    public var ringPending: UByte = 0u

    public var txSessionPending: UByte = 0u

    public var rxSessionPending: UByte = 0u

    public fun build(): SatcomLinkStatus = SatcomLinkStatus(
      timestamp = timestamp,
      lastHeartbeat = lastHeartbeat,
      failedSessions = failedSessions,
      successfulSessions = successfulSessions,
      signalQuality = signalQuality,
      ringPending = ringPending,
      txSessionPending = txSessionPending,
      rxSessionPending = rxSessionPending,
    )
  }
}
