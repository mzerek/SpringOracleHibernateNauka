package pl.mzerek.service;

import java.util.List;

import pl.mzerek.model.Employee;

public interface EmployeeService {
	public Employee findEmployeeById(long employeeId);
	
	public boolean addEmployee(Employee emp);
	
	public List<Employee> findAllEmployees();
}
