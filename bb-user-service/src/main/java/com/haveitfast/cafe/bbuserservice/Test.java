package com.haveitfast.cafe.bbuserservice;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:3000")

public class Test {
	

	@GetMapping(path="/testing")
	public String testing()
	{
		return "Spring Testing";
	}
	
//	@GetMapping(path="/testing-bean")
//	public TestingBean testingBean()
//	{
//		return new TestingBean ("Spring Testing");
//	}
	
//	@GetMapping(path="/testing/path-var/{name}")
//	public TestingBean testingPathVar(@PathVariable String name)
//	{
//		return new TestingBean(String.format ("Spring Testing,%s",name));
//	}

}
