package com.pm.appointmentservice.service;

import com.pm.appointmentservice.dto.AppointmentRequestDTO;
import com.pm.appointmentservice.dto.AppointmentResponseDTO;
import com.pm.appointmentservice.exception.AppointmentAlreadyExistsException;
import com.pm.appointmentservice.mapper.AppointmentMapper;
import com.pm.appointmentservice.model.Appointment;
import com.pm.appointmentservice.repository.AppointmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {

    Logger logger = LoggerFactory.getLogger(AppointmentService.class);


    private final AppointmentRepository appointmentRepository;
    private final  AppointmentProducer producer;
    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentProducer producer) {
        this.appointmentRepository = appointmentRepository;
        this.producer = producer;
    }



    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO appointmentRequestDTO)
    {
        boolean appointmentExists = appointmentRepository
                .existsByDoctorNameAndAppointmentDate(
                        appointmentRequestDTO.getDoctorName(),
                        LocalDateTime.parse(appointmentRequestDTO.getAppointmentDate())
                );

        if(appointmentExists) {
        throw new AppointmentAlreadyExistsException("Appointment already exists with doctor" + appointmentRequestDTO.getDoctorName());
    }

        Appointment newAppointment = appointmentRepository.save(AppointmentMapper.toModel(appointmentRequestDTO));
        logger.info("New Appointment Created Successfully");

        logger.info("Called producer to sent message to kafka topic Successfully {}", newAppointment);
        // fire Kafka event
        producer.sendAppointmentConfirmedEvent(newAppointment);

        return AppointmentMapper.toDTO(newAppointment);

    }

    public List<AppointmentResponseDTO> getAllAppointments()
    {

        List<Appointment> allAppointmentAsEntity = appointmentRepository.findAll();

        logger.info("allAppointmentAsEntity { }", allAppointmentAsEntity);
        allAppointmentAsEntity.stream().forEach(System.out::println);


        List<AppointmentResponseDTO> appointmentResponseDTOList = new ArrayList<>();

        allAppointmentAsEntity.forEach(appointment -> {
            AppointmentResponseDTO appointmentResponseDTO = AppointmentMapper.toDTO(appointment);
            appointmentResponseDTOList.add(appointmentResponseDTO);
        });
        return appointmentResponseDTOList;

    }

    public List<AppointmentResponseDTO> getAllAppointmentsByPatient(UUID patientId)
    {
        List<Appointment> appointments =
                appointmentRepository.findByPatientIdOrderByAppointmentDateDesc(patientId);

        return appointments.stream()
                .map(a -> AppointmentResponseDTO.builder()
                        .appointmentId(String.valueOf(a.getId()))
                        .patientId(String.valueOf(a.getPatientId()))
                        .appointmentDate(a.getAppointmentDate().toString())
                        .appointmentStatus(a.getStatus().name())
                        .build())
                .toList();

    }

}
