package cl.sangut.projects

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Sinks
import java.time.Duration

@Service
class EventStreamService {
    private val sink = Sinks.many().multicast().onBackpressureBuffer<String>()

    fun publishEvent(message: String) {
        sink.tryEmitNext(message)
    }

    fun streamEvents(): Flux<String> {
        return sink.asFlux().delayElements(Duration.ofSeconds(1))
    }
}
