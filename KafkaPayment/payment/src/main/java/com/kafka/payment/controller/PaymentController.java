package com.kafka.payment.controller;

import com.kafka.payment.model.PaymentEvent;
import com.kafka.payment.producer.PaymentProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentProducer paymentProducer;

    public PaymentController(PaymentProducer paymentProducer) {
        this.paymentProducer = paymentProducer;
    }

    @PostMapping
    public String createPayment(
            @RequestBody PaymentEvent paymentEvent) {

        paymentProducer.sendPayment(paymentEvent);

        return "Payment pushed to Kafka successfully";
    }
}
