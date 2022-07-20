package com.urbanmatrix.mavlink.definitions.asluav

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.definitions.common.MavCmd
import com.urbanmatrix.mavlink.definitions.common.MavFrame
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long

/**
 * Message encoding a command with parameters as scaled integers and additional metadata. Scaling
 * depends on the actual command value.
 */
public data class CommandIntStamped(
  /**
   * UTC time, seconds elapsed since 01.01.1970
   */
  public val utcTime: Long = 0L,
  /**
   * Microseconds elapsed since vehicle boot
   */
  public val vehicleTimestamp: BigInteger = BigInteger.ZERO,
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * The coordinate system of the COMMAND, as defined by MAV_FRAME enum
   */
  public val frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0),
  /**
   * The scheduled action for the mission item, as defined by MAV_CMD enum
   */
  public val command: MavEnumValue<MavCmd> = MavEnumValue.fromValue(0),
  /**
   * false:0, true:1
   */
  public val current: Int = 0,
  /**
   * autocontinue to next wp
   */
  public val autocontinue: Int = 0,
  /**
   * PARAM1, see MAV_CMD enum
   */
  public val param1: Float = 0F,
  /**
   * PARAM2, see MAV_CMD enum
   */
  public val param2: Float = 0F,
  /**
   * PARAM3, see MAV_CMD enum
   */
  public val param3: Float = 0F,
  /**
   * PARAM4, see MAV_CMD enum
   */
  public val param4: Float = 0F,
  /**
   * PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7
   */
  public val x: Int = 0,
  /**
   * PARAM6 / local: y position in meters * 1e4, global: longitude in degrees * 10^7
   */
  public val y: Int = 0,
  /**
   * PARAM7 / z position: global: altitude in meters (MSL, WGS84, AGL or relative to home -
   * depending on frame).
   */
  public val z: Float = 0F,
) : MavMessage<CommandIntStamped> {
  public override val instanceMetadata: MavMessage.Metadata<CommandIntStamped> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(vehicleTimestamp)
    outputBuffer.encodeUint32(utcTime)
    outputBuffer.encodeFloat(param1)
    outputBuffer.encodeFloat(param2)
    outputBuffer.encodeFloat(param3)
    outputBuffer.encodeFloat(param4)
    outputBuffer.encodeInt32(x)
    outputBuffer.encodeInt32(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeEnumValue(command.value, 2)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeEnumValue(frame.value, 1)
    outputBuffer.encodeUint8(current)
    outputBuffer.encodeUint8(autocontinue)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 223

    private const val CRC: Int = 119

    private const val SIZE: Int = 47

    private val DESERIALIZER: MavDeserializer<CommandIntStamped> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val vehicleTimestamp = inputBuffer.decodeUint64()
      val utcTime = inputBuffer.decodeUint32()
      val param1 = inputBuffer.decodeFloat()
      val param2 = inputBuffer.decodeFloat()
      val param3 = inputBuffer.decodeFloat()
      val param4 = inputBuffer.decodeFloat()
      val x = inputBuffer.decodeInt32()
      val y = inputBuffer.decodeInt32()
      val z = inputBuffer.decodeFloat()
      val command = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = MavCmd.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val frame = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val current = inputBuffer.decodeUint8()
      val autocontinue = inputBuffer.decodeUint8()

      CommandIntStamped(
        utcTime = utcTime,
        vehicleTimestamp = vehicleTimestamp,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        frame = frame,
        command = command,
        current = current,
        autocontinue = autocontinue,
        param1 = param1,
        param2 = param2,
        param3 = param3,
        param4 = param4,
        x = x,
        y = y,
        z = z,
      )
    }


    private val METADATA: MavMessage.Metadata<CommandIntStamped> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CommandIntStamped> = METADATA
  }
}
