package com.pm.appointmentservice.repository;

import com.pm.appointmentservice.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

   List<Appointment> findByPatientIdOrderByAppointmentDateDesc(UUID patientId);
    boolean existsByDoctorNameAndAppointmentDate(String doctorName, LocalDateTime appointmentDate);


}
