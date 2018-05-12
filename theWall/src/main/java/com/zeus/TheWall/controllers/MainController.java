package com.zeus.TheWall.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zeus.TheWall.Services.UserService;
import com.zeus.TheWall.models.User;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private UserService _userS;
	
	@RequestMapping("")
	public String createForm(@ModelAttribute("user") User user) {
		return "register";
	}
	@PostMapping("login")
	public String login(@RequestParam("username") String username,HttpSession session) {
		User user = _userS.showByUsername(username);
		if(user!=null) {
			session.setAttribute("user_id", user.getId());
			return "redirect:/wall";
		}
		return "redirect:/";
	}
	
	@PostMapping("register")
	public String createUser(@Valid @ModelAttribute("user") User newUser, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "register";
		}
		else if(_userS.create(newUser).equals("success")){
			session.setAttribute("user_id", newUser.getId());
			return "redirect:/wall";
		}else {
			return "register";
		}
	}
	
	@RequestMapping("wall")
	public String wall(HttpSession session, Model model) {
		model.addAttribute("user", _userS.showByUserID((long)session.getAttribute("user_id")));
		return "wall";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.setAttribute("user_id", null);
		return "redirect:/";
	}
	
	
	
	
	
	
}

