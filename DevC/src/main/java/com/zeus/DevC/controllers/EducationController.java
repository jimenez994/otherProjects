package com.zeus.DevC.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeus.DevC.models.Education;
import com.zeus.DevC.models.User;
import com.zeus.DevC.services.EducationService;
import com.zeus.DevC.services.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/edu")
public class EducationController {
	
	@Autowired
	private EducationService _eduS;
	
	@Autowired
	private UserService _Us;
	
	@RequestMapping("/new/{id}")
	public Map<String, String> newEducation(@RequestBody Education edu, @PathVariable long id){
		User user = _Us.findById(id);
		edu.setPortfolio(user.getPortfolio());
		return _eduS.createEdu(edu);
	}

}
