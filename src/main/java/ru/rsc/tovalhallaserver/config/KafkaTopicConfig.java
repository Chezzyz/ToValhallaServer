package ru.rsc.tovalhallaserver.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import ru.rsc.tovalhallaserver.domain.constants.KafkaTopics;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaTopicConfig {
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

//    @Bean
//    public KafkaAdmin.NewTopics topics() {
//        return new KafkaAdmin.NewTopics(
//                TopicBuilder.name(KafkaTopics.PLAYER_SESSION).partitions(1).replicas(1).compact().build());
//    }

    @Bean
    public NewTopic players(){
        return TopicBuilder.name(KafkaTopics.PLAYER_SESSION).partitions(1).replicas(1).compact().build();
    }
}
