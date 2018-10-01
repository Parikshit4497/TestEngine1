package com.brainmentors.testengine.user.dto;

import javax.swing.JCheckBox;

public class RightAuthenticationDTO {
          private  JCheckBox rightButton;
          private int rightvalue;
          public int getRightvalue() {
			return rightvalue;
		}
		public void setRightvalue(int rightvalue) {
			this.rightvalue = rightvalue;
		}
		public JCheckBox getRightButton() {
			return rightButton;
		}
		public void setRightButton(JCheckBox rightButton) {
			this.rightButton = rightButton;
		}
		public boolean isBoolean() {
			return isBoolean;
		}
		public void setBoolean(boolean isBoolean) {
			this.isBoolean = isBoolean;
		}
		private boolean isBoolean;
	
		
          
}
