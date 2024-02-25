package com.mrozowski.ims.infrastructure

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder


@Configuration
class KafkaTopicConfiguration {

    @Bean
    fun inventoryTopic(): NewTopic {
        return TopicBuilder.name("inventory-topic").build()
    }

    @Bean
    fun inventoryUpdatedTopic(): NewTopic {
        return TopicBuilder.name("inventory_updated_topic").build()
    }
}