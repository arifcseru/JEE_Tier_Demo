package com.infy.presentationtier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import com.info.businesstier.EmployeeTO;
import com.info.businesstier.Maneger;

public class InfyEmployee {

	public static void main(String[] args) {
		
		EmployeeTO employeeTO = new EmployeeTO();
		Maneger manager = new Maneger();
		
		new InfyEmployee().addEmployee(employeeTO,manager);
//		new InfyEmployee().updateEmployee(employeeTO,manager);
//		new InfyEmployee().removeEmployee(manager);										
		
		new InfyEmployee().allEmployee(manager);	
	}	

	private void allEmployee(Maneger manager) {
		ArrayList<EmployeeTO> list = manager.allEmployee();
		
		Iterator iterator = list.iterator();
		
		System.out.println("=================All infy Employee==================");
		
		while(iterator.hasNext()) {
			
			EmployeeTO employee = (EmployeeTO)iterator.next();
		    System.out.println("Id: "+employee.getEmpId()+"\tName: "+employee.getName()+" \t Salary: "+employee.getSalary()+"\t Date of Birth: "+employee.getDateOfBirth().getTime());
		
		}
		
	}

	private void addEmployee(EmployeeTO employeeTO, Maneger manager) {
		
		employeeTO.setName("employe");
		employeeTO.setEmpId("emp21");
		employeeTO.setSalary(10000.00);
		
		employeeTO.setPassWord("dfdfasdf123%");

		Calendar calendar = Calendar.getInstance();
		calendar.set(1990, 06, 30);
		employeeTO.setDateOfBirth(calendar);
				
		try {
			
			manager.addEmplyoee(employeeTO);
			System.out.println("The Employee successfully add with \nEmployee name: "+employeeTO.getName()+"\nEmployee ID: "+employeeTO.getEmpId()+"\nEmployee Salary: "+employeeTO.getSalary()+"\nDate of Birth : "+employeeTO.getDateOfBirth().getTime());
		
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	
	private void updateEmployee(EmployeeTO employeeTO, Maneger manager) {
		
		employeeTO.setEmpId("emp01"); // should found in list/DB
		
		employeeTO.setName("Senior Raghavendra");
		employeeTO.setSalary(70000);
		
		try {
			System.out.println(manager.updateEmployee(employeeTO));
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Error : "+e.getMessage());
		}
		
	}

	private void removeEmployee(Maneger manager) {
		
		String emId = "emp01";
		
		try {
			System.out.println(manager.deleteEmplyoee(emId));
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Error: "+e.getMessage());
		}
		
	}

}
