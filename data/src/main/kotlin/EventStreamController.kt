package cl.sangut.projects

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.MediaType
import reactor.core.publisher.Flux

@RestController
class EventStreamController(private val eventService: EventStreamService) {

    @PostMapping("/publish")
    fun publishEvent(@RequestParam message: String) {
        eventService.publishEvent(message)
    }

    @GetMapping(value = ["/events"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun streamEvents(): Flux<String> {
        return eventService.streamEvents()
    }
}
