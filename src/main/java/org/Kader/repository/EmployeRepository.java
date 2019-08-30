package org.Kader.repository;

import java.util.List;

import org.Kader.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe,Long>{

	public List<Employe> findEmployeByDept(String dept);
}
