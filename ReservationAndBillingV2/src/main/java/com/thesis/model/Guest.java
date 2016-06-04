package com.thesis.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true,
selectBeforeUpdate = true)
public class Guest {
	@Id
	@Column(name="guest_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Size(min = 4, max = 10,message="Too Short")
	@NotEmpty
	private String firstname;
	@Size(min = 4, max = 10)
	@NotEmpty
	private String lastname;
	@Email
	@Size(min = 4, max = 10)
	@NotEmpty
	private String email;
	private String contactNumber;
	@NotEmpty
	@Min(value=2)
	@Max(value=30)
	private String address;
	@NotEmpty
	@Enumerated(value=EnumType.STRING)
	@Column(name="gender")
	private GuestGender gender;
	private String nationality="PH";
	
	public Guest(){}

	public Guest(long id, String firstname, String lastname, String email, String contactNumber, String address,
			GuestGender gender,String nationality) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.contactNumber = contactNumber;
		this.address = address;
		this.gender = gender;
		this.nationality = nationality;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public GuestGender getGender() {
		return gender;
	}

	public void setGender(GuestGender gender) {
		this.gender = gender;
	}
	
	public String getFullname()
	{
		return this.getFirstname() +" "+ this.getLastname();
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	
}