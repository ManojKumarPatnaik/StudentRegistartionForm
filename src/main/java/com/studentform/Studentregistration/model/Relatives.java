package com.studentform.Studentregistration.model;



import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="RELATIVES")
public class Relatives implements Serializable {
	
	
	private static final long serialVersionUID = 8251485748641223048L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="relativeid")
	private int relativeid;
	@Column(name="name")
	private String name;
	@Column(name="relation")
	private String relation;
	@Column(name="address")
	private String address;
	@Column(name="contactnumber")
	private long contactNumber;
	
	
	
	/*
	 * @OneToMany(mappedBy = "relatives" ) private List<Student> student;
	 * 
	 * public List<Student> getStudent() { return student; } public void
	 * setStudent(List<Student> student) { this.student = student; }
	 */
	
	
	public int getRelativeId() {
		return relativeid;
	}
	public void setRelativeId(int relativeId) {
		this.relativeid = relativeId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactnumber) {
		this.contactNumber = contactnumber;
	}
	

	
	
	

}
