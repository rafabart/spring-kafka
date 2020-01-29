package com.springkafkaproducer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Component
public class OrderProducer {

    @Value("${first.topic}")
    private String firstTopic;

    @Value("${second.topic}")
    private String secondTopic;

    final private KafkaTemplate kafkaTemplate;

    @Autowired
    public OrderProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /*
     * Não é obrigatório enviar a chave da mensagem, inclusive tem o método send no kafkaTemplate,
     * porém como o Kafka trabalha com um mapa (chave/valor) é recomendado enviar uma chave única para mensagem.
     * 'messageKey' é a chave única da mensagem a ser enviada.
     * */
    public void send(final @RequestBody String order) {


        final String messageKey = UUID.randomUUID().toString();

        kafkaTemplate.send(firstTopic, messageKey, order);
    }


    public void sendCompleteInfo(final @RequestBody String order) {

        final String messageKey = UUID.randomUUID().toString();

        kafkaTemplate.send(secondTopic, messageKey, order);
    }
}
