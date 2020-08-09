package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ecommerce.util.Constants;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(columnDefinition =  Constants.VARCHAR_32)
	private String id;
	
	@Column(name = "firstname", columnDefinition =  Constants.VARCHAR_64)
	private String firstName;

	@Column(name = "lastname", columnDefinition =  Constants.VARCHAR_64)
	private String lastName;

	@Column(name = "contactno", columnDefinition = "LONG")
	private long contactNo;
	

	@Column(name = "mail", columnDefinition =  Constants.VARCHAR_64)
	private String mail;

	@Column(name = "password", columnDefinition =  Constants.VARCHAR_64)
	private String password;

	@Column(name = "username", columnDefinition =  Constants.VARCHAR_64)
	private String username;
	
	@Column(name = "isdeleted")
	private Integer isDeleted;
	
	@Column(name = "firstname", insertable = false, updatable = false)
	private String name;

	@Column(name = "contactno", insertable = false, updatable = false)
	private String phoneNumber;
	
	@Column(name = "id", insertable = false, updatable = false)
	private String boyId;
	
	@Column(name = "role")
	private int role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer isDeleted() {
		return isDeleted;
	}

	public void setDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBoyId() {
		return boyId;
	}

	public void setBoyId(String boyId) {
		this.boyId = boyId;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNo=" + contactNo
				+ ", mail=" + mail + ", password=" + password + ", username=" + username + ", isDeleted=" + isDeleted
				+ ", name=" + name + ", phoneNumber=" + phoneNumber + ", boyId=" + boyId + ", role=" + role + "]";
	}
	
}
