package com.haveitfast.cafe.bbmenuservice.menuController;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class menuController {
	
	@GetMapping(path="/menu")
	public String menuadd()
	{
		return "Menu";
	}
	
	@GetMapping(path="/menu-bean")
	public menuBean menuaddbean()
	{
		return new menuBean("Menu");
	}
	
	@GetMapping(path ="/menu-bean/{name}")
	public menuBean menuaddPath(@PathVariable String name)
	{
		return new menuBean( String.format("Menu, %s",name));
	}
	

}
