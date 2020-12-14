package com.iptech;

public class User {
	private String username;
	private String password;
	private String name;

	public User (String[] values) {
		this.username = values[0];
		this.password = values[1];
		this.name = values[2];
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + "]";
	}
}
