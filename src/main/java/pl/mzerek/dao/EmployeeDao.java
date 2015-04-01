package pl.mzerek.dao;

import java.util.List;

import pl.mzerek.model.Employee;

public interface EmployeeDao {

	public boolean addEmployee(Employee emp);
	
	public List<Employee> findAllEmployees();
	
	public Employee findEmployeeById(long employeeId);
}
