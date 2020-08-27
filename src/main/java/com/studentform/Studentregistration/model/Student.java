package com.studentform.Studentregistration.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="studentid")
	private Integer studentid;
	@Column(name="student_name")
	private String studentName;
	@Column(name = "student_dob")
	private String studentdob;
	@Column(name = "studentaddress")
	private String studentAddress;
	@Column(name = "student_contact_number")
	private long studentContactNumber;

	// Mapping and joining the Tables

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "studentrelatives_fk",referencedColumnName = "studentid")
	private List<Relatives> relatives;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "studentmarks_fk" ,referencedColumnName = "studentid" )
	private List<Marks> marks;
	
	public List<Marks> getMarks() {
		//marks = new ArrayList<Marks>();
		return marks;
	}
	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}
	
	//Instance of Student Class
	/*
	 * private Student student;
	 * 
	 * 
	 * public Student getStudent() { return student; }
	 */

	/*
	 * public void setStudent(Student student) { this.student = student; }
	 */

	public Integer getStudentid() {
		return studentid;
	}

	public void setStudentId(Integer studentId) {
		this.studentid = studentId;
	}

	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	
	public String getStudentdob() {
		return studentdob;
	}

	public void setStudentDOB(String studentdob) {
		this.studentdob = studentdob;
	}

	
	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentaddress) {
		this.studentAddress = studentaddress;
	}

	
	public long getStudentContactNumber() {
		return studentContactNumber;
	}

	public void setStudentContactNumber(long studentcontactnumber) {
		this.studentContactNumber = studentcontactnumber;
	}

	//@Column(name = "student_relatives")
	public List<Relatives> getRelatives() {
		return relatives;
	}

	public void setRelatives(List<Relatives> relatives) {
		this.relatives = relatives;
	}

	

}