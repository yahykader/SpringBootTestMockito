package org.Kader.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employe implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String dept;
	
	public Employe() {
		// TODO Auto-generated constructor stub
	}

	public Employe(String name, String dept) {
		super();
		this.name = name;
		this.dept = dept;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	

}
