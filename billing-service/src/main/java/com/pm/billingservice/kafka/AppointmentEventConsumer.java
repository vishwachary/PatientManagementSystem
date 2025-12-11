package com.pm.billingservice.kafka;

import com.pm.billingservice.dto.AppointmentEventDTO;
import com.pm.billingservice.service.BillingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AppointmentEventConsumer {

    Logger logger = LoggerFactory.getLogger(AppointmentEventConsumer.class);

    private final BillingService billingService;
    public AppointmentEventConsumer(BillingService billingService) {
        this.billingService = billingService;
    }


    @KafkaListener(topics = "appointment-confirmed", groupId = "billing-group")
    public void consume(AppointmentEventDTO event) {
        logger.info("Received appointment-confirmed event: { }",event.toString());
        System.out.println("Received appointment-confirmed event: " + event);
        billingService.createBillingFromAppointmentEvent(event);
    }

}
