package com.haveitfast.cafe.bbuserservice.User;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController 
@CrossOrigin(origins="http://localhost:3000")


public class UserResouses {
	@Autowired	
	private  UserService userData;
	
	@GetMapping(path="/{username}/users/{id}")
	public List<User> getAllUser(@PathVariable String username,@PathVariable long id){
		return UserService.findAllUserExceptThis(id);
	}
	
	@GetMapping(path="/{username}/users")
	public List<User> getAllUser(@PathVariable String username){
		return UserService.findAllUser();
	}
	
	@GetMapping(path="/getUser/{username}/{id}")
	public User getUserById(@PathVariable String username,@PathVariable long id){
		return UserService.findUserById(id);
	}
	
	@GetMapping(path="/getUserByPassword/{username}/{password}")
	public User getUserByPassword(@PathVariable String username,@PathVariable String password){
		return UserService.findUserByPassword(username,password);
	}
	
	@DeleteMapping("/deleteUser/{username}/user/{id}")
	public ResponseEntity<Void> createUser(@PathVariable String username,@PathVariable long id){
		User userDelete =UserService.deleteUser(id);
		if(userDelete!=null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(path="/users/{username}/user/{password}")
	public boolean userAuthentication(@PathVariable String username,@PathVariable String password){
		return UserService.isUserFound(username,password);
	}
	
	@PutMapping("/usersUpdate/{username}/{id}")
	public ResponseEntity<User> updateUser(@PathVariable String username,@PathVariable long id,@RequestBody User user ){
		User userUpdate =UserService.updateUserDetails(id,user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<Void> createUser(@RequestBody User users1 ){
		User userCreate =UserService.createUser(users1);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(userCreate.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
