package com.divpundir.mavlink.adapters.rxjava3

import com.divpundir.mavlink.api.MavFrame
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.connection.MavConnection
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.FlowableProcessor
import io.reactivex.rxjava3.processors.PublishProcessor
import java.io.IOException
import java.util.concurrent.Executor
import java.util.concurrent.Executors

internal class Rx3MavConnectionImpl(
    private val connection: MavConnection,
    private val onIoFailure: Rx3MavConnection.() -> Unit
) : Rx3MavConnection {

    private val mavFrameProcessor: FlowableProcessor<MavFrame<out MavMessage<*>>> = PublishProcessor.create()
    private val mavlinkReadThread: Executor = Executors.newSingleThreadExecutor { Thread(it, "mavlink-read-thread") }

    @Volatile
    private var isOpen = false
        @Synchronized set

    override val mavFrame: Flowable<MavFrame<out MavMessage<*>>>
        get() = mavFrameProcessor.onBackpressureBuffer().share()

    override fun connect(): Completable = Completable.fromAction {
        connection.connect()
        isOpen = true
        mavlinkReadThread.execute(this::processMavFrames)
    }

    private fun processMavFrames() {
        while (!Thread.currentThread().isInterrupted && isOpen) {
            try {
                mavFrameProcessor.onNext(connection.next())
            } catch (e: IOException) {
                kotlin.runCatching { connection.close() }
                break
            } catch (e: InterruptedException) {
                kotlin.runCatching { connection.close() }
                isOpen = false
                break
            }
        }

        if (isOpen) {
            onIoFailure()
        }
    }

    override fun close(): Completable = Completable.fromAction {
        connection.close()
        isOpen = false
    }

    override fun <T : MavMessage<T>> sendV1(
        systemId: UByte,
        componentId: UByte,
        payload: T
    ): Completable = Completable.fromAction {
        connection.sendV1(
            systemId,
            componentId,
            payload
        )
    }

    override fun <T : MavMessage<T>> sendUnsignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T
    ): Completable = Completable.fromAction {
        connection.sendUnsignedV2(
            systemId,
            componentId,
            payload
        )
    }

    override fun <T : MavMessage<T>> sendSignedV2(
        systemId: UByte,
        componentId: UByte,
        payload: T,
        linkId: UByte,
        timestamp: UInt,
        secretKey: ByteArray
    ): Completable = Completable.fromAction {
        connection.sendSignedV2(
            systemId,
            componentId,
            payload,
            linkId,
            timestamp,
            secretKey
        )
    }
}