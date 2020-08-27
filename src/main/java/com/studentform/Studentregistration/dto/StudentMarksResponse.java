package com.studentform.Studentregistration.dto;

import java.util.List;

import com.studentform.Studentregistration.model.Marks;

public class StudentMarksResponse {

	private String name;
	private List<Marks> marks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Marks> getMarks() {
		return marks;
	}

	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}
}
