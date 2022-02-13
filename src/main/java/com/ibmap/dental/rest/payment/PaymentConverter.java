package com.ibmap.dental.rest.payment;

import com.ibmap.dental.domaine.entities.Payment;
import com.ibmap.dental.rest.frontdto.Converter;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class PaymentConverter implements Converter<Payment,PaymentFrontDto> {
    @Override
    public Payment toEntity(@NonNull PaymentFrontDto frontDto) {
        return null;
    }

    @Override
    public PaymentFrontDto toFrontDto(@NonNull Payment entity) {
        return null;
    }
}
