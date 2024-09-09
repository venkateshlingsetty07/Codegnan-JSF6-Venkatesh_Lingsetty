package com.codegnan.entity;

public class User {
	private int id;
	private String name;
	private String email;

	 public User() {
		 
	 }
	 public User(int id,String name,String email) {
		 this.id = id;
		 this.name = name;
		 this.email = email;
	 }
	 public void setId(int id) {
		 this.id = id;
	 }
	 public int getId() {
		 return id;
	 }
	 public void setName(String name) {
		 this.name = name;
	 }
	 public String getName() {
		 return name;
	 }
	 public void setEmail(String email) {
		 this.email = email;
	 }
	 public String getEmail() {
		 return email;
	 }
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	 

}
