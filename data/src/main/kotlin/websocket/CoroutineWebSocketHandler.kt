package cl.sangut.projects.websocket

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.reactor.mono
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketSession
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

@Component
class CoroutineWebSocketHandler : WebSocketHandler {
    override fun handle(session: WebSocketSession): Mono<Void> {
        val messages = flow {
            while (true) {
                emit("WebSocket Event: ${System.currentTimeMillis()}")
                delay(1000)
            }
        }

        return mono {
            // Send the messages to the WebSocket session
            messages.collect { message ->
                session.send(Mono.just(session.textMessage(message)))
                    .publishOn(Schedulers.single())
                    .subscribe()
            }
        }.then()
    }
}
