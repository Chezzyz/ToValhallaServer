package ru.rsc.tovalhallaserver.processors;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@RequiredArgsConstructor
public class StartKafkaListenersHandler {

    private final KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

    @EventListener
    @SneakyThrows
    public void onApplicationReady(ApplicationReadyEvent event) {
        kafkaListenerEndpointRegistry.getAllListenerContainers().forEach(c -> {
        log.info("starting kafka listener: " + c.toString());
        c.start();
      });
    }
}
