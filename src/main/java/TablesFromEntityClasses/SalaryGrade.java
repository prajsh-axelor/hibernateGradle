package TablesFromEntityClasses;

import javax.persistence.*;

 @Entity
 @Table(name = "salary_grade")
 public class SalaryGrade {
	 private Integer grade;
	 private Float lowSalary;
	 private Float highSalary;
	 
	 public SalaryGrade() {
	 }
	 
	 public SalaryGrade(Integer grade, Float lowSalary, Float highSalary) {
	     this.grade = grade;
	     this.lowSalary = lowSalary;
	     this.highSalary = highSalary;
	 }
	 
	 @Id
	 @Column(name = "grade")
	 public Integer getGrade() {
	     return grade;
	 }
	 
	 public void setGrade(Integer grade) {
	     this.grade = grade;
	 }
	 
	 @Column(name = "low_salary", nullable = false)
	 public Float getLowSalary() {
	     return lowSalary;
	 }
	 
	 public void setLowSalary(Float lowSalary) {
	     this.lowSalary = lowSalary;
	 }
	 
	 @Column(name = "high_salary", nullable = false)
	 public Float getHighSalary() {
	     return highSalary;
	 }
	 
	 public void setHighSalary(Float highSalary) {
	     this.highSalary = highSalary;
	 }
}