package com.kafka.payment.producer;

import com.kafka.payment.model.PaymentEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducer {

    private static final String TOPIC = "online-payments";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PaymentProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPayment(PaymentEvent paymentEvent) {

        try {
            String json =
                    objectMapper.writeValueAsString(paymentEvent);

            kafkaTemplate.send(
                    TOPIC,
                    paymentEvent.getPaymentId(), // KEY
                    json
            );

            System.out.println(
                    "Payment sent to Kafka: " + json
            );

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to send payment to Kafka", e);
        }
    }
}
