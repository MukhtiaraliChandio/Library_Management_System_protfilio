package com.dao;

import java.util.List;

import com.pojos.EmployeePojo;

public interface EmployeeDao {


	int saveEmployee(EmployeePojo emp);
	int updateEmployee(EmployeePojo emp);
	int deleteEmployee(EmployeePojo emp);
	

	
        List<EmployeePojo> getEmployees();
        EmployeePojo getEmployeeByCNICNumber(String cnicNumber);	
	
	
	
	
	
}