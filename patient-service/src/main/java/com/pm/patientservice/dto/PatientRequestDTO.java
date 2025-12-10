package com.pm.patientservice.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequestDTO {
        @NotBlank
        @Size(max = 100 ,message = "Name can not exceed more than 100 characters")
        private String name;

        @NotBlank(message ="email is required")
        @Email(message = "email is required")
        private String email;

        @NotBlank(message ="address is required")
        private String address;

        @NotBlank(message ="Date of Birth is required")
        private String  dateOfBirth;

        @NotBlank(message ="Registered Date is required")
        private String registeredDate;

    }


