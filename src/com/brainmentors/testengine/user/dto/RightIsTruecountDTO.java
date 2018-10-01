package com.brainmentors.testengine.user.dto;

import java.util.ArrayList;

public class RightIsTruecountDTO {
//	private ArrayList<RightAuthenticationDTO> right ;
//	private boolean answerTicked=false;;
//	public boolean isAnswerTicked() {
//		return answerTicked;
//	}
//	public void setAnswerTicked(boolean answerTicked) {
//		this.answerTicked = answerTicked;
//	}
//	public ArrayList<RightAuthenticationDTO> getRight() {
//		return right;
//	}
//	public void setRight(ArrayList<RightAuthenticationDTO> right) {
//		this.right = right;
//	}
     private 	ArrayList<RightAuthenticationDTO> rightAuth;
    public ArrayList<RightAuthenticationDTO> getRightAuth() {
		return rightAuth;
	}
	public void setRightAuth(ArrayList<RightAuthenticationDTO> rightAuth) {
		this.rightAuth = rightAuth;
	}
	private boolean isAnsticked;
	
	
	
	public boolean isAnsticked() {
		return isAnsticked;
	}
	public void setAnsticked(boolean isAnsticked) {
		this.isAnsticked = isAnsticked;
	}
    
    

}
