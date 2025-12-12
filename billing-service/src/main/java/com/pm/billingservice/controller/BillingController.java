package com.pm.billingservice.controller;

import com.pm.billingservice.entity.Billing;
import com.pm.billingservice.service.BillingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class BillingController {

    private final BillingService billingService;
    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Billing Service";
    }
    @GetMapping("/patient/{patientId}")
    public List<Billing> getByPatient(@PathVariable UUID patientId) {
        return billingService.getByPatient(patientId);
    }

    @GetMapping("/appointment/{appointmentId}")
    public Billing getByAppointment(@PathVariable Long appointmentId) {
        return billingService.getByAppointment(appointmentId);
    }

}
