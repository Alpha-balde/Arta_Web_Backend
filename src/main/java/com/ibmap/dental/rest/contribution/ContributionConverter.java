package com.ibmap.dental.rest.contribution;

import com.ibmap.dental.domaine.entities.Contribution;
import com.ibmap.dental.rest.frontdto.Converter;
import com.ibmap.dental.rest.member.MemberConverter;
import com.ibmap.dental.rest.metada.MetadataConverter;
import com.ibmap.dental.rest.payment.PaymentConverter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContributionConverter implements Converter<Contribution, ContributionFrontDto> {
    private PaymentConverter paymentConverter;
    private MemberConverter memberConverter;
    private MetadataConverter metadataConverter;
    @Autowired
    public ContributionConverter(PaymentConverter paymentConverter, MemberConverter memberConverter, MetadataConverter metadataConverter) {
        this.paymentConverter = paymentConverter;
        this.memberConverter = memberConverter;
        this.metadataConverter = metadataConverter;
    }

    @Override
    public Contribution toEntity(@NonNull ContributionFrontDto frontDto) {
        return Contribution.builder()
                .businessKey(frontDto.getBusinessKey())
                .createdOn(frontDto.getCreatedOn())
                .month(frontDto.getMonth())
                .member(memberConverter.toEntity(frontDto.getMember()))
                .payment(paymentConverter.toEntity(frontDto.getPayment()))
                .metadata(metadataConverter.toEntity(frontDto.getMetadata()))
                .year(frontDto.getYear())
                .build();
    }

    @Override
    public ContributionFrontDto toFrontDto(@NonNull Contribution entity) {
        return ContributionFrontDto.builder()
                .businessKey(entity.getBusinessKey())
                .createdOn(entity.getCreatedOn())
                .member(memberConverter.toFrontDto(entity.getMember()))
                .payment(paymentConverter.toFrontDto(entity.getPayment()))
                .metadata(metadataConverter.toFrontDto(entity.getMetadata()))
                .year(entity.getYear())
                .month(entity.getMonth())
               .build() ;
    }
}
