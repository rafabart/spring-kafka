package com.springkafkaconsumer.consumer;

import com.springkafkaconsumer.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderConsumer {

    // Método consumidor simples, recebe apenas a mensagem String do topico definido no yml.
    @KafkaListener(topics = "${first.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(String order) {

        System.out.println("Order: " + order);
    }


    /*
     * Esse método recebe como parametro uma classe(ConsumerRecord) da dependência do Kafka que prove
     * outras informações da mensagem como:
     * chave, headers, partição, tópico, timestamp, entre outros.
     */
    @KafkaListener(topics = "${second.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumerInfoComplete(final ConsumerRecord<String, Order> consumerRecord) {
        log.info("key: " + consumerRecord.key());
        log.info("Headers: " + consumerRecord.headers());
        log.info("Partion: " + consumerRecord.partition());
        log.info("Order: " + consumerRecord.value());
    }
}
