package com.haveitfast.cafe.bbfrontendservice.Test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:3000")

@RestController
public class TestResources{
	
	@Autowired
	private TestService testService;
	
	@GetMapping("/users/{username}/Test")
	public List<Test> getAll (@PathVariable String username){
		return testService.findAll();
	}
	

}