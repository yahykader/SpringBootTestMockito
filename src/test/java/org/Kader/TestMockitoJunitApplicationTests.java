package org.Kader;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.Kader.entities.User;
import org.Kader.repository.UserRepository;
import org.Kader.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMockitoJunitApplicationTests {
    
	@Autowired
	private UserService service;
	
	@MockBean
	private UserRepository userRepository;
	
	
	@Test
	public void findAllUsersTest() {
		when(userRepository.findAll()).thenReturn(Stream.of(new User("YAHYAOUI","KADER","PARIS18"),
														    new User("YAHYAOUI","NESRINE","PARIS18")).collect(Collectors.toList()));
		assertEquals(2, service.getAllUsers().size());	
	}
	
	@Test
	public void addUserTest() {
		User user=new User("YAHYAOUI","KADER","PARIS18");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, service.addUser(user));
	}
	
	@Test
	public void findUserByAddressTest() {
		String address="PARIS18";
		when(userRepository.findByAddress(address)).thenReturn(Stream.of(new User("YAHYAOUI","NESRINE","PARIS18")).collect(Collectors.toList()));
		assertEquals(1, service.findUserByAdress(address).size());
	}

	@Test
	public void deleteUserTest() {
		User user=new User("YAHYAOUI","KADER","PARIS 18");
		service.deleteUser(user);
		verify(userRepository,times(1)).delete(user);
	}
	
	@Test
	public void deleteUserByIdTest() {
		Long id=1L;
		service.deleteUserById(id);
		verify(userRepository,times(1)).deleteById(id);
	}
	
	/*@Test 
	public void putUserTest() {
		User user=new User("YAHYAOUI","KADER","PARIS 18");
		Long id=1L;
		when(userRepository.findById(id)).thenReturn(user);
		assertEquals(1, service.putUser(user, id));	
	}
	*/

}
