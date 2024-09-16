package com.example.Expense.Control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Expense.Model.Expense;
import com.example.Expense.Repository.ExpenseRepository;

@Controller
public class HomeController {

	@Autowired
	ExpenseRepository expense;

	@GetMapping("/about")
	public String about(Model model) {
		List<Expense> exp = expense.findAll();
		model.addAttribute("elist", exp);
		return "about";
	}

	@GetMapping("/register")
	public String reister() {
		return "register";
	}

	@GetMapping("/login")
	public String expenseLogin() {
		return "login";
	}
	
	@GetMapping("/add")
	public String addExpense() {
		return "add";
	}
	
}