package org.example.jpa.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Branch {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "BRANCH_ID")
	private int branchId;

	@Column(name = "BRANCH_NAME")
	private String branchName;

	@Column(name = "BRANCH_SHORT_NAME")
	private String branchShortName;

	@Column(name = "DESCRIPTION")
	private String description;

	@OneToMany(mappedBy = "branch", cascade = {CascadeType.ALL})
	private List<Student> students;
	
	
	
	/* *************************************************************** */
	public int getBranchId() {
		return this.branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return this.branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchShortName() {
		return this.branchShortName;
	}
	public void setBranchShortName(String branchShortName) {
		this.branchShortName = branchShortName;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Student> getStudents() {
		return this.students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setBranch(this);
		return student;
	}
	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setBranch(null);
		return student;
	}
}