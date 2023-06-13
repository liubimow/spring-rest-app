package com.github.liubimow.springrestapp.Service

import com.github.liubimow.springrestapp.DTO.Request
import com.github.liubimow.springrestapp.Operations.JsonReader
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service


@Service
class Producer {
    @Value("\${spring.kafka.template.default-topic}")
    private val topic: String? = null

    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, Request>
    @Autowired
    private lateinit var jsonReader: JsonReader

    private val logger: Logger = LoggerFactory.getLogger(Producer::class.java)

    fun sendMessage(request: Request) {
        val jsonLikeString = jsonReader.readJson(request)
        logger.info("New request received: $jsonLikeString")

        val message: Message<Request> = MessageBuilder
            .withPayload(request)
            .setHeader(KafkaHeaders.TOPIC, topic)
            .build()

        kafkaTemplate.send(message)
    }
}