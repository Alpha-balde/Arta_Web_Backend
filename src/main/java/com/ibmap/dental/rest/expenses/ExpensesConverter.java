package com.ibmap.dental.rest.expenses;

import com.ibmap.dental.domaine.entities.Expenses;
import com.ibmap.dental.rest.frontdto.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExpensesConverter implements Converter<Expenses,ExpensesFrontDto> {
    @Override
    public Expenses toEntity(ExpensesFrontDto frontDto) {
        return Expenses.builder()
                .id(frontDto.getId())
                .businessKey(frontDto.getBusinessKey())
                .createdOn(frontDto.getCreatedOn())
                .amount(frontDto.getAmount())
                .amountDate(frontDto.getAmountDate())
                .comment(frontDto.getComment())
                .reason(frontDto.getReason())
                .build();
    }

    @Override
    public ExpensesFrontDto toFrontDto(Expenses entity) {
        return ExpensesFrontDto.builder()
                .businessKey(entity.getBusinessKey())
                .createdOn(entity.getCreatedOn())
                .amount(entity.getAmount())
                .amountDate(entity.getAmountDate())
                .comment(entity.getComment())
                .reason(entity.getReason())
                .build();
    }
}
