package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.api.WorkInProgress
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Low level message containing autopilot state relevant for a gimbal device. This message is to be
 * sent from the gimbal manager to the gimbal device component. The data of this message server for the
 * gimbal's estimator corrections in particular horizon compensation, as well as the autopilot's
 * control intention e.g. feed forward angular control in z-axis.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 286,
  crc = 210,
)
public data class AutopilotStateForGimbalDevice(
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootUs: BigInteger = BigInteger.ZERO,
  /**
   * Quaternion components of autopilot attitude: w, x, y, z (1 0 0 0 is the null-rotation, Hamilton
   * convention).
   */
  public val q: List<Float> = emptyList(),
  /**
   * Estimated delay of the attitude data.
   */
  public val qEstimatedDelayUs: Long = 0L,
  /**
   * X Speed in NED (North, East, Down).
   */
  public val vx: Float = 0F,
  /**
   * Y Speed in NED (North, East, Down).
   */
  public val vy: Float = 0F,
  /**
   * Z Speed in NED (North, East, Down).
   */
  public val vz: Float = 0F,
  /**
   * Estimated delay of the speed data.
   */
  public val vEstimatedDelayUs: Long = 0L,
  /**
   * Feed forward Z component of angular velocity, positive is yawing to the right, NaN to be
   * ignored. This is to indicate if the autopilot is actively yawing.
   */
  public val feedForwardAngularVelocityZ: Float = 0F,
  /**
   * Bitmap indicating which estimator outputs are valid.
   */
  public val estimatorStatus: MavEnumValue<EstimatorStatusFlags> = MavEnumValue.fromValue(0),
  /**
   * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown.
   */
  public val landedState: MavEnumValue<MavLandedState> = MavEnumValue.fromValue(0),
) : MavMessage<AutopilotStateForGimbalDevice> {
  public override val instanceMetadata: MavMessage.Metadata<AutopilotStateForGimbalDevice> =
      METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeBootUs)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeUint32(qEstimatedDelayUs)
    outputBuffer.encodeFloat(vx)
    outputBuffer.encodeFloat(vy)
    outputBuffer.encodeFloat(vz)
    outputBuffer.encodeUint32(vEstimatedDelayUs)
    outputBuffer.encodeFloat(feedForwardAngularVelocityZ)
    outputBuffer.encodeEnumValue(estimatorStatus.value, 2)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeEnumValue(landedState.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 286

    private const val CRC: Int = 210

    private const val SIZE: Int = 53

    private val DESERIALIZER: MavDeserializer<AutopilotStateForGimbalDevice> = MavDeserializer {
        bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootUs = inputBuffer.decodeUint64()
      val q = inputBuffer.decodeFloatArray(16)
      val qEstimatedDelayUs = inputBuffer.decodeUint32()
      val vx = inputBuffer.decodeFloat()
      val vy = inputBuffer.decodeFloat()
      val vz = inputBuffer.decodeFloat()
      val vEstimatedDelayUs = inputBuffer.decodeUint32()
      val feedForwardAngularVelocityZ = inputBuffer.decodeFloat()
      val estimatorStatus = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = EstimatorStatusFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val landedState = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavLandedState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      AutopilotStateForGimbalDevice(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        timeBootUs = timeBootUs,
        q = q,
        qEstimatedDelayUs = qEstimatedDelayUs,
        vx = vx,
        vy = vy,
        vz = vz,
        vEstimatedDelayUs = vEstimatedDelayUs,
        feedForwardAngularVelocityZ = feedForwardAngularVelocityZ,
        estimatorStatus = estimatorStatus,
        landedState = landedState,
      )
    }


    private val METADATA: MavMessage.Metadata<AutopilotStateForGimbalDevice> =
        MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AutopilotStateForGimbalDevice> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var timeBootUs: BigInteger = BigInteger.ZERO

    public var q: List<Float> = emptyList()

    public var qEstimatedDelayUs: Long = 0L

    public var vx: Float = 0F

    public var vy: Float = 0F

    public var vz: Float = 0F

    public var vEstimatedDelayUs: Long = 0L

    public var feedForwardAngularVelocityZ: Float = 0F

    public var estimatorStatus: MavEnumValue<EstimatorStatusFlags> = MavEnumValue.fromValue(0)

    public var landedState: MavEnumValue<MavLandedState> = MavEnumValue.fromValue(0)

    public fun build(): AutopilotStateForGimbalDevice = AutopilotStateForGimbalDevice(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      timeBootUs = timeBootUs,
      q = q,
      qEstimatedDelayUs = qEstimatedDelayUs,
      vx = vx,
      vy = vy,
      vz = vz,
      vEstimatedDelayUs = vEstimatedDelayUs,
      feedForwardAngularVelocityZ = feedForwardAngularVelocityZ,
      estimatorStatus = estimatorStatus,
      landedState = landedState,
    )
  }
}
