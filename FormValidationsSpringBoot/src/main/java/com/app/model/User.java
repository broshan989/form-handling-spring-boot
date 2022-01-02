package com.app.model;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	@NotBlank(message = "Name is mandatory")
	@Size(min = 3, max = 25, message="Name must be 3 to 15 characters")
	private String name;
	
	@NotBlank(message = "email is mandatory")
	@Email(message = "Invalid email")
	private String email;
	
	@NotBlank(message = "Password is mandatory")
	@Size(min = 4, max = 15, message = "Password length should be 4 to 15 characters")
	private String password;
	
	@NotNull(message = "Gender not selected")
	private String gender;
	
	@NotEmpty(message = "Sport not selected")
	private List<String> sports;
	
	@NotBlank(message = "Select branch")
	private String branch;
	
	@NotNull(message = "Please enter birth date")
    @Past(message = "Date of birth is invalid future date is not accepted")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate birthDate;

	public List<String> getSports() {
		return sports;
	}

	public void setSports(List<String> sports) {
		this.sports = sports;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", gender=" + gender
				+ ", sports=" + sports + ", branch=" + branch + ", birthDate=" + birthDate + "]";
	}

}
