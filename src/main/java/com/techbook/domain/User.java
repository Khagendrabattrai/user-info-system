package com.techbook.domain;

import java.util.Date;

// we created object  on here 
public class User {
private int id;
private String userName;
private String password;
private String email;
private long mobileNmuber;
private Date dob;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getMobileNmuber() {
	return mobileNmuber;
}
public void setMobileNmuber(long mobileNmuber) {
	this.mobileNmuber = mobileNmuber;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}

}
