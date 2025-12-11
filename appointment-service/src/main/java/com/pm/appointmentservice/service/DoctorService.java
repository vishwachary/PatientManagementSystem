package com.pm.appointmentservice.service;

import com.pm.appointmentservice.model.Department;
import com.pm.appointmentservice.model.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    public List<Department> getDepartments() {

        return List.of(
                new Department("Cardiology", List.of(
                        new Doctor(1L, "Dr. Mehta", "Cardiology"),
                        new Doctor(2L, "Dr. Sharma", "Cardiology")
                )),
                new Department("Neurology", List.of(
                        new Doctor(3L, "Dr. Rao", "Neurology"),
                        new Doctor(4L, "Dr. Iyer", "Neurology")
                )),
                new Department("Orthopedics", List.of(
                        new Doctor(5L, "Dr. Kapoor", "Orthopedics"),
                        new Doctor(6L, "Dr. Singh", "Orthopedics")
                )),
                new Department("Dermatology", List.of(
                        new Doctor(7L, "Dr. Patel", "Dermatology"),
                        new Doctor(8L, "Dr. Nair", "Dermatology")
                )),
                new Department("Pediatrics", List.of(
                        new Doctor(9L, "Dr. Reddy", "Pediatrics"),
                        new Doctor(10L, "Dr. Das", "Pediatrics")
                )),
                new Department("Ophthalmology", List.of(
                        new Doctor(11L, "Dr. Verma", "Ophthalmology"),
                        new Doctor(12L, "Dr. Roy", "Ophthalmology")
                )),
                new Department("ENT", List.of(
                        new Doctor(13L, "Dr. Pillai", "ENT"),
                        new Doctor(14L, "Dr. Abraham", "ENT")
                )),
                new Department("Gastroenterology", List.of(
                        new Doctor(15L, "Dr. Kumar", "Gastroenterology"),
                        new Doctor(16L, "Dr. Menon", "Gastroenterology")
                )),
                new Department("Urology", List.of(
                        new Doctor(17L, "Dr. Nigam", "Urology"),
                        new Doctor(18L, "Dr. Bhatt", "Urology")
                )),
                new Department("Oncology", List.of(
                        new Doctor(19L, "Dr. Gill", "Oncology"),
                        new Doctor(20L, "Dr. Ahuja", "Oncology")
                ))
        );
    }
}
