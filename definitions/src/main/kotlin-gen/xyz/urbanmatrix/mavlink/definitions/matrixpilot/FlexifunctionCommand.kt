package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Acknowldge sucess or failure of a flexifunction command
 */
@GeneratedMavMessage(
  id = 157,
  crc = 133,
)
public data class FlexifunctionCommand(
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * Flexifunction command type
   */
  public val commandType: Int = 0,
) : MavMessage<FlexifunctionCommand> {
  public override val instanceMetadata: MavMessage.Metadata<FlexifunctionCommand> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(commandType)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 157

    private const val CRC: Int = 133

    private const val SIZE: Int = 3

    private val DESERIALIZER: MavDeserializer<FlexifunctionCommand> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val commandType = inputBuffer.decodeUint8()

      FlexifunctionCommand(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        commandType = commandType,
      )
    }


    private val METADATA: MavMessage.Metadata<FlexifunctionCommand> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FlexifunctionCommand> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var commandType: Int = 0

    public fun build(): FlexifunctionCommand = FlexifunctionCommand(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      commandType = commandType,
    )
  }
}
