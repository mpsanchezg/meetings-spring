package cl.sangut.projects.websocket

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.reactor.mono
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketSession
import org.springframework.stereotype.Component

@Component
class CoroutineWebSocketHandler : WebSocketHandler {
    override fun handle(session: WebSocketSession) = mono {
        val messages = flow {
            while (true) {
                emit("WebSocket Event: ${System.currentTimeMillis()}")
                delay(1000)
            }
        }
        session.send(messages.map { session.textMessage(it) }).collect()
    }
}
