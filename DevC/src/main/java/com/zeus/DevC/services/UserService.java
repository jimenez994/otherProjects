package com.zeus.DevC.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.DevC.models.User;
import com.zeus.DevC.repositories.UserRepository;

@Service
public class UserService {
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired 
	private UserRepository userRepo;
	
	public Map<String, String> create(User user) {
		System.out.println(bcrypt);
		User eUser  = userRepo.findByEmail(user.getEmail());
		Map<String,String> msg = new HashMap<String, String>();
		if (eUser == null ) {
			System.out.println("***********2");
//			user.setPassword(bcrypt.encode( user.getPassword()));
			userRepo.save(user);
			msg.put("message", "You successfully created a User");
			return msg;
		}
		System.out.println("***********3");
		msg.put("message", "email already exists in out database");
		return msg;
	}
	public Map<String, String> isMatch(String email,String password){
		User eUser = userRepo.findByEmail(email);
		Map<String,String> msg = new HashMap<String, String>();
		if(eUser != null) {
			if(bcrypt.matches(password, eUser.getPassword())) {
				msg.put("message", "success");
				return msg;
			}else {
				msg.put("message", "password does not match");
				return msg;
			}
		}else {
			msg.put("message", "email does not exist in our database");
			return msg;
		}
	}
	
	public Map<String, String> update(User user){
		userRepo.save(user);
		Map<String,String> msg = new HashMap<String, String>();
		msg.put("message", "You successfully updated");
		return msg;
	}
	
	public ArrayList<User> all(){
		return userRepo.findAll();
	}
	
	public User findById(long id) {
		return userRepo.findOne(id);
	}
	
	public Map<String, String>  delete(long id) {
		userRepo.delete(id);
		Map<String, String> msg = new HashMap<String, String>();
		msg.put("message", "You successfully delete a user");
		return msg;
	}

}
