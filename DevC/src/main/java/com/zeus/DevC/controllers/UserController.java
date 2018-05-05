package com.zeus.DevC.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeus.DevC.models.User;
import com.zeus.DevC.services.UserService;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService _userS;

	@GetMapping("/users")
	public ArrayList<User> all(){
		return _userS.all();
	}
}
