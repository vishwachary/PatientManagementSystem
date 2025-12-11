package com.pm.billingservice.service;


import com.pm.billingservice.dto.AppointmentEventDTO;
import com.pm.billingservice.entity.Billing;
import com.pm.billingservice.repository.BillingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BillingService {

    private final BillingRepository billingRepository;
    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    // basic fixed fee for demo; later make configurable
    private static final double CONSULTATION_FEE = 500.0;

    public Billing createBillingFromAppointmentEvent(AppointmentEventDTO evt) {
        // prevent duplicate invoice for same appointment
        if (billingRepository.existsByAppointmentId(evt.id())) {
            return billingRepository.findByAppointmentId(evt.id()).orElseThrow();
        }

        Billing b = Billing.builder()
                .patientId(evt.patientId())
                .appointmentId(evt.id())
                .amount(CONSULTATION_FEE)
                .status("PENDING")
                .createdAt(LocalDateTime.now())
                .build();

        return billingRepository.save(b);
    }

    public List<Billing> getByPatient(UUID patientId) {
        return billingRepository.findByPatientIdOrderByCreatedAtDesc(patientId);
    }

    public Billing getByAppointment(Long appointmentId) {
        return billingRepository.findByAppointmentId(appointmentId).orElse(null);
    }
}
