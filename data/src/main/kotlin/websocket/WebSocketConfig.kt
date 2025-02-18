package cl.sangut.projects.websocket

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.HandlerMapping
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter

@Configuration
class WebSocketConfig(private val webSocketHandler: CoroutineWebSocketHandler) {

    @Bean
    fun handlerMapping(): HandlerMapping {
        return SimpleUrlHandlerMapping(mapOf("/ws/events" to webSocketHandler), 1)
    }

    @Bean
    fun handlerAdapter(): WebSocketHandlerAdapter {
        return WebSocketHandlerAdapter()
    }
}