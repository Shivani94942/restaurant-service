package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;


@Entity
@ApiModel(description = "details about the restaurant")
public class Restaurant {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;
 
 private String name;
 
 private String description;
 
 private String city;
 
 private String country;
 
 private String location;
 
 private String specialty;
 
 

   public Restaurant() {
	super();
     }

public Restaurant(Integer id, String name, String description, String city, String country, String location,
		String specialty) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.city = city;
	this.country = country;
	this.location = location;
	this.specialty = specialty;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getSpecialty() {
	return specialty;
}

public void setSpecialty(String specialty) {
	this.specialty = specialty;
}
 

}
