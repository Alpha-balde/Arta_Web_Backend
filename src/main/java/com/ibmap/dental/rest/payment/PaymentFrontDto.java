package com.ibmap.dental.rest.payment;

import com.ibmap.dental.application.typology.PaymentMode;
import com.ibmap.dental.application.typology.PaymentType;
import com.ibmap.dental.domaine.entities.Contribution;
import com.ibmap.dental.domaine.entities.Insurance;
import com.ibmap.dental.rest.contribution.ContributionFrontDto;
import com.ibmap.dental.rest.frontdto.FrontDto;
import com.ibmap.dental.rest.insurance.InsuranceFrontDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaymentFrontDto implements FrontDto {
    private String businessKey;
    private Instant createdOn;
    @PastOrPresent
    private LocalDate paymentDate;

    @NotNull
    private PaymentMode paymentMode;

    @NotNull
    private PaymentType paymentType;

    @Positive
    private double payment_amount;

    private String comment;
    @NotNull
    private List<InsuranceFrontDto> insurance = new ArrayList<>();
    @NotNull
    private List<ContributionFrontDto> contribution = new ArrayList<>();
}
