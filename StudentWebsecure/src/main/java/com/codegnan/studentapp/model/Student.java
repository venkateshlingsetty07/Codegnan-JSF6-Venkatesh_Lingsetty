package com.codegnan.studentapp.model;

public class Student {
private int id;
private String name;
private int age;	
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getCourse() {
	return Course;
}
public void setCourse(String course) {
	Course = course;
}
public Student(int id, String name, int age, String course) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	Course = course;
}
private String Course;
	 
}
