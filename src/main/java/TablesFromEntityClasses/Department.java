package TablesFromEntityClasses;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="department", uniqueConstraints= {@UniqueConstraint(columnNames= {"dept_no"})})
public class Department {

	private Integer deptId;
	private String deptNo;
	private String deptName;
	private String location;
	private Set<Employee> employees = new HashSet<Employee>();
	
	//zero argument constructor
	public Department() {
		
	}

	public Department(Integer deptId, String deptNo, String deptName, String location) {
		super();
		this.deptId = deptId;
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.location = location;
	}

	@Id
	@Column(name="dept_id")
	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	@Column(name="dept_no", nullable=false)
	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
	
}
