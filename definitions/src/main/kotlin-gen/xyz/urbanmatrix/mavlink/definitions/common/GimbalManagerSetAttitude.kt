package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
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
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * High level message to control a gimbal's attitude. This message is to be sent to the gimbal
 * manager (e.g. from a ground station). Angles and rates can be set to NaN according to use case.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 282,
  crc = 123,
)
public data class GimbalManagerSetAttitude(
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * High level gimbal manager flags to use.
   */
  public val flags: MavEnumValue<GimbalManagerFlags> = MavEnumValue.fromValue(0),
  /**
   * Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal
   * device components. Send command multiple times for more than one gimbal (but not all gimbals).
   */
  public val gimbalDeviceId: Int = 0,
  /**
   * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation, the frame is depends on
   * whether the flag GIMBAL_MANAGER_FLAGS_YAW_LOCK is set)
   */
  public val q: List<Float> = emptyList(),
  /**
   * X component of angular velocity, positive is rolling to the right, NaN to be ignored.
   */
  public val angularVelocityX: Float = 0F,
  /**
   * Y component of angular velocity, positive is pitching up, NaN to be ignored.
   */
  public val angularVelocityY: Float = 0F,
  /**
   * Z component of angular velocity, positive is yawing to the right, NaN to be ignored.
   */
  public val angularVelocityZ: Float = 0F,
) : MavMessage<GimbalManagerSetAttitude> {
  public override val instanceMetadata: MavMessage.Metadata<GimbalManagerSetAttitude> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(flags.value, 4)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeFloat(angularVelocityX)
    outputBuffer.encodeFloat(angularVelocityY)
    outputBuffer.encodeFloat(angularVelocityZ)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(gimbalDeviceId)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 282

    private const val CRC: Int = 123

    private const val SIZE: Int = 35

    private val DESERIALIZER: MavDeserializer<GimbalManagerSetAttitude> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val flags = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = GimbalManagerFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val q = inputBuffer.decodeFloatArray(16)
      val angularVelocityX = inputBuffer.decodeFloat()
      val angularVelocityY = inputBuffer.decodeFloat()
      val angularVelocityZ = inputBuffer.decodeFloat()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val gimbalDeviceId = inputBuffer.decodeUint8()

      GimbalManagerSetAttitude(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        flags = flags,
        gimbalDeviceId = gimbalDeviceId,
        q = q,
        angularVelocityX = angularVelocityX,
        angularVelocityY = angularVelocityY,
        angularVelocityZ = angularVelocityZ,
      )
    }


    private val METADATA: MavMessage.Metadata<GimbalManagerSetAttitude> = MavMessage.Metadata(ID,
        CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GimbalManagerSetAttitude> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var flags: MavEnumValue<GimbalManagerFlags> = MavEnumValue.fromValue(0)

    public var gimbalDeviceId: Int = 0

    public var q: List<Float> = emptyList()

    public var angularVelocityX: Float = 0F

    public var angularVelocityY: Float = 0F

    public var angularVelocityZ: Float = 0F

    public fun build(): GimbalManagerSetAttitude = GimbalManagerSetAttitude(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      flags = flags,
      gimbalDeviceId = gimbalDeviceId,
      q = q,
      angularVelocityX = angularVelocityX,
      angularVelocityY = angularVelocityY,
      angularVelocityZ = angularVelocityZ,
    )
  }
}
