package org.Kader.service;

import java.util.List;

import org.Kader.entities.User;
import org.Kader.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		List<User>users= userRepository.findAll();
		System.out.println("User From DB"+ users);
		return users;
	}
	
	public List<User> findUserByAdress(String address ){
		List<User> users=userRepository.findByAddress(address);
		return users;
	}
	
	public void deleteUser(User user) {
		 userRepository.delete(user);	
	}
	public void deleteUserById(Long id) {
		 userRepository.deleteById(id);	
	}
	
	public User putUser(User user,Long id) {
		user.setId(id);
		return userRepository.save(user);
	}

}
