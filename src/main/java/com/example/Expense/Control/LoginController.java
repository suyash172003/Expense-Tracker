package com.example.Expense.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.Expense.Model.Login;
import com.example.Expense.Model.Register;
import com.example.Expense.Repository.LoginRepository;
import com.example.Expense.Repository.RegisterRepository;

@Controller
public class LoginController {
	
	@Autowired
	private RegisterRepository registering;
	
	@GetMapping("/login")
	public String loginGet(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}
	
	@PostMapping("/login")
	public String loginPut(@ModelAttribute Login login) {
		Register val=registering.findByEmail(login.getEmail());
		if(val!=null&&val.getEmail().compareTo(login.getEmail())==0&&val.getPassword().compareTo(login.getPassword())==0) {
			return "redirect:/expense";
		}
		else {
			return "redirect:/login";
		}
	}
}
