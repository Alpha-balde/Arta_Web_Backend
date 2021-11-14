package com.ibmap.dental.rest.expenses;

import com.ibmap.dental.application.exception.ErrorDetails;
import com.ibmap.dental.application.services.ExpensesService;
import com.ibmap.dental.domaine.entities.Expenses;
import com.ibmap.dental.rest.meeting.MeetingFrontDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/expenses")
public class ExpensesRestController {

    private ExpensesService expensesService;
    private ExpensesConverter expensesConverter;
    @Autowired
    public ExpensesRestController(ExpensesService expensesService, ExpensesConverter expensesConverter) {
        this.expensesService = expensesService;
        this.expensesConverter = expensesConverter;
    }

    @Operation(summary = "Create an Expense ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The Expense was created successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExpensesFrontDto.class))})
    })

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ExpensesFrontDto expensesFrontDto){
        Expenses expenses= expensesConverter.toEntity(expensesFrontDto);
        Expenses savedExpenses= expensesService.save(expenses);
        expensesFrontDto= expensesConverter.toFrontDto(savedExpenses);

        HttpHeaders responseHeaders= new HttpHeaders();
        URI expensesURI= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{businessKey}")
                .buildAndExpand(expensesFrontDto.getBusinessKey())
                .toUri();
        responseHeaders.setLocation(expensesURI);
        return ResponseEntity.status(HttpStatus.CREATED).headers(responseHeaders).build();
    }


    @Operation(summary = "Get an Expense by its business key")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Expense",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExpensesFrontDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid business key supplied",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))})
    })
    @GetMapping("/{businesskey}")
    public ResponseEntity<ExpensesFrontDto> getByBusinessKey(@PathVariable String businesskey){

            Expenses expenses = expensesService.findByBusinessKey(businesskey);
            ExpensesFrontDto expensesFrontDto= expensesConverter.toFrontDto(expenses);
            return ResponseEntity.status(HttpStatus.OK).body(expensesFrontDto);

    }

    @Operation(summary = "update an Expense using the businee key")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "205", description = "The Expense was updated/reseted successfully",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MeetingFrontDto.class))})
    })

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ExpensesFrontDto expensesFrontDto){
            Expenses expenses = this.expensesService.update(expensesConverter.toEntity(expensesFrontDto));
        expensesFrontDto= expensesConverter.toFrontDto(expenses);
            return ResponseEntity.status(HttpStatus.RESET_CONTENT).body(expensesFrontDto);
    }
    @Operation(summary = "recover all Expensees from the database")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Found the meetings",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ExpensesFrontDto.class))
                    )}),
    })
    @GetMapping
    public ResponseEntity<List<ExpensesFrontDto>>  getAll(){
        List<Expenses> expenses= expensesService.findAll();
        List<ExpensesFrontDto> frontDtos = expensesConverter.toFrontDtos(expenses);
        return ResponseEntity.status(HttpStatus.OK).body(frontDtos);
    }
    @Operation(summary = "delete a meeting using its businee key")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The meeting was deleted successfully",
                    content = @Content)
    })
    @DeleteMapping(value = "/{businessKey}")
    public ResponseEntity<?> delete(@PathVariable String businessKey) {
        expensesService.deleteByBusinessKey(businessKey);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get expenses by reason")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Expense",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExpensesFrontDto.class))}),
            @ApiResponse(responseCode = "400", description = "No expense found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))})
    })
    @GetMapping("/getByReason{reason}")
    public ResponseEntity<List<ExpensesFrontDto>> getByReason(@PathVariable String reason){

        List<Expenses> expenses = expensesService.getExpensesByReason(reason);
        List<ExpensesFrontDto> expensesFrontDto= expensesConverter.toFrontDtos(expenses);
        return ResponseEntity.status(HttpStatus.OK).body(expensesFrontDto);
    }

    @Operation(summary = "Get expenses by date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Expense",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExpensesFrontDto.class))}),
            @ApiResponse(responseCode = "400", description = "No expense found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))})
    })
    @GetMapping("/getByDate{date}")
    public ResponseEntity<List<ExpensesFrontDto>> getByReason(@PathVariable LocalDate date){

        List<Expenses> expenses = expensesService.getExpensesByDate(date);
        List<ExpensesFrontDto> expensesFrontDto= expensesConverter.toFrontDtos(expenses);
        return ResponseEntity.status(HttpStatus.OK).body(expensesFrontDto);
    }

    @Operation(summary = "Get expenses by before a given date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Expense",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExpensesFrontDto.class))}),
            @ApiResponse(responseCode = "400", description = "No expense found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))})
    })
    @GetMapping("/getByDateBefore{date}")
    public ResponseEntity<List<ExpensesFrontDto>> getByDateBefore(@PathVariable LocalDate date){

        List<Expenses> expenses = expensesService.getExpensesByDateBefore(date);
        List<ExpensesFrontDto> expensesFrontDto= expensesConverter.toFrontDtos(expenses);
        return ResponseEntity.status(HttpStatus.OK).body(expensesFrontDto);
    }

    @Operation(summary = "Get expenses by after a given date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Expense",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExpensesFrontDto.class))}),
            @ApiResponse(responseCode = "400", description = "No expense found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))})
    })
    @GetMapping("/getByDateAfter{date}")
    public ResponseEntity<List<ExpensesFrontDto>> getByDateAfter(@PathVariable LocalDate date){

        List<Expenses> expenses = expensesService.getExpensesByDateAfterDesc(date);
        List<ExpensesFrontDto> expensesFrontDto= expensesConverter.toFrontDtos(expenses);
        return ResponseEntity.status(HttpStatus.OK).body(expensesFrontDto);
    }

    @Operation(summary = "Get expenses by beteween two given dates")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Expense",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExpensesFrontDto.class))}),
            @ApiResponse(responseCode = "400", description = "No expense found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))})
    })
    @GetMapping("/getByDateAfter{dateMin},{dateMax}")
    public ResponseEntity<List<ExpensesFrontDto>> getByDate(@PathVariable LocalDate dateMin,@PathVariable LocalDate dateMax){

        List<Expenses> expenses = expensesService.getExpensesByDateBetween(dateMin,dateMax);
        List<ExpensesFrontDto> expensesFrontDto= expensesConverter.toFrontDtos(expenses);
        return ResponseEntity.status(HttpStatus.OK).body(expensesFrontDto);
    }
}
