package com.ibmap.dental.rest.expenses;

import com.ibmap.dental.application.exception.NotFoundExpensesException;
import com.ibmap.dental.application.services.IExpensesService;
import com.ibmap.dental.application.services.impl.ExpensesServiceImpl;
import com.ibmap.dental.domaine.entities.Expenses;
import com.ibmap.dental.rest.frontdto.FrontDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/expenses")
public class ExpensesRestController {

    private IExpensesService iExpensesService;
    private ExpensesConverter expensesConverter;
    @Autowired
    public ExpensesRestController(IExpensesService iExpensesService, ExpensesConverter expensesConverter) {
        this.iExpensesService = iExpensesService;
        this.expensesConverter = expensesConverter;
    }

    @PostMapping("/new")
    public Expenses addNewExpenses(@RequestBody @Valid ExpensesFrontDto expensesFrontDto){
        Expenses expenses= expensesConverter.toEntity(expensesFrontDto);
        return iExpensesService.addNewExpense(expenses);
    }
    @GetMapping("/{id}")
    public ExpensesFrontDto getExpensesById(@PathVariable Long id){
        try {
            Expenses expenses = iExpensesService.getExpensesById(id);
            return expensesConverter.toFrontDto(expenses);
        } catch (NotFoundExpensesException e) {
            e.printStackTrace();
        }
        return null;
    }
    @PutMapping("/update")
    public ExpensesFrontDto updateExpenses(@RequestBody ExpensesFrontDto expensesFrontDto){
        try {
            Expenses expenses = expensesConverter.toEntity(expensesFrontDto);
            expenses = iExpensesService.updateExpense(expenses);
            return expensesConverter.toFrontDto(expenses);
        } catch (NotFoundExpensesException e) {
            e.printStackTrace();
        }
        return null;
    }
    @GetMapping("/all")
    public List<ExpensesFrontDto>  getAllExpenses(){
        List<Expenses> expenses= iExpensesService.getExpensesAll();
        if (expenses == null || expenses.isEmpty()){
            return  new ArrayList<>();
        }
        return  expensesConverter.toFrontDtos(expenses);
    }
}
