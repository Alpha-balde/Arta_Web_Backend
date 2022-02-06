package com.ibmap.dental.rest.member;

import com.ibmap.dental.domaine.entities.Member;
import com.ibmap.dental.rest.contribution.ContributionConverter;
import com.ibmap.dental.rest.family.FamilyConverter;
import com.ibmap.dental.rest.frontdto.Converter;
import com.ibmap.dental.rest.insurance.InsuranceConverter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MemberConverter implements Converter<Member, MemberFrontDto> {


    private FamilyConverter familyConverter;
    private ContributionConverter contributionConverter;
    private InsuranceConverter insuranceConverter;

    @Autowired
    public MemberConverter(FamilyConverter familyConverter, ContributionConverter contributionConverter,InsuranceConverter insuranceConverter) {
        this.familyConverter = familyConverter;
        this.contributionConverter = contributionConverter;
        this.insuranceConverter= insuranceConverter;
    }



    @Override
    public Member toEntity(@NonNull MemberFrontDto frontDto) {
        return Member.builder()
                .businessKey(frontDto.getBusinessKey())
                .memberId(frontDto.getMemberId())
                .createdOn(frontDto.getCreatedOn())
                .address(frontDto.getAddress())
                .civilStatus(frontDto.getCivilStatus())
                .dateOfBirth(frontDto.getDateOfBirth())
                .email(frontDto.getEmail())
                .firstName(frontDto.getFirstName())
                .lastName(frontDto.getLastName())
                .gender(frontDto.getGender())
                .districtOrigin(frontDto.getDistrictOrigin())
                .contribution(contributionConverter.toEntities(frontDto.getContribution()))
                .family(familyConverter.toEntity(frontDto.getFamily()))
                .phoneNumber(frontDto.getPhoneNumber())
                .pictureURL(frontDto.getPictureURL())
                .registrationDate(frontDto.getRegistrationDate())
                .status(frontDto.getStatus())
                .insurance(insuranceConverter.toEntities(frontDto.getInsurance()))
                .build();
    }

    @Override
    public MemberFrontDto toFrontDto(@NonNull Member entity) {
        return MemberFrontDto.builder()
                .businessKey(entity.getBusinessKey())
                .memberId(entity.getMemberId())
                .createdOn(entity.getCreatedOn())
                .address(entity.getAddress())
                .civilStatus(entity.getCivilStatus())
                .dateOfBirth(entity.getDateOfBirth())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .gender(entity.getGender())
                .districtOrigin(entity.getDistrictOrigin())
                .contribution(contributionConverter.toFrontDtos(entity.getContribution()))
                .family(familyConverter.toFrontDto(entity.getFamily()))
                .phoneNumber(entity.getPhoneNumber())
                .pictureURL(entity.getPictureURL())
                .registrationDate(entity.getRegistrationDate())
                .status(entity.getStatus())
                .insurance(insuranceConverter.toFrontDtos(entity.getInsurance()))
                .build();
    }
}
