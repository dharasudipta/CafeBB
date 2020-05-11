package com.haveitfast.cafe.bbfrontendservice.controllers.testing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class HelloWorldController {
    @RequestMapping("/testing")
    public String home() {
        return "Hello, SpringBootApplication is working ";
    }
    
    @GetMapping(path="/testing-bean")
	public TestingBean testingBean()
	{
		return new TestingBean ("Spring Testing");
	}
    
	@GetMapping(path="/testing/path-var/{name}")
	public TestingBean testingPathVar(@PathVariable String name)
	{
		return new TestingBean(String.format ("Spring Testing,%s",name));
	}

}

