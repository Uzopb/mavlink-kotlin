package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Optical flow from an angular rate flow sensor (e.g. PX4FLOW or mouse sensor)
 */
@GeneratedMavMessage(
  id = 106,
  crc = 138,
)
public data class OpticalFlowRad(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Sensor ID
   */
  public val sensorId: Int = 0,
  /**
   * Integration time. Divide integrated_x and integrated_y by the integration time to obtain
   * average flow. The integration time also indicates the.
   */
  public val integrationTimeUs: Long = 0L,
  /**
   * Flow around X axis (Sensor RH rotation about the X axis induces a positive flow. Sensor linear
   * motion along the positive Y axis induces a negative flow.)
   */
  public val integratedX: Float = 0F,
  /**
   * Flow around Y axis (Sensor RH rotation about the Y axis induces a positive flow. Sensor linear
   * motion along the positive X axis induces a positive flow.)
   */
  public val integratedY: Float = 0F,
  /**
   * RH rotation around X axis
   */
  public val integratedXgyro: Float = 0F,
  /**
   * RH rotation around Y axis
   */
  public val integratedYgyro: Float = 0F,
  /**
   * RH rotation around Z axis
   */
  public val integratedZgyro: Float = 0F,
  /**
   * Temperature
   */
  public val temperature: Int = 0,
  /**
   * Optical flow quality / confidence. 0: no valid flow, 255: maximum quality
   */
  public val quality: Int = 0,
  /**
   * Time since the distance was sampled.
   */
  public val timeDeltaDistanceUs: Long = 0L,
  /**
   * Distance to the center of the flow field. Positive value (including zero): distance known.
   * Negative value: Unknown distance.
   */
  public val distance: Float = 0F,
) : MavMessage<OpticalFlowRad> {
  public override val instanceMetadata: MavMessage.Metadata<OpticalFlowRad> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint32(integrationTimeUs)
    outputBuffer.encodeFloat(integratedX)
    outputBuffer.encodeFloat(integratedY)
    outputBuffer.encodeFloat(integratedXgyro)
    outputBuffer.encodeFloat(integratedYgyro)
    outputBuffer.encodeFloat(integratedZgyro)
    outputBuffer.encodeUint32(timeDeltaDistanceUs)
    outputBuffer.encodeFloat(distance)
    outputBuffer.encodeInt16(temperature)
    outputBuffer.encodeUint8(sensorId)
    outputBuffer.encodeUint8(quality)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 106

    private const val CRC: Int = 138

    private const val SIZE: Int = 44

    private val DESERIALIZER: MavDeserializer<OpticalFlowRad> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val integrationTimeUs = inputBuffer.decodeUint32()
      val integratedX = inputBuffer.decodeFloat()
      val integratedY = inputBuffer.decodeFloat()
      val integratedXgyro = inputBuffer.decodeFloat()
      val integratedYgyro = inputBuffer.decodeFloat()
      val integratedZgyro = inputBuffer.decodeFloat()
      val timeDeltaDistanceUs = inputBuffer.decodeUint32()
      val distance = inputBuffer.decodeFloat()
      val temperature = inputBuffer.decodeInt16()
      val sensorId = inputBuffer.decodeUint8()
      val quality = inputBuffer.decodeUint8()

      OpticalFlowRad(
        timeUsec = timeUsec,
        sensorId = sensorId,
        integrationTimeUs = integrationTimeUs,
        integratedX = integratedX,
        integratedY = integratedY,
        integratedXgyro = integratedXgyro,
        integratedYgyro = integratedYgyro,
        integratedZgyro = integratedZgyro,
        temperature = temperature,
        quality = quality,
        timeDeltaDistanceUs = timeDeltaDistanceUs,
        distance = distance,
      )
    }


    private val METADATA: MavMessage.Metadata<OpticalFlowRad> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OpticalFlowRad> = METADATA
  }
}