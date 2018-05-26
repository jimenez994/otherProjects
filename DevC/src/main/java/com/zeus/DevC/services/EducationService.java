package com.zeus.DevC.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.DevC.models.Education;
import com.zeus.DevC.repositories.EducationRepository;

@Service
public class EducationService {
	
	@Autowired
	private EducationRepository _eduR;
	
	public Map<String, String> createEdu(Education edu){
		Map<String, String> msg = new HashMap<String, String>();
		if(edu.getSchool() == "" || edu.getSchool() == null) {
			msg.put("school", "School cannot be empty");
		}
		if(edu.getDegree() == "" || edu.getDegree() == null) {
			msg.put("degree", "Degree cannot be empty");
		}
		if(msg.isEmpty()) {
			_eduR.save(edu);
			msg.put("success", "You successfully created an education");
			return msg;
		}
		return msg;
	}
	public Map<String, String> deleteEdu(long id){
		Map<String, String> msg = new HashMap<String, String>();
		msg.put("success", "You successfully deleted an Education");
		_eduR.delete(id);
		return msg;
	}

}
