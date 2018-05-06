package com.zeus.DevC.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.zeus.DevC.models.Portfolio;
import com.zeus.DevC.models.User;
import com.zeus.DevC.services.PortfolioService;
import com.zeus.DevC.services.UserService;

@RestController
@RequestMapping("/p")
public class PortfolioController {
	
	@Autowired
	private PortfolioService _pS;
	
	@Autowired UserService _Us;
	Gson gson = new Gson();
	
	@PostMapping("/new")
	public Map<String, String> create(@RequestBody Portfolio portfolio, HttpSession session){
		Map<String, String> msg = new HashMap<String, String>();
		if(session.getAttribute("user_id") != null) {
			User user = _Us.findById((long)session.getAttribute("user_id"));
			return _pS.create(portfolio, user);
		}
		msg.put("fail", 	"Must be login first");
		return msg;
	}
	
	@GetMapping("/portfolio")
	public Portfolio userPortfolio(HttpSession session) {
		User user = _Us.findById((long)session.getAttribute("user_id"));
		System.out.println(user.getPortfolio());
		return _pS.userPorfolio(user);

	}
	
	@GetMapping("/by/Handle/{handle}")
	public Portfolio findbyHandle(@PathVariable("handle") String handle) {
		return _pS.findByHandle(handle);
	}
	@GetMapping("/byId/{id}")
	public Portfolio findById(@PathVariable("id") long id) {
		System.out.println(gson.toJson(_pS.findById(id)));
		return null;
	}
	@PutMapping("/update/{id}")
	public Map<String, String> update(@RequestBody Portfolio portfolio){
		return _pS.update(portfolio);
	}
	@GetMapping("/all")
	public ArrayList<Portfolio> all(){
		return _pS.all();
	}
	

}
