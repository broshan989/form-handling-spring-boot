package com.app.model;

import java.util.List;

public class User {
	private String name;
	private String email;
	private String password;
	private String gender;
	private List<String> hobbies;
	private String branch;
	private String birthDate;
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public List<String> getHobbies() {
		return hobbies;
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", gender=" + gender
				+ ", hobbies=" + hobbies + ", branch=" + branch + ", birthDate=" + birthDate + "]";
	}

}
