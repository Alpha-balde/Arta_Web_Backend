package com.ibmap.dental.repositories;

import com.ibmap.dental.domaine.entities.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses,Long> {

    public List<Expenses> getExpensesByReason(String reason);
    public Expenses getExpensesById( Long id);
    public List<Expenses> getExpensesByAmountDateBetween(LocalDate minDate, LocalDate maxDate);
    public List<Expenses> getExpensesByAmountDateAfterOrderByAmountDateDesc(LocalDate  date);
    public List<Expenses> getExpensesByAmountDateBefore(LocalDate date);
    public List<Expenses> getExpensesByAmountDate(LocalDate date);

}
