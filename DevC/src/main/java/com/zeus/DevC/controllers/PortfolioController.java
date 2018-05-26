package com.zeus.DevC.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.zeus.DevC.models.Portfolio;
import com.zeus.DevC.models.User;
import com.zeus.DevC.services.PortfolioService;
import com.zeus.DevC.services.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/p")
public class PortfolioController {
	
	@Autowired
	private PortfolioService _pS;
	
	@Autowired UserService _Us;
	Gson gson = new Gson();
	
	@PostMapping("/new/{id}")
	public Map<String, String> createOrUpdate(@RequestBody Portfolio portfolio, @PathVariable("id") long id){
		Map<String, String> msg = new HashMap<String, String>();
		User user = _Us.findById(id);
			if(user != null) {
//				System.out.println("this is to update   0"+ portfolio.getHandle());
				if(user.getPortfolio() != null) {
//					this is to update the profolio
					portfolio.setUser(user);
					portfolio.setEducations(user.getPortfolio().getEducations());
					portfolio.setExperiences(user.getPortfolio().getExperiences());
					return _pS.update(portfolio);			
				}else{
//					this is to create a new profolio
					return _pS.create(portfolio, user);	
				}
			}
		msg.put("fail", 	"Must be login first");
		return msg;
	}
	
	@GetMapping("/portfolio/{id}")
	public Map<String, Object> userPortfolio(HttpSession session, @PathVariable("id") long id) {
		System.out.println(new Date());
		return _pS.userPorfolio(id);
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
	@GetMapping("/all")
	public ArrayList<Portfolio> all(){
		return _pS.all();
	}
	@DeleteMapping("/delete/{id}")
	public Map<String, String> deleteProfile(@PathVariable("id") long id){
		return _Us.delete(id);
	}
	

}
