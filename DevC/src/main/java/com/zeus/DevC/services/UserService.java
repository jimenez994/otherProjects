package com.zeus.DevC.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zeus.DevC.models.User;
import com.zeus.DevC.repositories.UserRepository;

@Service
public class UserService {
	
	String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	Pattern pattern = Pattern.compile(regex);
	
	private BCryptPasswordEncoder bcrypt; 
	private UserRepository userRepo;
	
	public UserService(UserRepository userRepo){
		this.userRepo = userRepo;
		this.bcrypt = new BCryptPasswordEncoder();
	}
	
//	User Crud
	public Map<String, String> create(User user){
//		Dictionary of messages
		Map<String,String> msg = new HashMap<String, String>();
		
		User eUser  = userRepo.findByEmail(user.getEmail());
		if (eUser == null ) {
			Matcher matcher = pattern.matcher(user.getEmail());
//			Checking Email
			if(!matcher.matches()) {
				msg.put("email", "Email is invalid");
			}
//			Checking name
			if(user.getName().length() < 1) {
				msg.put("name", "Name field is required");
			}
//			Checking password
			if(user.getPassword().length() < 5) {
				msg.put("password", "Password must be at least 6 characters");
			}
//			If credentials is valid -> register user
			if(msg.isEmpty()) {
				user.setPassword(bcrypt.encode( user.getPassword()));
				userRepo.save(user);
				msg.put("user_id", user.getId()+"");
				msg.put("success", "You successfully created a User");
			}
			return msg;
		}
		msg.put("message", "email already exists in our database");
		return msg;
	}
	
	
	public Map<String, String> login(String email,String password){
		Map<String,String> msg = new HashMap<String, String>();
		User eUser = userRepo.findByEmail(email);
		Matcher matcher = pattern.matcher(email);
//		Checking Password
		if(password.isEmpty()) {
			msg.put("password", "Password is required");
		}
//		Checking Email
		if(!matcher.matches()) {
			msg.put("email", "Email is invalid");
		}else if(eUser == null ) {
			msg.put("email", "Email is not in database");
		}else {
			if(bcrypt.matches(password, eUser.getPassword())) {
				msg.put("success", "success");
				msg.put("user_id", eUser.getId()+"");
				return msg;
			}else {
				msg.put("password", "Invalid password");
				return msg;
			}
		}
		return msg;
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
		User user = userRepo.findOne(id);
		user.setPortfolio(null);
		return user;
	}
	
	public Map<String, String>  delete(long id) {
		userRepo.delete(id);
		Map<String, String> msg = new HashMap<String, String>();
		msg.put("message", "You successfully delete a user");
		return msg;
	}

}
