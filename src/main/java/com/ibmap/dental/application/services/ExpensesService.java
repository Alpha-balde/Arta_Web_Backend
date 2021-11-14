package com.ibmap.dental.application.services;

import com.ibmap.dental.domaine.entities.Expenses;

import java.time.LocalDate;
import java.util.List;

public interface ExpensesService extends CommonsService<Expenses> {

     List<Expenses> getExpensesByReason(String reason);
     List<Expenses> getExpensesByDate(LocalDate date);
     List<Expenses> getExpensesByDateBetween(LocalDate minDate,LocalDate maxDate);
     List<Expenses> getExpensesByDateBefore(LocalDate date);
     List<Expenses> getExpensesByDateAfterDesc(LocalDate date);

}
