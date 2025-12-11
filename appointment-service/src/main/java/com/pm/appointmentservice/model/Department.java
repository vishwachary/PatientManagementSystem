package com.pm.appointmentservice.model;

import java.util.List;

public record Department(
        String name,
        List<Doctor> doctors
) {}