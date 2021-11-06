package com.ibmap.dental.rest.expenses;

import com.ibmap.dental.rest.frontdto.FrontDto;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ExpensesFrontDto implements FrontDto {
    private Long id;
    private String businessKey;
    private Instant createdOn;
    @NotBlank
    private double amount;
    /*@NotBlank*/
    private LocalDate amountDate;
    @NotBlank
    @Size(min = 5, max = 20)
    private String reason;
    private String comment;
}
