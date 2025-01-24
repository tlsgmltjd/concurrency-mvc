package com.concurrencymvc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ConcurrencyMvcApplication

fun main(args: Array<String>) {
    runApplication<ConcurrencyMvcApplication>(*args)
}
