package com.example.Expense.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.Expense.Model.Register;
import com.example.Expense.Repository.RegisterRepository;

@Controller
public class RegisterController {
	
	@Autowired
	private RegisterRepository registering;
	
	@GetMapping("/register")
	public String getRegister(Model model) {
		model.addAttribute("register", new Register());
		return "register";
	}
	@PostMapping("/register")
	public String postRegister(@ModelAttribute Register register) {
		registering.save(register);
		return "redirect:/login";
	}
	
}
