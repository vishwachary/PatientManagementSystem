package com.pm.billingservice.service;


import com.pm.billingservice.repository.BillingRepository;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

    private final BillingRepository billingRepository;
    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    // basic fixed fee for demo; later make configurable
    private static final double CONSULTATION_FEE = 500.0;
}
