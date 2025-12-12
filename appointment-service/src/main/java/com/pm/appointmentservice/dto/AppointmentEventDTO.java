package com.pm.appointmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentEventDTO {
    private Long id;
    private UUID patientId;
    private Long doctorId;
    private String doctorName;
    private String department;
    private LocalDateTime appointmentTime;
    private String status;
}