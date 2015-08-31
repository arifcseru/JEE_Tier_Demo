package com.infy.presentationtier;

import static org.junit.Assert.assertEquals;
import java.util.Calendar;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.info.businesstier.EmployeeTO;
import com.info.businesstier.Maneger;

public class Tester {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	EmployeeTO employeeTO = new EmployeeTO();
	Maneger manager = new Maneger();

	@Test	
	public void invalidUserName() throws Exception {
		employeeTO.setName("");
		employeeTO.setEmpId("emp21");
		employeeTO.setSalary(10000.00);

		employeeTO.setPassWord("dfdfasdf123%");

		Calendar calendar = Calendar.getInstance();
		calendar.set(1990, 06, 30);
		employeeTO.setDateOfBirth(calendar);
		
		thrown.expectMessage("user name is not valid");
		manager.addEmplyoee(employeeTO);
	}

	@Test
	public void valaidUpdate() throws Exception  {
		employeeTO.setEmpId("emp01"); // should found in list/DB

		employeeTO.setName("Senior Raghavendra");
		employeeTO.setSalary(70000);
		
		String actual = manager.updateEmployee(employeeTO);
		String expected = "Success update Employee with id "+employeeTO.getEmpId();
		
		assertEquals(expected, actual);
		
	}

	@Test //(expected = java.lang.Exception.class)
	public void invalaidUpdate() throws Exception  {
		employeeTO.setName("Senior Raghavendra");
		employeeTO.setSalary(70000);

		thrown.expectMessage("The Employee is not found !");
		manager.updateEmployee(employeeTO);				
	}

}
