package com.ibmap.dental.application.services.impl;

import com.ibmap.dental.application.exception.NotFoundExpensesException;
import com.ibmap.dental.application.services.IExpensesService;
import com.ibmap.dental.domaine.entities.Expenses;
import com.ibmap.dental.repositories.ExpensesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ExpensesServiceImpl implements IExpensesService {

    private ExpensesRepository expensesRepository;

    public ExpensesServiceImpl(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    @Override
    public void addNewExpense( Expenses expenses) {
        expensesRepository.save(expenses);
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
    public List<Expenses> getExpensesByDateBefor(LocalDate date) {
        return expensesRepository.getExpensesByAmountDateBefore(date);
    }

    @Override
    public List<Expenses> getExpensesByDateAfterDesc(LocalDate date) {
        return expensesRepository.getExpensesByAmountDateAfterOOrderByAmountDateDesc(date);
    }

    @Override
    public void deleteExpense(Long id) throws NotFoundExpensesException{
        Optional<Expenses> expensesOptional= Optional.ofNullable(expensesRepository.getExpensesById(id));
        if(!expensesOptional.isPresent()){
            throw new NotFoundExpensesException("Expenses doesn't exist");
        }
        expensesRepository.deleteById(id);
    }

    @Override
    public Expenses updateExpense(Expenses expenses) throws NotFoundExpensesException {
        Optional<Expenses> expensesOptional= Optional.ofNullable(expensesRepository.getExpensesById(expenses.getId()));
        if(!expensesOptional.isPresent()){
            throw new NotFoundExpensesException("Expenses not found"+expenses.toString());
        }
        return expensesRepository.save(expenses);
    }

    @Override
    public Expenses getExpensesById(Long id) throws NotFoundExpensesException{
        Optional<Expenses> expensesOptional= Optional.ofNullable(expensesRepository.getExpensesById(id));
        if(!expensesOptional.isPresent()){
            throw new NotFoundExpensesException("Expenses doesn't exist");
        }
        return expensesRepository.getExpensesById(id);
    }

    @Override
    public List<Expenses> getExpensesAll() {
        return expensesRepository.findAll();
    }
}
