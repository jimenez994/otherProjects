package com.zeus.DevC.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // your format
	
	@RequestMapping("/new/{id}")
	public Map<String, String> newExperience(@RequestBody Map<String, String> exp, @PathVariable long id) throws ParseException{
		User user = _Us.findById(id);
		Date dateFrom = null;
		Date toEnd = null;
		if((String)exp.get("startDate") != null && (String)exp.get("startDate") != "") {
			System.out.println("got here");
			dateFrom = format.parse((String)exp.get("startDate"));
		}
		if((String)exp.get("toEnd") != null && (String)exp.get("toEnd") != "") {
			toEnd = format.parse((String)exp.get("toEnd"));
		}
		Experience newExp= new Experience(exp.get("title"), exp.get("description"), exp.get("company"), exp.get("location"), dateFrom, toEnd, user.getPortfolio());
		return _eS.createExp(newExp);
	}
}
