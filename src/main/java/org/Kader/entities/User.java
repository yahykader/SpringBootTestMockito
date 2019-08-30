package org.Kader.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="ID of the User")
	private Long id;
    @ApiModelProperty(notes="FirstName of the User")
	private String firstName;
    @ApiModelProperty(notes="LastName of the User")
	private String lastName;
    @ApiModelProperty(notes="Address of the User")
	private String address;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String firstName, String lastName, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdress() {
		return address;
	}

	public void setAdress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		   return "[ Id User " + this.id +
			  " : firstName " + this.firstName +
			  ", lastName " + this.lastName +
		   ", adress " + this.address+
		   "]";
		}
	
	
}
