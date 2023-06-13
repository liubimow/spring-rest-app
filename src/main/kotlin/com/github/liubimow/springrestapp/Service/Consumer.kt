package com.github.liubimow.springrestapp.Service

import com.github.liubimow.springrestapp.DTO.Request
import com.github.liubimow.springrestapp.Operations.JsonReader
import com.github.liubimow.springrestapp.Operations.SQLSaver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service


@Service
class Consumer {
    @Autowired
    private lateinit var jsonReader: JsonReader
    @Autowired
    private lateinit var sqlSaver: SQLSaver

    private val logger: Logger = LoggerFactory.getLogger(Producer::class.java)

    @KafkaListener(topics = ["\${spring.kafka.template.default-topic}"], groupId = "\${spring.kafka.consumer.group-id}")
    fun consume(request: Request) {
        val jsonLikeString = jsonReader.readJson(request)
        logger.info("Json message received: $jsonLikeString")
        sqlSaver.saveRequest(request)
    }
}