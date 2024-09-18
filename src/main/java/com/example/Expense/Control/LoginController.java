package com.example.Expense.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.Expense.Model.Login;
import com.example.Expense.Repository.LoginRepository;

@Controller
public class LoginController {
	
	@Autowired
	LoginRepository loginRepo;
	
	@GetMapping("/login")
	public String loginGet(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}
	
	@PostMapping("/login")
	public String loginPut(@ModelAttribute Login login) {
		loginRepo.save(login);
		return "redirect:/about";
	}
}
