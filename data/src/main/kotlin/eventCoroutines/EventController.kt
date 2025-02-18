package cl.sangut.projects.eventCoroutines

import kotlinx.coroutines.flow.Flow
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EventController(private val eventService: EventService) {

    @GetMapping("/events1", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getEvents(): Flow<String> {
        return eventService.streamEvents()
    }
}
