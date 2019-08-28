package org.Kader.controller;

import java.util.List;

import org.Kader.entities.User;
import org.Kader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/saveUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);	
	}
	
	@GetMapping(value="/getAllUsers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping(value="/getUserByAddress/{address}")
	public List<User> getUserByAddress(@PathVariable String address) {
		return userService.findUserByAdress(address);
	}
	
	@DeleteMapping(value="/deleteUser/{user}")
	public void deleteUser(@PathVariable User user) {
		 userService.deleteUser(user);
	}
	@DeleteMapping(value="/deleteUser/{id}")
	public void deleteUser(@PathVariable Long id) {
		 userService.deleteUserById(id);
	}
	
	@PutMapping(value="/putUser/{id}")
	public User putUser(@RequestBody User user, @PathVariable Long id) {
		return userService.putUser(user, id);
	}
	

}
