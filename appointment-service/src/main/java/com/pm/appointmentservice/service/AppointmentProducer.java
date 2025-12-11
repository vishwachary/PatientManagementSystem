package com.pm.appointmentservice.service;

import com.pm.appointmentservice.model.Appointment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AppointmentProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public AppointmentProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendAppointmentConfirmedEvent(Appointment appointment) {
        kafkaTemplate.send("appointment-confirmed", appointment);
        System.out.println("Sent Kafka Event → appointment-confirmed: " + appointment.getId());
    }
}
