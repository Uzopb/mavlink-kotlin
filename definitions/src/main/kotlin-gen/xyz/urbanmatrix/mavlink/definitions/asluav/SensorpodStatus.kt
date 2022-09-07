package xyz.urbanmatrix.mavlink.definitions.asluav

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Monitoring of sensorpod status
 */
@GeneratedMavMessage(
  id = 8012,
  crc = 54,
)
public data class SensorpodStatus(
  /**
   * Timestamp in linuxtime (since 1.1.1970)
   */
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   * Rate of ROS topic 1
   */
  public val visensorRate1: Int = 0,
  /**
   * Rate of ROS topic 2
   */
  public val visensorRate2: Int = 0,
  /**
   * Rate of ROS topic 3
   */
  public val visensorRate3: Int = 0,
  /**
   * Rate of ROS topic 4
   */
  public val visensorRate4: Int = 0,
  /**
   * Number of recording nodes
   */
  public val recordingNodesCount: Int = 0,
  /**
   * Temperature of sensorpod CPU in
   */
  public val cpuTemp: Int = 0,
  /**
   * Free space available in recordings directory in [Gb] * 1e2
   */
  public val freeSpace: Int = 0,
) : MavMessage<SensorpodStatus> {
  public override val instanceMetadata: MavMessage.Metadata<SensorpodStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeUint16(freeSpace)
    outputBuffer.encodeUint8(visensorRate1)
    outputBuffer.encodeUint8(visensorRate2)
    outputBuffer.encodeUint8(visensorRate3)
    outputBuffer.encodeUint8(visensorRate4)
    outputBuffer.encodeUint8(recordingNodesCount)
    outputBuffer.encodeUint8(cpuTemp)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 8012

    private const val CRC: Int = 54

    private const val SIZE: Int = 16

    private val DESERIALIZER: MavDeserializer<SensorpodStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint64()
      val freeSpace = inputBuffer.decodeUint16()
      val visensorRate1 = inputBuffer.decodeUint8()
      val visensorRate2 = inputBuffer.decodeUint8()
      val visensorRate3 = inputBuffer.decodeUint8()
      val visensorRate4 = inputBuffer.decodeUint8()
      val recordingNodesCount = inputBuffer.decodeUint8()
      val cpuTemp = inputBuffer.decodeUint8()

      SensorpodStatus(
        timestamp = timestamp,
        visensorRate1 = visensorRate1,
        visensorRate2 = visensorRate2,
        visensorRate3 = visensorRate3,
        visensorRate4 = visensorRate4,
        recordingNodesCount = recordingNodesCount,
        cpuTemp = cpuTemp,
        freeSpace = freeSpace,
      )
    }


    private val METADATA: MavMessage.Metadata<SensorpodStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SensorpodStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: BigInteger = BigInteger.ZERO

    public var visensorRate1: Int = 0

    public var visensorRate2: Int = 0

    public var visensorRate3: Int = 0

    public var visensorRate4: Int = 0

    public var recordingNodesCount: Int = 0

    public var cpuTemp: Int = 0

    public var freeSpace: Int = 0

    public fun build(): SensorpodStatus = SensorpodStatus(
      timestamp = timestamp,
      visensorRate1 = visensorRate1,
      visensorRate2 = visensorRate2,
      visensorRate3 = visensorRate3,
      visensorRate4 = visensorRate4,
      recordingNodesCount = recordingNodesCount,
      cpuTemp = cpuTemp,
      freeSpace = freeSpace,
    )
  }
}
