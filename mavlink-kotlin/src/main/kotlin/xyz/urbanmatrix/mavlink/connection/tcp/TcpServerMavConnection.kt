package xyz.urbanmatrix.mavlink.connection.tcp

import xyz.urbanmatrix.mavlink.api.MavDialect
import xyz.urbanmatrix.mavlink.connection.stream.StreamMavConnection
import java.io.IOException
import java.net.ServerSocket

public class TcpServerMavConnection(
    private val port: Int,
    private val dialect: MavDialect
) : TcpMavConnection() {

    @Throws(IOException::class)
    override fun connect() {
        when (state) {
            is State.Open -> throw IOException("Already Open")

            State.Closed -> {
                val server = ServerSocket(port)
                val socket = server.accept()
                server.close()

                state = State.Open(
                    StreamMavConnection(
                        socket.getInputStream(),
                        socket.getOutputStream(),
                        socket,
                        dialect
                    )
                )
            }
        }
    }
}
