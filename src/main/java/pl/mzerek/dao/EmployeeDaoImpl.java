package pl.mzerek.dao;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.driver.OracleCallableStatement;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.ReturningWork;
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

			Criteria c = sessionFactory.openSession().createCriteria(
					Employee.class, "employee");
			// /c.createAlias("employee.department", "department");

			c.setMaxResults(5);
			employees = c.list();

			return employees;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employees;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private List<Employee> execProcedure(final String imie) {
		List<Employee> list = new ArrayList<>();

		list =  sessionFactory.openSession().doReturningWork(
				new ReturningWork<List<Employee>>() {

					@Override
					public List<Employee> execute(Connection aConnection)
							throws SQLException {
						CallableStatement callstm = null;
						
//						/List<Employee> innerList =new ArrayList<Employee>();
						try {

							String aProcedureName = "get_employees_by_name";

							String functionCall = "{call " + aProcedureName
									+ "(?, ?)}";
							callstm = aConnection.prepareCall(functionCall);
							callstm.setString(1, imie);
							System.out.println("=========imie to: " + imie); 
							callstm.registerOutParameter(2, OracleTypes.CURSOR);
							boolean b = callstm.execute();
							System.out.println("=========callstm.execute: " + b); 
							System.out.println("=========getUpdateCount: " + callstm.getUpdateCount()); 
							ResultSet rs = (ResultSet) callstm.getObject(2);
							int i = 0;
							while(rs.next()){
//								Employee s = (Employee) rs.getRow();
//								System.out.println("=========rs to = " + s.getEmail()); 
							}
							
//							return (List<Employee>) callstm.getObject(2);
							return new ArrayList<Employee>();
						} finally {
							callstm.close();
						}
					}
				});
		return list;

	}
	
	@SuppressWarnings("unchecked")
	private List<Employee> execProcedure2(final String imie) {
		List<Employee> list = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		String aProcedureName = "get_employees_by_name";
		
		Query query = session.createSQLQuery("call get_employees_by_name(?,?)")
				.addEntity(Employee.class)
				.setParameter(0,  OracleTypes.CURSOR)
				.setParameter(1, imie);
				
		
		List employees = query.list();
		
		
		
		return employees;
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	private List<Employee> execProcedure3(final String imie) {
		List<Employee> list = new ArrayList<>();

		list =  sessionFactory.openSession().doReturningWork(
				new ReturningWork<List<Employee>>() {

					@Override
					public List<Employee> execute(Connection aConnection)
							throws SQLException {
						OracleCallableStatement callstm = null;
						
//						/List<Employee> innerList =new ArrayList<Employee>();
						try {

							String aProcedureName = "get_employees_by_name";

							String functionCall = "{call " + aProcedureName
									+ "(?, ?)}";
							callstm = (OracleCallableStatement) aConnection.prepareCall(functionCall);
							callstm.setString(1, imie);
							System.out.println("=========imie to: " + imie); 
							callstm.registerOutParameter(2, OracleTypes.CURSOR);
							boolean b = callstm.execute();
							System.out.println("=========callstm.execute: " + b); 
							System.out.println("=========getUpdateCount: " + callstm.getUpdateCount()); 
							ResultSet rs = (ResultSet) callstm.getObject(2);
							int i = 0;
							while(rs.next()){
//								
								System.out.println("=========rs to = " ); 
							}
							
//							return (List<Employee>) callstm.getObject(2);
							return new ArrayList<Employee>();
						} finally {
							callstm.close();
						}
					}
				});
		return list;

	}
	
	
	public <T> List<Employee> callProcedure(String imie) {
		
		//List<Employee> list = execProcedure(imie);
		//List<Employee> list2 = execProcedure2(imie);
		List<Employee> list3 = execProcedure3(imie);
		
		return new ArrayList<Employee>();
	}
}
