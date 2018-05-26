package com.zeus.DevC.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.DevC.models.Experience;
import com.zeus.DevC.repositories.ExperienceRepository;

@Service
public class ExperienceService {
	
	@Autowired
	private ExperienceRepository _Er;
	
	public Map<String, String> createExp(Experience exp){
		Map<String, String> msg = new HashMap<String, String>();
		if(exp.getTitle() == "" || exp.getTitle() == null) {
			msg.put("title", "Title cannot be empty");
		}
		if(exp.getCompany() == "" || exp.getCompany() == null) {
			msg.put("company", "Company cannot be empty");
		}
		if(exp.getStartFrom() == null) {
			msg.put("startFrom", "Start from cannot be empty");
		}
		if(msg.isEmpty()) {
			_Er.save(exp);
			msg.put("success", "You successfully created an experience");
			return msg;
		}
		return msg;
	}
	public void deleteExp(long id){
		System.out.println("deleteing " + id);
		_Er.delete(id);
		System.out.println("complete" + id);
	}
	
	public Experience findOne(long id) {
		return _Er.findOne(id);
	}

}
