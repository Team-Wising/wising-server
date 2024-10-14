package com.qpeterp.wising.wisingserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WisingServerApplication

fun main(args: Array<String>) {
    runApplication<WisingServerApplication>(*args)
}
