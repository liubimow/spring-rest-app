package com.github.liubimow.springrestapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableKafka
class SpringRestAppApplication

fun main(args: Array<String>) {
	runApplication<SpringRestAppApplication>(*args)
}
