package com.zeus.Fifa.Controllers;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		Map<String,Object> map = mapper.readValue(mydata, Map.class);
		System.out.println(map.get("id"));
		return "redirect:/";
	}

}
