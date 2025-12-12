package com.pm.appointmentservice.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pm.appointmentservice.dto.AppointmentEventDTO;
import com.pm.appointmentservice.model.Appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AppointmentProducer {
    Logger logger = LoggerFactory.getLogger(AppointmentProducer.class);
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public AppointmentProducer(KafkaTemplate<String, Object> kafkaTemplate, ObjectMapper objectMapper)
    {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendAppointmentConfirmedEvent(Appointment appointment) {
        AppointmentEventDTO event = AppointmentEventDTO.builder()
                .id(appointment.getId())
                .patientId(appointment.getPatientId())
                .doctorId(appointment.getDoctorId())
                .doctorName(appointment.getDoctorName())
                .department(appointment.getDepartment())
                .appointmentTime(appointment.getAppointmentDate())
                .status(appointment.getStatus().name())
                .build();

        logger.info("Sending appointment confirmed event: {}", event);

       // try {
        //    String json = objectMapper.writeValueAsString(event);
          //  logger.info("Sending appointment-confirmed event as JSON: {}", json);

            // Send raw JSON
           // kafkaTemplate.send("appointment-confirmed", json);

            kafkaTemplate.send("appointment-confirmed",event);
      //  } catch (JsonProcessingException e) {
         //   throw new RuntimeException(e);
       // }


    }
}
