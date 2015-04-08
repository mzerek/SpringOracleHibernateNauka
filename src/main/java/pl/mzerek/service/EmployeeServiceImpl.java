package pl.mzerek.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.mzerek.dao.EmployeeDao;
import pl.mzerek.model.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EmployeeDao empDao;

	@Override
	public Employee findEmployeeById(long empId) {		
		return empDao.findEmployeeById(empId);
	}

	@Override
	public boolean addEmployee(Employee emp) {
		return empDao.addEmployee(emp);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return empDao.findAllEmployees();
	}

	@Override
	public <T> List<Employee> callProcedure(String imie) {
		List<Employee> employees =  empDao.callProcedure(imie);
		return employees;
	}
	
	

}
