package org.Kader.repository;

import java.util.List;

import org.Kader.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
	
	public List<User> findByAddress(String address);

}
