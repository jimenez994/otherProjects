package com.zeus.DevC.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.zeus.DevC.models.Portfolio;
import com.zeus.DevC.models.User;
import com.zeus.DevC.repositories.PortfolioRepository;

@Service
public class PortfolioService {
	@Autowired 
	private PortfolioRepository _pR;
	
	@Autowired
	private UserService _uS;
	
	ObjectMapper oMapper = new ObjectMapper();
	
	Gson gson = new Gson();

//	Portfolio CRUD
	public Map<String, String> create(Portfolio portfolio, User user){
		Map<String,String> msg = new HashMap<String, String>();
		Portfolio checkP = _pR.findByUserId(user.getId());
		if(checkP == null) {
			if(portfolio.getHandle().isEmpty()) {
				msg.put("handle", "Handle is required");
			}else if(_pR.findByHandle(portfolio.getHandle()) != null) {
				msg.put("handle", "Handle is already taken");
			}
			if(portfolio.getStatus().isEmpty()) {
				msg.put("status", "Status is required");
			}
			if(portfolio.getSkills().isEmpty()) {
				msg.put("skills", "Skills is required");
			}
			if(msg.isEmpty()) {
				portfolio.setUser(user);
//				_pR.save(portfolio);
				user.setPortfolio(portfolio);
				_uS.update(user);
				System.out.println("hey i got here");
				msg.put("success", "Created a porfolio");
			}
			return msg;
		}
		msg.put("fail", "You already have a portfolio");
		return msg;
	}
	public Map<String,String> userPorfolio(long id) {
		System.out.println("*******2");
		Map<String,String> portfolio = new HashMap<String, String>();
			Portfolio port =  _pR.findByUserId(id);
			System.out.println(port);
//			Portfolio portfolio = user.getPortfolio();
		if(port != null) {
//			portfolio.setEducations(null);
			port.setUser(null);
//			portfolio.setExperiences(null);
			System.out.println("*******3");
			Map<String, String> map = oMapper.convertValue(port, Map.class);
			map.put("success", "you have your portfolio");
			System.out.println(map);
			return map;
		}else {
			System.out.println("*******");

			portfolio.put("noProfile","Sorry you dont hava a profolio");
		}
		
		return portfolio;
	}
	public Portfolio findByHandle(String handle) {
		Portfolio portfolio = _pR.findByHandle(handle);
//		portfolio.setEducations(null);
		portfolio.setUser(null);
//		portfolio.setExperiences(null);
		return portfolio;
	}
	public Portfolio findById(long id) {
		Portfolio portfolio = _pR.findOne(id);;
//		portfolio.setEducations(null);
		portfolio.setUser(null);
//		portfolio.setExperiences(null);
		return portfolio;
	}
	public Map<String,String> update(Portfolio portfolio) {
		Map<String,String> msg = new HashMap<String, String>();
		
		Portfolio checkPorfolio = _pR.findByHandle(portfolio.getHandle());
		
		if(portfolio.getHandle().isEmpty()) {
			msg.put("handle", "Handle is required");
		}else if(checkPorfolio != null) {
			if(checkPorfolio.getHandle() != portfolio.getUser().getPortfolio().getHandle()) {
				msg.put("handle", "Handle is already taken");
			}
		}else {
			_pR.save(portfolio);
			msg.put("success", "You have update your portfolio");
			return msg;
		}
		return msg;
	}
	
	public ArrayList<Portfolio> all(){
		ArrayList<Portfolio> ports = _pR.findAll();;
		ArrayList<Portfolio> uPorts = new ArrayList<Portfolio>();
		for (Portfolio port : ports) {
			port.setUser(null);
			uPorts.add(port);
		}
		return uPorts;
	}
}
