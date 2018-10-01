package com.brainmentors.testengine.user.dto;

public class RegisterDTO {
 private String firstName;
 private String lastName;
 private String emailId;
 private String phoneNO;
 private String password;
 private String confirmPassword;
 private String selectCity ;
 private String selectCollege;
 private String selectStream;
 private String selectUsertype;
 private String Gender;
 private String DateOfBirth;
 private String collegId;
 private String userID;
public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
}
public String getCollegId() {
	return collegId;
}
public void setCollegId(String collegId) {
	this.collegId = collegId;
}
public String getDateOfBirth() {
	return DateOfBirth;
}
public void setDateOfBirth(String dateOfBirth) {
	DateOfBirth = dateOfBirth;
}
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	Gender = gender;
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
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getPhoneNO() {
	return phoneNO;
}
public void setPhoneNO(String phoneNO) {
	this.phoneNO = phoneNO;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfirmPassword() {
	return confirmPassword;
}
public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}
public String getSelectCity() {
	return selectCity;
}
public void setSelectCity(String selectCity) {
	this.selectCity = selectCity;
}
public String getSelectCollege() {
	return selectCollege;
}
public void setSelectCollege(String selectCollege) {
	this.selectCollege = selectCollege;
}
public String getSelectStream() {
	return selectStream;
}
public void setSelectStream(String selectStream) {
	this.selectStream = selectStream;
}
public String getSelectUsertype() {
	return selectUsertype;
}
public void setSelectUsertype(String selectUsertype) {
	this.selectUsertype = selectUsertype;
}

 
}
