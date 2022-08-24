package xyz.urbanmatrix.mavlink.adapters.rxjava3

import xyz.urbanmatrix.mavlink.api.MavFrame
import xyz.urbanmatrix.mavlink.api.MavMessage
import io.reactivex.rxjava3.annotations.CheckReturnValue
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

interface Rx3MavConnection {

    @get:CheckReturnValue
    val mavFrame: Flowable<MavFrame<out MavMessage<*>>>

    @CheckReturnValue
    fun connect(): Completable

    @CheckReturnValue
    fun close(): Completable

    @CheckReturnValue
    fun <T : MavMessage<T>> sendV1(
        systemId: Int,
        componentId: Int,
        payload: T
    ): Completable

    @CheckReturnValue
    fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: Int,
        componentId: Int,
        payload: T
    ): Completable

    @CheckReturnValue
    fun <T : MavMessage<T>> sendSignedV2(
        systemId: Int,
        componentId: Int,
        payload: T,
        linkId: Int,
        timestamp: Long,
        secretKey: ByteArray
    ): Completable
}