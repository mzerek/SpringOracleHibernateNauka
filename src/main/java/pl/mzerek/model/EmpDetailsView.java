package pl.mzerek.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the EMP_DETAILS_VIEW database table.
 * 
 */
@Embeddable
@Table(name="EMP_DETAILS_VIEW")
public class EmpDetailsView implements Serializable {
	private static final long serialVersionUID = 1L;

	private String city;

	@Column(name="COMMISSION_PCT")
	private BigDecimal commissionPct;

	@Column(name="COUNTRY_ID")
	private String countryId;

	@Column(name="COUNTRY_NAME")
	private String countryName;

	@Column(name="DEPARTMENT_ID")
	private BigDecimal departmentId;

	@Column(name="DEPARTMENT_NAME")
	private String departmentName;

	@Column(name="EMPLOYEE_ID")
	private BigDecimal employeeId;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="JOB_ID")
	private String jobId;

	@Column(name="JOB_TITLE")
	private String jobTitle;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="LOCATION_ID")
	private BigDecimal locationId;

	@Column(name="MANAGER_ID")
	private BigDecimal managerId;

	@Column(name="REGION_NAME")
	private String regionName;

	private BigDecimal salary;

	@Column(name="STATE_PROVINCE")
	private String stateProvince;

	public EmpDetailsView() {
	}

	public String getCity() {
		return this.city;
	}



	public BigDecimal getCommissionPct() {
		return this.commissionPct;
	}



	public String getCountryId() {
		return this.countryId;
	}



	public String getCountryName() {
		return this.countryName;
	}



	public BigDecimal getDepartmentId() {
		return this.departmentId;
	}



	public String getDepartmentName() {
		return this.departmentName;
	}



	public BigDecimal getEmployeeId() {
		return this.employeeId;
	}


	public String getFirstName() {
		return this.firstName;
	}


	public String getJobId() {
		return this.jobId;
	}


	public String getJobTitle() {
		return this.jobTitle;
	}


	public String getLastName() {
		return this.lastName;
	}


	public BigDecimal getLocationId() {
		return this.locationId;
	}



	public BigDecimal getManagerId() {
		return this.managerId;
	}


	public String getRegionName() {
		return this.regionName;
	}



	public BigDecimal getSalary() {
		return this.salary;
	}


	public String getStateProvince() {
		return this.stateProvince;
	}

}