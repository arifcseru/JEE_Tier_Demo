package com.infy.persistencetier;

import java.util.ArrayList;
import java.util.Calendar;

import com.info.businesstier.EmployeeTO;

public class Service {
	private ArrayList<EmployeeTO> employeeList = new ArrayList<EmployeeTO>();

	public Service() {

		EmployeeTO employeeTO = new EmployeeTO();
		employeeTO.setName("Manoj Kumar");
		employeeTO.setEmpId("emp00");
		employeeTO.setPassWord("monoj@123");
		employeeTO.setSalary(50000);
		Calendar calendar = Calendar.getInstance();
		calendar.set(1980, 06, 30);
		employeeTO.setDateOfBirth(calendar);
		employeeList.add(employeeTO);

		EmployeeTO employeeTO1 = new EmployeeTO();
		employeeTO1.setName("Raghavendra Narayana");
		employeeTO1.setEmpId("emp01");
		employeeTO1.setPassWord("Narayana@123");
		employeeTO1.setSalary(50000);
		Calendar calendar1 = (Calendar) Calendar.getInstance().clone();
		calendar1.set(1980, 06, 30);
		employeeTO1.setDateOfBirth(calendar1);
		employeeList.add(employeeTO1);
		
		EmployeeTO employeeTO3 = new EmployeeTO();
		employeeTO3.setName("Narayana Murthy");
		employeeTO3.setEmpId("emp03");
		employeeTO3.setPassWord("Murthy@123");
		employeeTO3.setSalary(100000);
		Calendar calendar3= (Calendar) Calendar.getInstance().clone();
		calendar3.set(1990, 06, 30);
		employeeTO3.setDateOfBirth(calendar3);
		employeeList.add(employeeTO3);

	}

	public void addEmployee(EmployeeTO employeeTO) {
		employeeList.add(employeeTO);
//		return "it's oke";
	}

	public EmployeeTO getEmployee(String empId) {
		EmployeeTO findEmployeeTO = null;
				
		for(EmployeeTO employeeTO : employeeList) {
		    if(employeeTO.getEmpId().equals(empId)){
		    	findEmployeeTO = employeeTO;
		    }
		}
		
		return findEmployeeTO;
	}

	public String deleteEmployee(EmployeeTO delteEmployeeTO) {
		
		employeeList.remove(delteEmployeeTO);
		return "The Employee successfully delete";
	}

	public String UpdateEmployee(EmployeeTO updateEmployeeTO) {
		
		String id = updateEmployeeTO.getEmpId();
		
		for(EmployeeTO employeeTO : employeeList) {
			
		    if(employeeTO.getEmpId().equals(id)){
		    	
		    	employeeTO.setName(updateEmployeeTO.getName());
		    	employeeTO.setSalary(updateEmployeeTO.getSalary());
		    	
		    }
		    
		}
		
		return "Success update Employee with id "+id;
	}	

}
