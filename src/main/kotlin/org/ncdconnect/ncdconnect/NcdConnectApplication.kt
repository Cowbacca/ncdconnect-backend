package org.ncdconnect.ncdconnect

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NcdConnectApplication

fun main(args: Array<String>) {
    runApplication<NcdConnectApplication>(*args)
}
