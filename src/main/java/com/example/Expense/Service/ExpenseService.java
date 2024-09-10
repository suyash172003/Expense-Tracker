package com.example.Expense.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Expense.Model.Expense;
import com.example.Expense.Repository.ExpenseRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "ExpenseService",description = "Api Calling")
@RequestMapping("/expense")
public class ExpenseService {
	
	@Autowired
	ExpenseRepository expense;
	
	@GetMapping
	@Operation(description = "Retrieve all the Expense object")
	public List<Expense> getAllExpense(){
		return expense.findAll();
	}
	
	@GetMapping("/{id}")
	@Operation(description = "Retrieve the expenses by specific id")
	public Expense getExpenseById(@PathVariable long id) {
		Optional<Expense> obj=expense.findById(id);
		return obj.get();
	}
	
	@PostMapping
	@Operation(description = "To store the information database")
	public void postExpenseById(@RequestBody Expense new_expense) {
		expense.save(new_expense);
	}
	
	@PutMapping("/{id}")
	@Operation(description = "TO update the information")
	public void putExpenseAtId(@PathVariable long id,@RequestBody Expense set_expense) {
		Optional<Expense> obj=expense.findById(id);
		Expense temp=obj.get();
		temp.setAmount(set_expense.getAmount());
		temp.setCategory(set_expense.getCategory());
		temp.setDate(set_expense.getDate());
		temp.setDescription(set_expense.getDescription());
		expense.save(temp);
	}
	
	@DeleteMapping("/{id}")
	@Operation(description = "TO delete the information")
	public void deleteById(@PathVariable long id) {
		expense.deleteById(id);
	}
}
