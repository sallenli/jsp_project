package com.itheima.domain;

public class User {
private int id;
private String userName;
private String userPassword;
private int age;
private String hobby;
public User(int id, String userName, String userPassword, int age,String hobby) {
	super();
	this.id = id;
	this.userName = userName;
	this.userPassword = userPassword;
	this.age = age;
	this.hobby=hobby;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Override
public String toString() {
	return "User [id=" + id + ", userName=" + userName + ", userPassword="
			+ userPassword + ", age=" + age + ", hobby=" + hobby + "]";
}
public String getHobby() {
	return hobby;
}
public void setHobby(String hobby) {
	this.hobby = hobby;
}
}
