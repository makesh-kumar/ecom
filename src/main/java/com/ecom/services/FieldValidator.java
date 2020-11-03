package com.ecom.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldValidator {
	
	public boolean isEmail(String email) {
//		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?!-)(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		if(email==null) {
			return false;
		}
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	

	
	public boolean isStringEmpty(String str){
		

		if( str== null || str.trim().equals("")) {
			
			return false;
		}
		
		else {
			
			return true;
		}
		
	}
	
	public boolean isPureString(String str){
		
	     str = str.toLowerCase();
	      char[] charArray = str.toCharArray();
	      for (int i = 0; i < charArray.length; i++) {
	         char ch = charArray[i];
	         if (!(ch >= 'a' && ch <= 'z')) {
	        	
	            return false;
	         }
	      }
	    
	      return true;
	}
	

}
