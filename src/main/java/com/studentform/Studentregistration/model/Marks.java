package com.studentform.Studentregistration.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MARKS")
public class Marks implements Serializable {

	private static final long serialVersionUID = -214530958316484950L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "markid")
	private long markid;
	@Column(name = "english")
	private long english;
	@Column(name = "maths")
	private long maths;
	@Column(name = "science")
	private long science;
	@Column(name = "hindi")
	private long hindi;
	@Column(name = "marathi")
	private long marathi;
	@Column(name = "totalmarks")
	private long totalMarks;
	@Column(name = "studentpercentage")
	private double studentPercentage;

	
	/*
	 * @OneToOne(cascade = CascadeType.ALL) //@JoinColumn(name="Student_Id") private
	 * Student student;
	 * 
	 */

	/*
	 * @OneToOne(cascade = CascadeType.ALL) private Student student;
	 * 
	 * 
	 * //@Column(name="Student_Id") public Student getStudent() { return student; }
	 * public void setStudent(Student student) { this.student = student; }
	 */

	
	public long getMarkid() {
		return markid;
	}

	public void setMarkid(long markid) {
		this.markid = markid;
	}

	
	public long getEnglish() {
		return english;
	}

	public void setEnglish(long english) {
		this.english = english;
	}


	public long getMaths() {
		return maths;
	}

	public void setMaths(long maths) {
		this.maths = maths;
	}

	
	public long getScience() {
		return science;
	}

	public void setScience(long science) {
		this.science = science;
	}

	
	public long getHindi() {
		return hindi;
	}

	public void setHindi(long hindi) {
		this.hindi = hindi;
	}


	public long getMarathi() {
		return marathi;
	}

	public void setMarathi(long marathi) {
		this.marathi = marathi;
	}

	
	public double getStudentpercentage() {
		return studentPercentage;
	}

	public void setStudentpercentage(double studentpercentage) {
		this.studentPercentage = studentpercentage;
	}


	public long getTotalmarks() {
		return totalMarks;
	}

	public void setTotalmarks(long totalmarks) {
		this.totalMarks = totalmarks;
	}

}
