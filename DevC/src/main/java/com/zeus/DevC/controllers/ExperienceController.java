package com.zeus.DevC.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeus.DevC.models.Experience;
import com.zeus.DevC.models.User;
import com.zeus.DevC.services.ExperienceService;
import com.zeus.DevC.services.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/exp")
public class ExperienceController {
	
	@Autowired 
	private ExperienceService _eS;
	
	@Autowired
	private UserService _Us;
	
	@RequestMapping("/new/{id}")
	public Map<String, String> newExperience(@RequestBody Experience exp, @PathVariable long id){
		User user = _Us.findById(id);
		exp.setPortfolio(user.getPortfolio());
		return _eS.createExp(exp);
	}
}
