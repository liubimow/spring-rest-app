package com.github.liubimow.springrestapp.Configuration

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder


@Configuration
class KafkaConfig {
    @Value("\${spring.kafka.template.default-topic}")
    private val topicName: String? = null

    @Bean
    fun newTopic(): NewTopic? {
        return TopicBuilder.name(topicName!!)
            .build()
    }
}