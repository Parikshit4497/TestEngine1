package com.brainmentors.testengine.util.constants;

import java.util.regex.Pattern;

public class Authentication {
	   public String checksChar(String name){
       	
	        String result="";
	        for(int i=0;i<name.length();i++) {
	        	if((name.charAt(i)>=65&&name.charAt(i)<=90)||((name.charAt(i)>=97&&name.charAt(i)<=122))){
	        	 result="correct";
	        	}else {
	        		 result="incorrect";
	        		break;
	        	}
	        	
	        }
	       
	        return result;
	       }
	   public  String checkPhoneNo(String number) {
           String isCorrect="correct";
		   int i;
		   
			   for(i=0;i<number.length();i++) {
				   if(number.charAt(i)>=48&&number.charAt(i)<=57) {
					   isCorrect="correct";
				   }
				   else {
					   isCorrect="incorrect";
					   break;
				   }
			   }
			  
		   		   
		   return isCorrect;
	   }
	   public String checkEmail(String email) {
            String check="";
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                    "A-Z]{2,7}$";
                     
Pattern pat = Pattern.compile(emailRegex);

if (pat.matcher(email).matches()) {
	check= "correct";
}else  if(email==null||pat.matcher(email).matches()==false){
check= "incorrect";		
	}
return check; 
}
	public String checkPassword(String password) {
		// TODO Auto-generated method stub
		String passwordStatus="";
		boolean lowerCase=false;;
		boolean upperCase=false;
		boolean number=false;
		boolean  specialSymb=false;
		int i;
		if(password.length()==0) {
         return null;			
		}
		for(i=0;i<password.length();i++) {
			if(password.charAt(i)>=65&&password.charAt(i)<=90) {
				upperCase=true;
			}else if(password.charAt(i)>=97&&password.charAt(i)<=122) {
				lowerCase=true;
			}else if(password.charAt(i)>=48&&password.charAt(i)<=57) {
				number=true;
			}else if(password.charAt(i)>=33&&password.charAt(i)<=47||password.charAt(i)>=58&&password.charAt(i)<=64||password.charAt(i)>=91&&password.charAt(i)<=96) {
				specialSymb=true;
			}
		}
		if(((upperCase && lowerCase)||upperCase||lowerCase)&&password.length()<6) {
			passwordStatus="weak";
		}else if((upperCase&&lowerCase&&number)&&(password.length()>6&&password.length()<12)) {
		passwordStatus="medium";
		}else if((upperCase&&lowerCase&&number&&specialSymb)&&(password.length()>12&&password.length()<18)) {
			passwordStatus="strong";
		}
	
	   return passwordStatus;
}
	public String passwordMatch(String initial,String confirm) {
		// TODO Auto-generated method stub
		 int i=0,j=0;
		 String result="";
		 while(i<initial.length()&&j<confirm.length()) {
			 if(initial.charAt(i)==confirm.charAt(j)) {
				 result="correct";
			 }else {
				 result="incorrect";
				 break;
			 }
			 i++;
			 j++;
		 }
	      return result;
	}
	

}
	   
