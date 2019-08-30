package org.Kader.controller;

import java.util.List;

import org.Kader.entities.Employe;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
@Api(value="UserController",description="Gestion du User")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@ApiOperation(value = "Add a User  ",response = User.class)
	@ApiResponses(value= {
							@ApiResponse(code=200,message="Successfully saved user"),
							@ApiResponse(code=401,message="You are not authorized to view the resource"),
							@ApiResponse(code=403,message="Accessing the resource you were trying to reach is forbidden"),
							@ApiResponse(code=404,message="The resource you were trying to reach is not found"),
			
	})
	@PostMapping(value="/saveUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);	
	}
	
	
	@ApiOperation(value = "Get All Users",response = User.class)
	@GetMapping(value="/getAllUsers")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	
	@ApiOperation(value = "Search a User with an Address",response = User.class)
	@GetMapping(value="/getUserByAddress/{address}")
	public List<User> getUserByAddress(@PathVariable String address) {
		return userService.findUserByAdress(address);
	}
	
	
	@ApiOperation(value = "Delete a User ",response = User.class)
	@DeleteMapping(value="/deleteUser/{user}")
	public void deleteUser(@PathVariable User user) {
		 userService.deleteUser(user);
	}
	
	
	@ApiOperation(value = "Delete a User with an ID",response = User.class)
	@DeleteMapping(value="/deleteUser/{id}")
	public void deleteUserById(@PathVariable Long id) {
		 userService.deleteUserById(id);
	}
	
	
	@ApiOperation(value = "Put a User with an ID",response = User.class)
	@PutMapping(value="/putUser/{id}")
	public User putUser(@RequestBody User user, @PathVariable Long id) {
		return userService.putUser(user, id);
	}
	

}
