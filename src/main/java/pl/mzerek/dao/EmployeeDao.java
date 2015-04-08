package pl.mzerek.dao;

import java.util.List;

import oracle.jdbc.driver.OracleResultSet;
import pl.mzerek.model.Employee;

public interface EmployeeDao {

	public boolean addEmployee(Employee emp);
	
	public List<Employee> findAllEmployees();
	
	public Employee findEmployeeById(long employeeId);
	
	public <T> List<Employee> callProcedure(String imie);
}
