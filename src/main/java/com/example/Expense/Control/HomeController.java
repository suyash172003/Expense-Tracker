package com.example.Expense.Control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.Expense.Model.Expense;
import com.example.Expense.Repository.ExpenseRepository;
import com.example.Expense.Repository.RegisterRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	
	@Autowired
	ExpenseRepository expenseRepo;
	RegisterRepository registering;

	@GetMapping("/expense")
	public String expense() {
		return "expense";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/expense";
	}
	
	
	
	@GetMapping("/dashboard")
	public String about(Model model,HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId != null) {
			List<Expense> expenses = expenseRepo.findAllByUserId(userId);
	        System.out.print(expenses);
	        model.addAttribute("elist", expenses);
	        return "dashboard";
	    }
		return "add";
	}
	
	@GetMapping("/add")
	public String getExpense(Model model) {
		model.addAttribute("expense", new Expense());
		return "add";
	}
	
	@PostMapping("/add")
	public String addExpense(@ModelAttribute Expense expense,HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId != null) {
	        expense.setUserId(userId); 
	        System.out.println(expense);
	        expenseRepo.save(expense); 
	    }
		return "redirect:/dashboard";
	}
	

	@PostMapping("/delete/{id}")
	public String deleteExpense(@PathVariable Long id) {
		expenseRepo.deleteById(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/update/{id}")
	public String updateGetExpense(@PathVariable long id,Model model) {
		Optional<Expense> obj=expenseRepo.findById(id);
		Expense temp=obj.get();
		model.addAttribute("expense", temp);
		return "update";
	}
	
	@PostMapping("/update/{id}")
	public String updatePostExpense(@PathVariable long id,@ModelAttribute Expense expense) {
		Optional<Expense> obj=expenseRepo.findById(id);
		Expense temp=obj.get();
		temp.setAmount(expense.getAmount());
		temp.setCategory(expense.getCategory());
		temp.setDate(expense.getDate());
		temp.setDescription(expense.getDescription()); 
	    expenseRepo.save(temp);
	    return "redirect:/dashboard";
	}
}