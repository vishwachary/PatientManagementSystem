package com.pm.appointmentservice.mapper;

import com.pm.appointmentservice.dto.AppointmentRequestDTO;
import com.pm.appointmentservice.dto.AppointmentResponseDTO;
import com.pm.appointmentservice.dto.AppointmentStatus;
import com.pm.appointmentservice.model.Appointment;

import java.time.LocalDateTime;

public class AppointmentMapper {

    public static AppointmentResponseDTO toDTO(Appointment appointment) {

        return   AppointmentResponseDTO.builder()
                .appointmentId(appointment.getId().toString())
                .appointmentDate(appointment.getAppointmentDate().toString())
                .doctorName(appointment.getDoctorName())
                .departmentName(appointment.getDepartment())
                .appointmentStatus(appointment.getStatus().name())
                .patientId(appointment.getPatientId().toString()).build();
    }

    public static Appointment toModel(AppointmentRequestDTO  appointmentRequestDTO) {

        return Appointment.builder().patientId(appointmentRequestDTO.getPatientId())
                .appointmentDate(LocalDateTime.parse(appointmentRequestDTO.getAppointmentDate()))
                .doctorName(appointmentRequestDTO.getDoctorName())
                .department(appointmentRequestDTO.getDepartment())
                .doctorId(appointmentRequestDTO.getDoctorId())
                .status(AppointmentStatus.valueOf(appointmentRequestDTO.getStatus())).build();

    }
}
