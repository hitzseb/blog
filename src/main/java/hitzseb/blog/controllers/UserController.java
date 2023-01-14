package hitzseb.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hitzseb.blog.models.User;
import hitzseb.blog.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String showRegisterPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}
	
	@PostMapping("/register")
	public String signUp(@ModelAttribute User user) {
		userService.signUpuser(user);
		return "redirect:/";
	}

	@GetMapping("/login")
	public String showLoginPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}

}
