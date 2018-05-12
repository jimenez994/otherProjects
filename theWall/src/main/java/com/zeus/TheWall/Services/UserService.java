package com.zeus.TheWall.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.TheWall.Repositories.UserRepository;
import com.zeus.TheWall.models.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository _userRepo;
	
	public User showByUsername(String username) {
		return _userRepo.findByUsername(username);
	}
	
	public String create(User user) {
		User userCheck = _userRepo.findByUsername(user.getUsername());
		if(userCheck == null) {
			_userRepo.save(user);
			return "success";
		}
		return "user already exists";
	}
	public User showByUserID(long id) {
		return _userRepo.findOne(id);
	}
	
	public void update(User user) {
		_userRepo.save(user);
	}
	
	public ArrayList<User> showAll(){
		return _userRepo.findAll();
	}
	
	public void delete(long id) {
		_userRepo.delete(id);
	}
	
	

}
