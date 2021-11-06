package com.ibmap.dental.application.services;

import com.ibmap.dental.application.exception.NotFoundExpensesException;
import com.ibmap.dental.domaine.entities.Expenses;

import java.time.LocalDate;
import java.util.List;

public interface IExpensesService {

    public void  addNewExpense(Expenses expenses);
    public List<Expenses> getExpensesByReason(String reason);
    public List<Expenses> getExpensesByDate(LocalDate date);
    public List<Expenses> getExpensesByDateBetween(LocalDate minDate,LocalDate maxDate);
    public List<Expenses> getExpensesByDateBefor(LocalDate date);
    public List<Expenses> getExpensesByDateAfterDesc(LocalDate date);
    public void deleteExpense(Long id) throws NotFoundExpensesException;
    public Expenses updateExpense(Expenses expenses) throws NotFoundExpensesException;
    public Expenses getExpensesById(Long id) throws NotFoundExpensesException;
    public List<Expenses> getExpensesAll();

}
