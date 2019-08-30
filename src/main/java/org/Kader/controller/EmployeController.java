package org.Kader.controller;

import java.util.List;

import org.Kader.entities.Employe;
import org.Kader.entities.User;
import org.Kader.service.EmployeService;
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
@RequestMapping("/employe")
@Api(value="EpmloyeController", description="Gestion du Employe")
public class EmployeController {
	
	@Autowired
	private EmployeService employeService;
	
	
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Successfully saved employe"),
			@ApiResponse(code=401,message="You are not authorized to view the resource"),
			@ApiResponse(code=403,message="Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code=404,message="The resource you were trying to reach is not found"),

	})
	@ApiOperation(value = "Add a Employe  ",response = Employe.class)
	@PostMapping(value="/saveEmploye")
	public Employe addEmploye(@RequestBody Employe employe) {
		return employeService.addEmploye(employe);	
	}
	
	
	@ApiOperation(value = "Get All Employes",response = Employe.class)
	@GetMapping(value="/getAllEmployes")
	public List<Employe> getAllEmployes(){
		return employeService.getAllEmployes();
	}
	
	
	@ApiOperation(value = "Search a Employe with an Dept",response = Employe.class)
	@GetMapping(value="/getEmployeByDept/{dept}")
	public List<Employe> getEmployeByDept(@PathVariable String dept) {
		return employeService.findEmployeByDept(dept);
	}
	@ApiOperation(value = "Delete a Employe ",response = Employe.class)
	@DeleteMapping(value="/deleteEmploye/{employe}")
	public void deleteEmploye(@PathVariable Employe employe) {
		employeService.deleteEmploye(employe);
	}
	
	
	@ApiOperation(value = "Delete a Employe with an ID",response = Employe.class)
	@DeleteMapping(value="/deleteEmploye/{id}")
	public void deleteEmployeById(@PathVariable Long id) {
		employeService.deleteEmployeById(id);
	}
	
	
	@ApiOperation(value = "Put a Employe with an ID",response = Employe.class)
	@PutMapping(value="/putEmploye/{id}")
	public Employe putEmploye(@RequestBody Employe employe, @PathVariable Long id) {
		return employeService.putEmploye(employe, id);
	}
	

}
