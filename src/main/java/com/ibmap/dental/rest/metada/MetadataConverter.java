package com.ibmap.dental.rest.metada;

import com.ibmap.dental.domaine.entities.Metadata;
import com.ibmap.dental.rest.contribution.ContributionConverter;
import com.ibmap.dental.rest.frontdto.Converter;
import com.ibmap.dental.rest.insurance.InsuranceConverter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetadataConverter implements Converter<Metadata, MetadataFrontDto> {
    private InsuranceConverter insuranceConverter;
    private ContributionConverter contributionConverter;
    @Autowired
    public MetadataConverter(InsuranceConverter insuranceConverter, ContributionConverter contributionConverter) {
        this.insuranceConverter = insuranceConverter;
        this.contributionConverter = contributionConverter;
    }
    @Override
    public Metadata toEntity(@NonNull MetadataFrontDto frontDto) {

        return Metadata.builder()
                .businessKey(frontDto.getBusinessKey())
                .createdOn(frontDto.getCreatedOn())
                .amount(frontDto.getAmount())
                .creationDate(frontDto.getCreationDate())
                .paymentType(frontDto.getPaymentType())
                .insurance(insuranceConverter.toEntities(frontDto.getInsurance()))
                .contribution(contributionConverter.toEntities(frontDto.getContribution()))
                .version(frontDto.getVersion())
                .build();
    }

    @Override
    public MetadataFrontDto toFrontDto(@NonNull Metadata entity) {

        return MetadataFrontDto.builder()
                .businessKey(entity.getBusinessKey())
                .createdOn(entity.getCreatedOn())
                .amount(entity.getAmount())
                .creationDate(entity.getCreationDate())
                .paymentType(entity.getPaymentType())
                .insurance(insuranceConverter.toFrontDtos(entity.getInsurance()))
                .contribution(contributionConverter.toFrontDtos(entity.getContribution()))
                .version(entity.getVersion())
                .build();
    }
}
