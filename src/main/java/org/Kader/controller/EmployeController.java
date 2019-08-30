package org.Kader.controller;

import java.util.List;

import org.Kader.entities.Employe;
import org.Kader.entities.User;
import org.Kader.repository.EmployeRepository;
import org.Kader.service.EmployeService;
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
@RequestMapping("/employe")
public class EmployeController {
	
	@Autowired
	private EmployeService employeService;
	
	@PostMapping(value="/saveEmploye")
	public Employe addEmploye(@RequestBody Employe employe) {
		return employeService.addEmploye(employe);	
	}
	
	@GetMapping(value="/getAllEmployes")
	public List<Employe> getAllEmployes(){
		return employeService.getAllEmployes();
	}
	
	@GetMapping(value="/getEmployeByDept/{dept}")
	public List<Employe> getUserByDept(@PathVariable String dept) {
		return employeService.findEmployeByDept(dept);
	}
	
	@DeleteMapping(value="/deleteEmploye/{employe}")
	public void deleteEmploye(@PathVariable Employe employe) {
		employeService.deleteEmploye(employe);
	}
	@DeleteMapping(value="/deleteEmploye/{id}")
	public void deleteEmploye(@PathVariable Long id) {
		employeService.deleteEmployeById(id);
	}
	
	@PutMapping(value="/putEmploye/{id}")
	public Employe putEmploye(@RequestBody Employe employe, @PathVariable Long id) {
		return employeService.putEmploye(employe, id);
	}
	

}
