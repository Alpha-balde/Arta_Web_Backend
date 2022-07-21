package com.ibmap.dental.application.services.impl;

import com.ibmap.dental.domaine.entities.Payment;
import com.ibmap.dental.repositories.CommonsRepository;
import com.ibmap.dental.repositories.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentServiceImp implements PaymentService{
    private PaymentRepository paymentRepository;

    public PaymentServiceImp(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment update(Payment entity) {
        Payment payment= findByBusinessKey(entity.getBusinessKey());
        payment.update(entity);
        return payment;
    }

    @Override
    public CommonsRepository getRepo() {
        return paymentRepository;
    }
}
