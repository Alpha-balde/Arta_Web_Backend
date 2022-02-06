package com.ibmap.dental.rest.member;

import com.ibmap.dental.application.typology.CivilStatus;
import com.ibmap.dental.application.typology.Gender;
import com.ibmap.dental.application.typology.MemberStatus;
import com.ibmap.dental.domaine.entities.Contribution;
import com.ibmap.dental.domaine.entities.Family;
import com.ibmap.dental.domaine.entities.Insurance;
import com.ibmap.dental.rest.contribution.ContributionFrontDto;
import com.ibmap.dental.rest.family.FamilyFrontDto;
import com.ibmap.dental.rest.frontdto.FrontDto;
import com.ibmap.dental.rest.insurance.InsuranceFrontDto;
import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.From;
import javax.validation.constraints.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MemberFrontDto implements FrontDto {
    private String businessKey;
    private Instant createdOn;

    @NotBlank
    private String memberId;
    @NotBlank
    private String lastName;
    @NotBlank
    private String firstName;
    @NotNull
    private CivilStatus civilStatus;
    @NotBlank
    private String address;
    @NotBlank
    private String phoneNumber;
    @Email
    private String email;
    @NotNull
    private Gender gender;
    @NotBlank
    private String districtOrigin;
    @Past
    private LocalDate dateOfBirth;
    @NotNull
    private MemberStatus status;
    @PastOrPresent
    private LocalDate registrationDate;
    @NotBlank
    private String pictureURL;
    @NotNull
    private List<InsuranceFrontDto> insurance = new ArrayList<>();
    @NotNull
    private List<ContributionFrontDto> contribution = new ArrayList<>();
    @NotNull
    private FamilyFrontDto family;
}
