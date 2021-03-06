/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbmenuservice.api;

import java.net.URI;
import java.util.List;

import com.haveitfast.cafe.bbmenuservice.bean.menu.Menu;
import com.haveitfast.cafe.bbmenuservice.service.impl.MenuServiceImpl;
import com.haveitfast.cafe.bbmenuservice.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@RestController  
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/menu")
public class MenuResources {
	@Autowired
	private  MenuService menuService;
	
	public MenuResources(MenuService menuService) {
		this.menuService = menuService;
	}
	
//	@GetMapping(path="/getIdCounter")
//	public long getIdCounter(){
//		return MenuService.findIdCounter();
//	}
	
	@GetMapping(path="/getEnableStatus/{id}")
	public boolean getEnableStatus(@PathVariable String id){
		return menuService.findMenuStatus(id);
	}
	
	@GetMapping(path="/menus")
	public List<Menu> getAllMenu(){
		return menuService.findAllMenu();
	}
	
	@GetMapping(path="/menuById/{id}")
	public Menu getMenuById(@PathVariable String id){
		return menuService.findMenuById(id);
		
	}
	
	@PutMapping("/updateMenu/{id}")
	public ResponseEntity<Menu> updateMenu(@PathVariable String id,@RequestBody Menu menus ){
		Menu menuUpdate =menuService.updateMenu(id,menus);
		return new ResponseEntity<Menu>(menus, HttpStatus.OK);
	}
	
	

	@PostMapping("/createMenu")
	public ResponseEntity<Void> createMenu(@RequestBody Menu menus1 ){
		Menu menuCreate =menuService.createMenu(menus1);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(menuCreate.getMenuId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

}


