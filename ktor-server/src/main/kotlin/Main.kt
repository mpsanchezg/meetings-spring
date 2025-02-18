package cl.sangut.projects

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.routing.routing
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import java.time.Duration

fun main() {
    embeddedServer(Netty, port = 8081) {
        install(WebSockets) {
            pingPeriod = Duration.ofSeconds(15)
        }
        routing {
            webSocket("/sync") {
                for (frame in incoming) {
                    if (frame is Frame.Text) {
                        val receivedData = frame.readText()
                        println("Received: $receivedData")

                        // Broadcast the update to other clients
                        outgoing.send(Frame.Text("Update received: $receivedData"))
                    }
                }
            }
        }
    }.start(wait = true)
}
