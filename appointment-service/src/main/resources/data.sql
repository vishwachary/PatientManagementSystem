CREATE TABLE IF NOT EXISTS appointment (
    id SERIAL PRIMARY KEY,
    patient_id UUID NOT NULL,
    doctor_id BIGINT NOT NULL,
    doctor_name VARCHAR(200),
    department VARCHAR(100),
    appointment_date DATE NOT NULL,
    status VARCHAR(20) NOT NULL
);

INSERT INTO appointment(patient_id, doctor_id, doctor_name, department, appointment_date, status)
VALUES (
    '223e4567-e89b-12d3-a456-426614174013',
    5,
    'Dr. Kapoor',
    'Orthopedics',
     '2025-12-12',
    'CONFIRMED'
);


INSERT INTO appointment(patient_id, doctor_id, doctor_name, department, appointment_date, status)
VALUES (
    '223e4567-e89b-12d3-a456-426614174014',
    7,
    'Dr. Patel',
    'Dermatology',
    '2025-12-14',
    'CONFIRMED'
);


INSERT INTO appointment(patient_id, doctor_id, doctor_name, department, appointment_date, status)
VALUES (
    '223e4567-e89b-12d3-a456-426614174006',
    9,
    'Dr. Reddy',
    'Pediatrics',
    '2025-12-18',
    'CONFIRMED'
);


INSERT INTO appointment(patient_id, doctor_id, doctor_name, department, appointment_date, status)
VALUES (
    '123e4567-e89b-12d3-a456-426614174003',
    3,
    'Dr. Rao',
    'Neurology',
    '2025-12-15',
    'CONFIRMED'
);