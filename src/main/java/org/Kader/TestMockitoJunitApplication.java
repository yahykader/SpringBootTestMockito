package org.Kader;

import java.util.stream.Stream;

import org.Kader.entities.User;
import org.Kader.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestMockitoJunitApplication implements CommandLineRunner {

	@Autowired
	private UserRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(TestMockitoJunitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User u1=repository.save(new User("YAHYAOUI","KADER","PARIS18"));
		User u2=repository.save(new User("YAHYAOUI","NESRINE","PARIS8"));
	}

}
