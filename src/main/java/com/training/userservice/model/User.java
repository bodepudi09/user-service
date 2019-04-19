package com.training.userservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery(name = "User.findByLowerName", query = "SELECT u FROM User u WHERE u.name = LOWER(?1)")

@Entity
public class User {
@Id
@GeneratedValue
private Long id;
private String name;
private String address;



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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
}

