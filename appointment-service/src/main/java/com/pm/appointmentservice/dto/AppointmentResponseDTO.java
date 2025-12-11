package com.pm.appointmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentResponseDTO {
    private String appointmentId;
    private String patientId;
    private String appointmentDate;
    private String appointmentStatus;
    private String doctorName;
    private String departmentName;

}
