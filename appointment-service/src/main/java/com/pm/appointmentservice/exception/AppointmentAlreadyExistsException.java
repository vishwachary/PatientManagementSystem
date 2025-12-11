package com.pm.appointmentservice.exception;

public class AppointmentAlreadyExistsException extends RuntimeException {
    public AppointmentAlreadyExistsException(String message) {
        super(message);
    }
}
