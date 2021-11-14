package com.ibmap.dental.repositories;

import com.ibmap.dental.domaine.entities.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpensesRepository extends CommonsRepository<Expenses, Long> {

    List<Expenses> getExpensesByReason(String reason);

    //Expenses getExpensesById( Long id);
    List<Expenses> getExpensesByAmountDateBetween(LocalDate minDate, LocalDate maxDate);

    List<Expenses> getExpensesByAmountDateAfterOrderByAmountDateDesc(LocalDate date);

    List<Expenses> getExpensesByAmountDateBefore(LocalDate date);

    List<Expenses> getExpensesByAmountDate(LocalDate date);

}
