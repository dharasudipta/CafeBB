package com.haveitfast.cafe.bbmenuservice.menu;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@RestController  
@CrossOrigin(origins="http://localhost:3000")
public class MenuResources {
	@Autowired
	private  MenuService menuData;
	
	@GetMapping(path="/getIdCounter")
	public long getIdCounter(){
		return MenuService.findIdCounter();
	}
	
	@GetMapping(path="users/{username}/menus/{id}/getEnableStatus")
	public boolean getEnableStatus(@PathVariable String username,@PathVariable long id){
		return MenuService.findEnableStatus(id);
	}
	
	@GetMapping(path="users/{username}/menus")
	public List<Menu> getAllMenu(@PathVariable String username){
		return MenuService.findAllMenu();
	}
	
	@GetMapping(path="users/{username}/menus/{id}")
	public Menu getMenuById(@PathVariable String username,@PathVariable long id){
		return MenuService.findMenuById(id);
		
	}
	
	@PutMapping("users/{username}/menus/{id}")
	public ResponseEntity<Menu> updateMenu(@PathVariable String username,@PathVariable long id,@RequestBody Menu menus ){
		Menu menuUpdate =MenuService.updateMenu(id,menus);
		return new ResponseEntity<Menu>(menus, HttpStatus.OK);
	}
	
	@PostMapping("/users/{username}/menus")
	public ResponseEntity<Void> createMenu(@PathVariable String username,@RequestBody Menu menus1 ){
		Menu menuCreate =MenuService.createMenu(menus1);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(menuCreate.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

}
