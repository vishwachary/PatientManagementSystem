package com.pm.billingservice.controller;

import com.pm.billingservice.service.BillingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BillingController {

    private final BillingService billingService;
    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }


}
