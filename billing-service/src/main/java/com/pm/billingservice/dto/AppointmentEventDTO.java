package com.pm.billingservice.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record AppointmentEventDTO(
        Long id,
        UUID patientId,
        Long doctorId,
        String doctorName,
        String department,
        LocalDateTime appointmentTime,
        String status
) {}