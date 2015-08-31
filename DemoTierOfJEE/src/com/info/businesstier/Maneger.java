package com.info.businesstier;

import com.infy.persistencetier.Service;

public class Maneger {

	public void addEmplyoee(EmployeeTO employeeTO) throws Exception {

		new Validation().validate(employeeTO);

		if (new Service().getEmployee(employeeTO.getEmpId()) == null) { 
			
			new Service().addEmployee(employeeTO);
			
		} else {
			throw new Exception("The Employee id already registerd");
		}

	}


	public String deleteEmplyoee(String empId) throws Exception {
		
		EmployeeTO delteEmployeeTO = new Service().getEmployee(empId);
		String re = null;
		
		if (delteEmployeeTO == null) {
			
			throw new Exception("The Employee found with this employee Id");
			
		} else {
			re = new Service().deleteEmployee(delteEmployeeTO);
		}
		
		return re+" : "+empId;
	}

	public String updateEmployee(EmployeeTO updateEmployeeTO) throws Exception{
		String result = null;
	
			if (new Service().getEmployee(updateEmployeeTO.getEmpId()) != null) { 
				
				result = new Service().UpdateEmployee(updateEmployeeTO);
				
			} else {
				throw new Exception("The Employee is not found !");
			}
			
		
		return result;
		
	}
	
}
