package com.zeus.Fifa.Controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zeus.Fifa.models.Team;

@Controller
@RequestMapping("/")
public class MainController {
//	more magic on this page
	
	ObjectMapper mapper = new ObjectMapper();
	
	
	@RequestMapping("")
	public String main() {
		System.out.println("i got here");
		return "main";
	}
	
	@PostMapping("/fifaData")
	public String getData(@RequestParam("myData") String mydata) throws JsonParseException, JsonMappingException, IOException {
//		Map<String, String> team = mydata;
		System.out.println(mydata);
		List<Team> participantJsonList = mapper.readValue(mydata, new TypeReference<List<Team>>(){});

//		Map<String,Object> map = mapper.readValue(mydata, Map.class);
		System.out.println(participantJsonList);
		return "redirect:/";
	}
}
