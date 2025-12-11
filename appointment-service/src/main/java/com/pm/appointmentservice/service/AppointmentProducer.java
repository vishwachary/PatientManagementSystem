package com.pm.appointmentservice.service;

import com.pm.appointmentservice.model.Appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AppointmentProducer {
    Logger logger = LoggerFactory.getLogger(AppointmentProducer.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public AppointmentProducer(KafkaTemplate<String, Object> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendAppointmentConfirmedEvent(Appointment appointment) {
        logger.info("Sending appointment confirmed event: { }",appointment.toString());
        kafkaTemplate.send("appointment-confirmed", appointment);
        System.out.println("Sent Kafka Event → appointment-confirmed: " + appointment.getId());
    }
}
