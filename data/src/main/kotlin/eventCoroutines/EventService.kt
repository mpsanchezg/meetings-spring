package cl.sangut.projects.eventCoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.springframework.stereotype.Service

@Service
class EventService {
    fun streamEvents(): Flow<String> = flow {
        while (true) {
            emit("Event at: ${System.currentTimeMillis()}")
            delay(1000) // Simulate real-time event every second
        }
    }
}
