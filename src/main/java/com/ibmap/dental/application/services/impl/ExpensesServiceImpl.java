package com.ibmap.dental.application.services.impl;

import com.ibmap.dental.application.services.ExpensesService;
import com.ibmap.dental.domaine.entities.Expenses;
import com.ibmap.dental.repositories.CommonsRepository;
import com.ibmap.dental.repositories.ExpensesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class ExpensesServiceImpl implements ExpensesService {

    private ExpensesRepository expensesRepository;

    public ExpensesServiceImpl(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    @Override
    public List<Expenses> getExpensesByReason(String reason) {
        return expensesRepository.getExpensesByReason(reason);
    }

    @Override
    public List<Expenses> getExpensesByDate(LocalDate date) {
        return expensesRepository.getExpensesByAmountDate(date);
    }

    @Override
    public List<Expenses> getExpensesByDateBetween(LocalDate minDate, LocalDate maxDate) {
        return expensesRepository.getExpensesByAmountDateBetween(minDate,maxDate);
    }

    @Override
    public List<Expenses> getExpensesByDateBefore(LocalDate date) {
        return expensesRepository.getExpensesByAmountDateBefore(date);
    }

    @Override
    public List<Expenses> getExpensesByDateAfterDesc(LocalDate date) {
        return expensesRepository.getExpensesByAmountDateAfterOrderByAmountDateDesc(date);
    }

    @Override
    public Expenses update(Expenses expenses) {
        Expenses persExpenses = this.findByBusinessKey(expenses.getBusinessKey());

        persExpenses.update(expenses);
        return save(persExpenses);
    }

    @Override
    public CommonsRepository getRepo() {
        return expensesRepository;
    }
}
