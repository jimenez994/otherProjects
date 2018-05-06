package com.zeus.DevC.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.DevC.models.Portfolio;
import com.zeus.DevC.models.User;
import com.zeus.DevC.repositories.PortfolioRepository;

@Service
public class PortfolioService {
	@Autowired 
	private PortfolioRepository _pR;
	
	@Autowired
	private UserService _uS;
	
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
				msg.put("status", "Skills is required");
			}
			if(msg.isEmpty()) {
				portfolio.setUser(user);
				_pR.save(portfolio);
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
	public Portfolio userPorfolio(User user) {
			Portfolio portfolio = _pR.findByUserId(user.getId());
//			Portfolio portfolio = user.getPortfolio();
			if(portfolio != null) {
//			portfolio.setEducations(null);
			portfolio.setUser(null);
//			portfolio.setExperiences(null);
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
		if(portfolio.getHandle().isEmpty()) {
			msg.put("handle", "Handle is required");
		}else if(_pR.findByHandle(portfolio.getHandle()) != null) {
			msg.put("handle", "Handle is already taken");
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
