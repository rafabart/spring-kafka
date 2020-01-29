package com.springkafkaproducer.controller;

import com.springkafkaproducer.producer.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    final private OrderProducer orderProducer;

    @Autowired
    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }


    @PostMapping
    public void send(@RequestBody String message) {
        orderProducer.send(message);
    }


    @PostMapping("/record")
    public void sendRecord(@RequestBody String message) {
        orderProducer.sendCompleteInfo(message);
    }
}
