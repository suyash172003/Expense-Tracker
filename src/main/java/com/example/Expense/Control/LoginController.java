package com.example.Expense.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.Expense.Model.Login;
import com.example.Expense.Model.Register;
import com.example.Expense.Repository.RegisterRepository;

import jakarta.servlet.http.HttpSession;

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
	public String loginPut(@ModelAttribute Login login, HttpSession session, Model model) {
		Register val = registering.findByEmail(login.getEmail());
		if (val != null && val.getEmail().equals(login.getEmail()) && val.getPassword().equals(login.getPassword())) {
			session.setAttribute("profile", val);
			session.setAttribute("userId", val.getId());
			model.addAttribute("profileName", "Hii!" + " " + val.getFirstName());
			model.addAttribute("profileEmail", val.getEmail());
			return "expense";
		}
		model.addAttribute("errorMessage", "Invalid credentials. Please try again.");
		return "login";
	}

	@GetMapping("/profile")
	public String profile(@ModelAttribute Login login, Model model, HttpSession session) {
		Register profile = (Register) session.getAttribute("profile");
		model.addAttribute("profileName", profile.getFirstName() + " " + profile.getLastName());
		model.addAttribute("profileEmail", profile.getEmail());
		return "profile";
	}
}
