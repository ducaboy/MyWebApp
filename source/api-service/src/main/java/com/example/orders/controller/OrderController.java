package com.example.orders.controller;

import com.example.orders.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final JmsTemplate jmsTemplate;

    public OrderController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping
    public ResponseEntity<String> submitOrder(@RequestBody Order order) {

        jmsTemplate.convertAndSend("order.queue", order);

        return ResponseEntity.accepted().body("Order sent to queue");
    }
}