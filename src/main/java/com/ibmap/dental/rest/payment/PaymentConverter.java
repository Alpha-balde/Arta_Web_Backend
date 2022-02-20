package com.ibmap.dental.rest.payment;

import com.ibmap.dental.domaine.entities.Payment;
import com.ibmap.dental.rest.contribution.ContributionConverter;
import com.ibmap.dental.rest.frontdto.Converter;
import com.ibmap.dental.rest.insurance.InsuranceConverter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentConverter implements Converter<Payment,PaymentFrontDto> {
    private InsuranceConverter insuranceConverter;
    private ContributionConverter contributionConverter;
    @Autowired
    public PaymentConverter(InsuranceConverter insuranceConverter, ContributionConverter contributionConverter) {
        this.insuranceConverter = insuranceConverter;
        this.contributionConverter = contributionConverter;
    }

    @Override
    public Payment toEntity(@NonNull PaymentFrontDto frontDto) {
        return Payment.builder()
                .businessKey(frontDto.getBusinessKey())
                .createdOn(frontDto.getCreatedOn())
                .paymentDate(frontDto.getPaymentDate())
                .paymentMode(frontDto.getPaymentMode())
                .payment_amount(frontDto.getPayment_amount())
                .paymentType(frontDto.getPaymentType())
                .comment(frontDto.getComment())
                .contribution(contributionConverter.toEntities(frontDto.getContribution()))
                .insurance(insuranceConverter.toEntities(frontDto.getInsurance()))
                .build();
    }

    @Override
    public PaymentFrontDto toFrontDto(@NonNull Payment entity) {

        return PaymentFrontDto.builder()
                .businessKey(entity.getBusinessKey())
                .createdOn(entity.getCreatedOn())
                .payment_amount(entity.getPayment_amount())
                .paymentDate(entity.getPaymentDate())
                .paymentType(entity.getPaymentType())
                .paymentMode(entity.getPaymentMode())
                .contribution(contributionConverter.toFrontDtos(entity.getContribution()))
                .insurance(insuranceConverter.toFrontDtos(entity.getInsurance()))
                .comment(entity.getComment())
                .build();
    }
}
