package com.urbanmatrix.mavlink.raw

import java.io.IOException
import java.io.InputStream
import java.io.PushbackInputStream

class TransactionalInputStream(
    inputStream: InputStream,
    bufferSize: Int
) : PushbackInputStream(
    inputStream,
    bufferSize
) {
    private val buffer = ByteArray(bufferSize)
    private var position = 0

    @Throws(IOException::class)
    override fun read(): Int {
        val data = super.read()
        if (data != -1) {
            buffer[position++] = data.toByte()
        }
        return data
    }

    @Throws(IOException::class)
    fun rollback() {
        super.unread(buffer, 0, position)
    }

    @Throws(IOException::class)
    fun advance(count: Int): Boolean {
        for (i in 0 until count) {
            if (read() == -1) {
                return false
            }
        }
        return true
    }

    fun commit() {
        position = 0
    }
}
