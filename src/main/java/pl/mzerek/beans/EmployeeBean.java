package pl.mzerek.beans;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.mzerek.model.Employee;
import pl.mzerek.service.EmployeeService;

@Component("employeeBean")
public class EmployeeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Employee employee = new Employee();
	private List<Employee> employees;

	@Autowired
	private EmployeeService employeeService;

	private Employee emp1;
	private Employee emp2;

	public EmployeeBean() {
		emp1 = new Employee();
		emp1.setFirstName("Huong");
		emp1.setLastName("Nguyen");
		emp2 = new Employee();
		emp2.setFirstName("Khang");
		emp2.setLastName("Le");
	}

	public void addEmployee() {
		employeeService.addEmployee(emp1);
		employeeService.addEmployee(emp2);
		employee = employeeService.findEmployeeById(emp1.getEmployeeId());
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	

	public List<Employee> getEmployees() {
		
		employeeService.callProcedure("Peter");
		return employeeService.findAllEmployees();
	}

}
