package com.info.businesstier;

import java.util.Calendar;

public class Validation {

	public void validate(EmployeeTO userTO) throws Exception {

		String errorMessage = null;

		if (!nameValidation(userTO.getName())) {
			errorMessage = "user name is not valid";
		} else if (!empIdValidation(userTO.getEmpId())) {
			errorMessage = "Employee id is not valid "; 
		}else if (!passWordValidation(userTO.getPassWord())) {
			errorMessage = "password is not valid ";
		} else if (!ageValidation(userTO.getDateOfBirth())) {
			errorMessage = "invalid age";
		} else if (!salaryValidation(userTO.getSalary())) {
			errorMessage = "invalid balance";
		}
		
		
		if (errorMessage != null) {
			throw new Exception(errorMessage);
		}

	}

	private boolean empIdValidation(String empId) {
		boolean isValid = true;
		
		empId = empId.trim();
		
		if(empId.length()>100 || empId.length() == 0){
			isValid = false;
		}else{
			
			for(int i = 0; i<empId.length();i++){
				if(empId.charAt(i)==' ' ||empId.charAt(i)=='.'||empId.charAt(i)=='-'){
					isValid = false;
					break;
				}					
			}			
		}		
		return isValid;
	}

	private boolean nameValidation(String name) {	
		boolean isValid = true;

		name = name.trim();
		
		if(name.equals("")){
			isValid = false;
		}

		return isValid;
	}

	private boolean passWordValidation(String passWord) {
		boolean isValid = true;

		// password need to be at least 8 char
		if (passWord.length() < 8) {
			isValid = false;
			
		} else if (!(passWord.contains("!") || passWord.contains("@")|| passWord.contains("#") || passWord.contains("$") || passWord.contains("%"))) {// Should contain special char ! @ # $ %
			isValid = false;
			
		} else {// should contain numeric char
			int i;
			for (i = 0; i < passWord.length(); i++){
				
				if(Character.isDigit(passWord.charAt(i)))
					break;
			}
			
			if(i == passWord.length())
			isValid = false;
				
		}
		
		return isValid;

	}

	private boolean ageValidation(Calendar age) {
		boolean isValid = true;

		Calendar age18 = (Calendar) Calendar.getInstance().clone();
		age18.add(Calendar.YEAR, -18);
		
//		System.out.println(age.getTime()+"i'm here"+age18.getTime());
		
		if (age.after(Calendar.getInstance())||age18.before(age)){
			isValid = false;
			}
		return isValid;

	}

	private boolean salaryValidation(double balance) {
		boolean isValid = true;
		if (balance < 10000 || balance > 100000){
			isValid = false;
		}
		return isValid;
	}
}
