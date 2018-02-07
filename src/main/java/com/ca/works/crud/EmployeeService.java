package com.ca.works.crud;

import java.util.List;

import javax.ws.rs.core.Response;
import com.ca.works.crud.Employee;


public interface EmployeeService {

	public Response addEmployee(Employee e);
	public Response addEmployeeDb(Employee e);
	
	public Response updateEmployee(Employee e);
	
	public Response deleteEmployee(int id);
	
	public Employee getEmployee(int id);
	public Employee getEmployeeDb(int id);
	
	public Employee[] getAllEmployees();
	public List<Employee> getAllEmployeesDb();
}
