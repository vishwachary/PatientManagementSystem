package com.pm.billingservice.repository;

import com.pm.billingservice.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BillingRepository extends JpaRepository<Billing,Long> {


    List<Billing> findByPatientIdOrderByCreatedAtDesc(UUID patientId);
    Optional<Billing> findByAppointmentId(Long appointmentId);
    boolean existsByAppointmentId(Long appointmentId);

}
