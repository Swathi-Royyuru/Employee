package com.ctc.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Table(name= "employee_Details")
@Entity

public class Employee {


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", contact=" + contact + ", fullName=" + fullName + ", jobTitle=" + jobTitle
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address + ", city=" + city
				+ ", state=" + state + "]";
	}

	@Id
	private String empId;
	
	

	@OneToMany(cascade = CascadeType.ALL)
@JsonDeserialize
	@JoinColumn(name = "contactId")
	@JsonIgnoreProperties("contact_details")
	private List<Contact> contact = new ArrayList<>();
	
	
	@Column
	@NotNull(message = "Name cannot be empty!")
	@Size(min=4, max=20, message="Name should be 4-20 characters")
	private String fullName;
	
	@NotNull(message = "Title cannot be empty!")
	private String jobTitle;
	
	@NotNull(message = "Phonenumber cannot be empty!")
	@Size(min=10, max=10, message = "Phone number must contain 10 digits!")
	private String phoneNumber;
	
	@Email(message = "Email Validation not followed!")
	private String email;
	
	@NotNull(message = "Address cannot be empty!")
	private String address;
	
	@NotNull(message = "City cannot be empty!")
	private String city;
	
	@NotNull(message = "State cannot be empty!")
	private String state;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	
	public Employee(String empId, List<Contact> contact,
			@NotNull(message = "Name cannot be empty!") @Size(min = 4, max = 20, message = "Name should be 4-20 characters") String fullName,
			@NotNull(message = "Title cannot be empty!") String jobTitle,
			@NotNull(message = "Phonenumber cannot be empty!") @Size(min = 10, max = 10, message = "Phone number must contain 10 digits!") String phoneNumber,
			@Email(message = "Email Validation not followed!") String email,
			@NotNull(message = "Address cannot be empty!") String address,
			@NotNull(message = "City cannot be empty!") String city,
			@NotNull(message = "State cannot be empty!") String state) {
		super();
		this.empId = empId;
		this.contact = contact;
		this.fullName = fullName;
		this.jobTitle = jobTitle;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public List<Contact> getContact() {
		return contact;
	}

	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}

}
