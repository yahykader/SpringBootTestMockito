package org.Kader.service;

import java.util.List;

import org.Kader.entities.Employe;
import org.Kader.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeService {
	
	
	@Autowired
	private EmployeRepository employeRepository;
	
	
	public Employe addEmploye(Employe employe) {
		return employeRepository.save(employe);
	}
	
	public List<Employe> getAllEmployes(){
		List<Employe> employes= employeRepository.findAll();
		System.out.println("User From DB"+ employes);
		return employes;
	}
	
	public List<Employe> findEmployeByDept(String dept ){
		List<Employe> employes=employeRepository.findEmployeByDept(dept);
		return employes;
	}
	
	public void deleteEmploye(Employe user) {
		employeRepository.delete(user);	
	}
	public void deleteEmployeById(Long id) {
		employeRepository.deleteById(id);	
	}
	
	public Employe putEmploye(Employe employe,Long id) {
		employe.setId(id);
		return employeRepository.save(employe);
	}

}
