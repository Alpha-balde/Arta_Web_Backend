package com.ibmap.dental.rest.contribution;

import com.ibmap.dental.rest.frontdto.FrontDto;
import com.ibmap.dental.rest.member.MemberFrontDto;
import com.ibmap.dental.rest.metada.MetadataFrontDto;
import com.ibmap.dental.rest.payment.PaymentFrontDto;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.Instant;
import java.time.Month;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ContributionFrontDto implements FrontDto {
    private String businessKey;
    private Instant createdOn;
    private MemberFrontDto member;
    @NotNull
    private PaymentFrontDto payment;
    @NotNull
    private MetadataFrontDto metadata;
    @Positive
    private int year;
    @NotNull
    private Month month;
}
