package pl.mzerek.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.mzerek.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addEmployee(Employee emp) {
		try {
			sessionFactory.getCurrentSession().save(emp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Employee findEmployeeById(long employeeId) {
		Employee result = new Employee();
		try {
			result = (Employee) sessionFactory.getCurrentSession().get(
					Employee.class, employeeId);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		
		try {
		
			Criteria c = sessionFactory.openSession().createCriteria(Employee.class, "employee");
//			/c.createAlias("employee.department", "department");
			
			c.setMaxResults(5);
			employees = c.list();			
		
			return employees;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return employees;
	}

}
