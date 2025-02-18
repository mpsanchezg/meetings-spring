package cl.sangut.projects

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebFluxApplication

fun main(args: Array<String>) {
    runApplication<WebFluxApplication>(*args)
}

