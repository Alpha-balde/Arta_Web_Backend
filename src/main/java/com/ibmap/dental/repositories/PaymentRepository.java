package com.ibmap.dental.repositories;

import com.ibmap.dental.domaine.entities.Payment;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CommonsRepository<Payment,Long> {
}
