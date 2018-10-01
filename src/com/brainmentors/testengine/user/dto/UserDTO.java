package com.brainmentors.testengine.user.dto;

import java.util.ArrayList;

public class UserDTO {
private String userid;
private String password;
private String roleName;
private String authentication;
private String firstName;
private String lastName;
private String emailId;
private String phoneNO;


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
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	Gender = gender;
}
public String getDateOfBirth() {
	return DateOfBirth;
}

public void setDateOfBirth(String dateOfBirth) {
	DateOfBirth = dateOfBirth;
}
public String getCollegId() {
	return collegId;
}
public void setCollegId(String collegId) {
	this.collegId = collegId;
}

private String confirmPassword;
private String selectCity ;
private String selectCollege;
private String selectStream;
private String selectUsertype;
private String Gender;
private String DateOfBirth;
private String collegId;
private int uid;
private 	String  roleID;
public String getRoleID() {
	return roleID;
}
public void setRoleID(String roleID) {
	this.roleID = roleID;
}

private RightIsTruecountDTO rightIstrueDto;
public RightIsTruecountDTO getRightIstrueDto() {
	return rightIstrueDto;
}
public void setRightIstrueDto(RightIsTruecountDTO rightIstrueDto) {
	this.rightIstrueDto = rightIstrueDto;
}


public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}

private ArrayList<RightDTO> right=new ArrayList<>();


public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}

public String getAuthentication() {
	return authentication;
}
public void setAuthentication(String authentication) {
	this.authentication = authentication;
}




public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public ArrayList<RightDTO> getRight() {
	return right;
}
public void setRight(ArrayList<RightDTO> right) {
	this.right = right;
}

}
