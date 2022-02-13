package com.ibmap.dental.rest.insurance;

import com.ibmap.dental.domaine.entities.Insurance;
import com.ibmap.dental.rest.frontdto.Converter;
import com.ibmap.dental.rest.member.MemberConverter;
import com.ibmap.dental.rest.member.MemberFrontDto;
import com.ibmap.dental.rest.metada.MetadataConverter;
import com.ibmap.dental.rest.metada.MetadataFrontDto;
import com.ibmap.dental.rest.payment.PaymentConverter;
import com.ibmap.dental.rest.payment.PaymentFrontDto;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsuranceConverter implements Converter<Insurance,InsuranceFrontDto> {
    private PaymentConverter paymentConverter;
    private MemberConverter memberConverter;
    private MetadataConverter metadataConverter;
    @Autowired
    public InsuranceConverter(PaymentConverter paymentConverter, MemberConverter memberConverter, MetadataConverter metadataConverter) {
        this.paymentConverter = paymentConverter;
        this.memberConverter = memberConverter;
        this.metadataConverter = metadataConverter;
    }

    @Override
    public Insurance toEntity(@NonNull InsuranceFrontDto frontDto) {
        return Insurance.builder()
                .businessKey(frontDto.getBusinessKey())
                .createdOn(frontDto.getCreatedOn())
                .year(frontDto.getYear())
                .member(memberConverter.toEntity(frontDto.getMember()))
                .payment(paymentConverter.toEntity(frontDto.getPayment()))
                .metadata(metadataConverter.toEntity(frontDto.getMetadata()))
                .build();
    }

    @Override
    public InsuranceFrontDto toFrontDto(@NonNull Insurance entity) {

        return InsuranceFrontDto.builder()
                .businessKey(entity.getBusinessKey())
                .createdOn(entity.getCreatedOn())
                .year(entity.getYear())
                .member(memberConverter.toFrontDto(entity.getMember()))
                .payment(paymentConverter.toFrontDto(entity.getPayment()))
                .metadata(metadataConverter.toFrontDto(entity.getMetadata()))
                .build();
    }
}
