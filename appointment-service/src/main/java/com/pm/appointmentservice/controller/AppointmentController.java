package com.pm.appointmentservice.controller;

import com.pm.appointmentservice.dto.AppointmentRequestDTO;
import com.pm.appointmentservice.dto.AppointmentResponseDTO;
import com.pm.appointmentservice.model.Appointment;
import com.pm.appointmentservice.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class AppointmentController {

    private final AppointmentService appointmentService;
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Appointment Service";
    }

    @PostMapping("/appointments")
    @Operation(summary = "create a new appointment")
    public ResponseEntity<AppointmentResponseDTO> createAppointment(@RequestBody @Valid AppointmentRequestDTO appointmentRequestDTO){
    AppointmentResponseDTO appointmentResponseDTO = appointmentService.createAppointment(appointmentRequestDTO);
   return ResponseEntity.status(HttpStatus.CREATED).body(appointmentResponseDTO);

}
    @GetMapping("/appointments/{patientId}")
    @Operation(summary = "get all appointments by a patient with id as input")
    public ResponseEntity<List<AppointmentResponseDTO>> getAllAppointmentsByPatient(@PathVariable UUID patientId)
    {
        List<AppointmentResponseDTO> allAppointmentsByPatient = appointmentService.getAllAppointmentsByPatient(patientId);
        return ResponseEntity.status(HttpStatus.OK).body(allAppointmentsByPatient);
    }

    @GetMapping("/appointments")
    @Operation(summary = "get all appointments in the system")
    public ResponseEntity<List<AppointmentResponseDTO>> getAllAppointments()
    {
        List<AppointmentResponseDTO> allAppointments = appointmentService.getAllAppointments();
        return ResponseEntity.status(HttpStatus.OK).body(allAppointments);
    }


}
