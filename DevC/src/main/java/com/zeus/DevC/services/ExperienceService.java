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
		if(msg.isEmpty()) {
			_Er.save(exp);
			msg.put("success", "You successfully created an experience");
			return msg;
		}
		return msg;
	}
	public Map<String, String> deleteExp(long id){
		Map<String, String> msg = new HashMap<String, String>();
		msg.put("success", "You successfully deleted an experience");
		_Er.delete(id);
		return msg;
	}

}
