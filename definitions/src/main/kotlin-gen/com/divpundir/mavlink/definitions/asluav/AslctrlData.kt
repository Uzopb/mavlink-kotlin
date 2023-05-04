package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * ASL-fixed-wing controller data
 */
@GeneratedMavMessage(
  id = 8004u,
  crcExtra = -84,
)
public data class AslctrlData(
  /**
   *  Timestamp
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   *  ASLCTRL control-mode (manual, stabilized, auto, etc...)
   */
  @GeneratedMavField(type = "uint8_t")
  public val aslctrlMode: UByte = 0u,
  /**
   *  See sourcecode for a description of these values... 
   */
  @GeneratedMavField(type = "float")
  public val h: Float = 0F,
  @GeneratedMavField(type = "float")
  public val href: Float = 0F,
  @GeneratedMavField(type = "float")
  public val hrefT: Float = 0F,
  /**
   * Pitch angle
   */
  @GeneratedMavField(type = "float")
  public val pitchangle: Float = 0F,
  /**
   * Pitch angle reference
   */
  @GeneratedMavField(type = "float")
  public val pitchangleref: Float = 0F,
  @GeneratedMavField(type = "float")
  public val q: Float = 0F,
  @GeneratedMavField(type = "float")
  public val qref: Float = 0F,
  @GeneratedMavField(type = "float")
  public val uelev: Float = 0F,
  @GeneratedMavField(type = "float")
  public val uthrot: Float = 0F,
  @GeneratedMavField(type = "float")
  public val uthrot2: Float = 0F,
  @GeneratedMavField(type = "float")
  public val nz: Float = 0F,
  /**
   * Airspeed reference
   */
  @GeneratedMavField(type = "float")
  public val airspeedref: Float = 0F,
  @GeneratedMavField(type = "uint8_t")
  public val spoilersengaged: UByte = 0u,
  /**
   * Yaw angle
   */
  @GeneratedMavField(type = "float")
  public val yawangle: Float = 0F,
  /**
   * Yaw angle reference
   */
  @GeneratedMavField(type = "float")
  public val yawangleref: Float = 0F,
  /**
   * Roll angle
   */
  @GeneratedMavField(type = "float")
  public val rollangle: Float = 0F,
  /**
   * Roll angle reference
   */
  @GeneratedMavField(type = "float")
  public val rollangleref: Float = 0F,
  @GeneratedMavField(type = "float")
  public val p: Float = 0F,
  @GeneratedMavField(type = "float")
  public val pref: Float = 0F,
  @GeneratedMavField(type = "float")
  public val r: Float = 0F,
  @GeneratedMavField(type = "float")
  public val rref: Float = 0F,
  @GeneratedMavField(type = "float")
  public val uail: Float = 0F,
  @GeneratedMavField(type = "float")
  public val urud: Float = 0F,
) : MavMessage<AslctrlData> {
  public override val instanceMetadata: MavMessage.Metadata<AslctrlData> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeFloat(h)
    outputBuffer.encodeFloat(href)
    outputBuffer.encodeFloat(hrefT)
    outputBuffer.encodeFloat(pitchangle)
    outputBuffer.encodeFloat(pitchangleref)
    outputBuffer.encodeFloat(q)
    outputBuffer.encodeFloat(qref)
    outputBuffer.encodeFloat(uelev)
    outputBuffer.encodeFloat(uthrot)
    outputBuffer.encodeFloat(uthrot2)
    outputBuffer.encodeFloat(nz)
    outputBuffer.encodeFloat(airspeedref)
    outputBuffer.encodeFloat(yawangle)
    outputBuffer.encodeFloat(yawangleref)
    outputBuffer.encodeFloat(rollangle)
    outputBuffer.encodeFloat(rollangleref)
    outputBuffer.encodeFloat(p)
    outputBuffer.encodeFloat(pref)
    outputBuffer.encodeFloat(r)
    outputBuffer.encodeFloat(rref)
    outputBuffer.encodeFloat(uail)
    outputBuffer.encodeFloat(urud)
    outputBuffer.encodeUInt8(aslctrlMode)
    outputBuffer.encodeUInt8(spoilersengaged)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeFloat(h)
    outputBuffer.encodeFloat(href)
    outputBuffer.encodeFloat(hrefT)
    outputBuffer.encodeFloat(pitchangle)
    outputBuffer.encodeFloat(pitchangleref)
    outputBuffer.encodeFloat(q)
    outputBuffer.encodeFloat(qref)
    outputBuffer.encodeFloat(uelev)
    outputBuffer.encodeFloat(uthrot)
    outputBuffer.encodeFloat(uthrot2)
    outputBuffer.encodeFloat(nz)
    outputBuffer.encodeFloat(airspeedref)
    outputBuffer.encodeFloat(yawangle)
    outputBuffer.encodeFloat(yawangleref)
    outputBuffer.encodeFloat(rollangle)
    outputBuffer.encodeFloat(rollangleref)
    outputBuffer.encodeFloat(p)
    outputBuffer.encodeFloat(pref)
    outputBuffer.encodeFloat(r)
    outputBuffer.encodeFloat(rref)
    outputBuffer.encodeFloat(uail)
    outputBuffer.encodeFloat(urud)
    outputBuffer.encodeUInt8(aslctrlMode)
    outputBuffer.encodeUInt8(spoilersengaged)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 8004u

    private const val CRC_EXTRA: Byte = -84

    private const val SIZE_V1: Int = 98

    private const val SIZE_V2: Int = 98

    private val DESERIALIZER: MavDeserializer<AslctrlData> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUInt64()
      val h = inputBuffer.decodeFloat()
      val href = inputBuffer.decodeFloat()
      val hrefT = inputBuffer.decodeFloat()
      val pitchangle = inputBuffer.decodeFloat()
      val pitchangleref = inputBuffer.decodeFloat()
      val q = inputBuffer.decodeFloat()
      val qref = inputBuffer.decodeFloat()
      val uelev = inputBuffer.decodeFloat()
      val uthrot = inputBuffer.decodeFloat()
      val uthrot2 = inputBuffer.decodeFloat()
      val nz = inputBuffer.decodeFloat()
      val airspeedref = inputBuffer.decodeFloat()
      val yawangle = inputBuffer.decodeFloat()
      val yawangleref = inputBuffer.decodeFloat()
      val rollangle = inputBuffer.decodeFloat()
      val rollangleref = inputBuffer.decodeFloat()
      val p = inputBuffer.decodeFloat()
      val pref = inputBuffer.decodeFloat()
      val r = inputBuffer.decodeFloat()
      val rref = inputBuffer.decodeFloat()
      val uail = inputBuffer.decodeFloat()
      val urud = inputBuffer.decodeFloat()
      val aslctrlMode = inputBuffer.decodeUInt8()
      val spoilersengaged = inputBuffer.decodeUInt8()

      AslctrlData(
        timestamp = timestamp,
        aslctrlMode = aslctrlMode,
        h = h,
        href = href,
        hrefT = hrefT,
        pitchangle = pitchangle,
        pitchangleref = pitchangleref,
        q = q,
        qref = qref,
        uelev = uelev,
        uthrot = uthrot,
        uthrot2 = uthrot2,
        nz = nz,
        airspeedref = airspeedref,
        spoilersengaged = spoilersengaged,
        yawangle = yawangle,
        yawangleref = yawangleref,
        rollangle = rollangle,
        rollangleref = rollangleref,
        p = p,
        pref = pref,
        r = r,
        rref = rref,
        uail = uail,
        urud = urud,
      )
    }


    private val METADATA: MavMessage.Metadata<AslctrlData> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AslctrlData> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): AslctrlData =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: ULong = 0uL

    public var aslctrlMode: UByte = 0u

    public var h: Float = 0F

    public var href: Float = 0F

    public var hrefT: Float = 0F

    public var pitchangle: Float = 0F

    public var pitchangleref: Float = 0F

    public var q: Float = 0F

    public var qref: Float = 0F

    public var uelev: Float = 0F

    public var uthrot: Float = 0F

    public var uthrot2: Float = 0F

    public var nz: Float = 0F

    public var airspeedref: Float = 0F

    public var spoilersengaged: UByte = 0u

    public var yawangle: Float = 0F

    public var yawangleref: Float = 0F

    public var rollangle: Float = 0F

    public var rollangleref: Float = 0F

    public var p: Float = 0F

    public var pref: Float = 0F

    public var r: Float = 0F

    public var rref: Float = 0F

    public var uail: Float = 0F

    public var urud: Float = 0F

    public fun build(): AslctrlData = AslctrlData(
      timestamp = timestamp,
      aslctrlMode = aslctrlMode,
      h = h,
      href = href,
      hrefT = hrefT,
      pitchangle = pitchangle,
      pitchangleref = pitchangleref,
      q = q,
      qref = qref,
      uelev = uelev,
      uthrot = uthrot,
      uthrot2 = uthrot2,
      nz = nz,
      airspeedref = airspeedref,
      spoilersengaged = spoilersengaged,
      yawangle = yawangle,
      yawangleref = yawangleref,
      rollangle = rollangle,
      rollangleref = rollangleref,
      p = p,
      pref = pref,
      r = r,
      rref = rref,
      uail = uail,
      urud = urud,
    )
  }
}