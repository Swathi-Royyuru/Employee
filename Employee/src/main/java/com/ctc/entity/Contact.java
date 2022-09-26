package com.ctc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "contact_details")
public class Contact {
	
	@Id
	private String contactId;
	
	@NotNull(message = "Name cannot be empty!")
	@Size(min=4, max=20, message="Name should be 4-20 characters!")
	private String contactName;
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

		

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactNumber=" + contactNumber
				+ ", contactRelationship=" + contactRelationship + "]";
	}



	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(@NotNull(message = "Phone number cannot be empty!") @Size(min = 10, max = 10, message = "Phone number must contain 10 digits!") String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@JsonCreator
	public Contact(String contactId,
			@NotNull(message = "Name cannot be empty!") @Size(min = 4, max = 20, message = "Name should be 4-20 characters!") @JsonProperty("contactName") String contactName,
			@NotNull(message = "Phone number cannot be empty!") @Size(min = 10, max = 10, message = "Phone number must contain 10 digits!") @NotNull(message = "Phone number cannot be empty!") @Size(min = 10, max = 10, message = "Phone number must contain 10 digits!") String contactNumber,
			@NotNull(message = "Relationship detail cannot be empty!") @Size(min = 3, max = 20, message = "Must be between 3-20 characters!") String contactRelationship) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactNumber = contactNumber;
		this.contactRelationship = contactRelationship;
	}



	public String getContactRelationship() {
		return contactRelationship;
	}

	public void setContactRelationship(String contactRelationship) {
		this.contactRelationship = contactRelationship;
	}

	@NotNull(message = "Phone number cannot be empty!")
	@Size(min=10, max=10, message = "Phone number must contain 10 digits!")
	private String contactNumber;
	
	@NotNull(message = "Relationship detail cannot be empty!")
	@Size(min=3, max = 20, message = "Must be between 3-20 characters!")
	private String contactRelationship;
	
	


}
