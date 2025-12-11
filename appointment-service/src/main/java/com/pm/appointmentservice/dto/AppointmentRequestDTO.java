package com.pm.appointmentservice.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class AppointmentRequestDTO {

    @NotNull(message ="patientId is required")
    private UUID patientId;

    @NotNull(message ="doctorId is required")
    private Long doctorId;

    @NotBlank(message ="doctorName is required")
    private String doctorName;

    @NotBlank(message ="department is required")
    private String department;

    @NotBlank(message ="Appointment DateTime is required")
    private String appointmentDate;

    @NotBlank(message ="status is required")
    private String status;
}
