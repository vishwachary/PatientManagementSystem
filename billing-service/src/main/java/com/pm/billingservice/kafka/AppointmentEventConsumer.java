package com.pm.billingservice.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pm.billingservice.dto.AppointmentEventDTO;
import com.pm.billingservice.service.BillingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
@Service
public class AppointmentEventConsumer {

    Logger logger = LoggerFactory.getLogger(AppointmentEventConsumer.class);

    private final BillingService billingService;
    private final ObjectMapper objectMapper;
    public AppointmentEventConsumer(BillingService billingService, ObjectMapper objectMapper) {
        this.billingService = billingService;
        this.objectMapper = objectMapper;
    }


    /*@KafkaListener(topics = "appointment-confirmed", groupId = "billing-group")
    public void consume(AppointmentEventDTO event) {
        logger.info("Received appointment-confirmed event: { }",event.toString());
        System.out.println("Received appointment-confirmed event: " + event);
        billingService.createBillingFromAppointmentEvent(event);
    } */

    @KafkaListener(topics = "appointment-confirmed", groupId = "billing-group")
    public void consume(String rawJson) throws JsonProcessingException {
        AppointmentEventDTO event = objectMapper.readValue(rawJson, AppointmentEventDTO.class);
        logger.info("Received appointment-confirmed event: { }",event.toString());
        System.out.println("Received appointment-confirmed event: " + event);
        billingService.createBillingFromAppointmentEvent(event);
    }

}
