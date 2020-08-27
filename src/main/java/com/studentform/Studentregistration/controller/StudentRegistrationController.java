package com.studentform.Studentregistration.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentform.Studentregistration.dto.StudentRequestInput;
import com.studentform.Studentregistration.exception.StudentNotFoundException;
import com.studentform.Studentregistration.model.Marks;
import com.studentform.Studentregistration.model.Relatives;
import com.studentform.Studentregistration.model.Student;
import com.studentform.Studentregistration.repository.StudentRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentRegistrationController {

	@Autowired
	private StudentRepository studentRepository;

	@PostMapping("/newstudent")
	public Student newStudentRegistration(@Validated @RequestBody StudentRequestInput studentRequestInput) {

		Student student = null;
		if (studentRequestInput != null) {
			student = new Student();
			student.setStudentAddress(studentRequestInput.getStudentAddress());
			student.setStudentContactNumber(studentRequestInput.getStudentContactNumber());
			student.setStudentDOB(studentRequestInput.getStudentdob());
			student.setStudentName(studentRequestInput.getStudentName());
		}
		System.out.println("POST Method Is Runing Fine");
		if (student != null) {
			return studentRepository.save(student);
		}
		return null;

		/*
		 * { // Marks marks=new Marks();
		 * 
		 * Long totalMarks = 0L; for (Marks marks :studentRequestInput.getMarks()) {
		 * 
		 * totalMarks = marks.getEnglish() + marks.getHindi() + marks.getMarathi() +
		 * marks.getMaths() + marks.getScience(); } double percentage =
		 * totalMarks.doubleValue() / 500 * 100;
		 * studentRequestInput.getMarks().get(0).setTotalmarks(totalMarks);
		 * studentRequestInput.getMarks().get(0).setStudentpercentage(percentage);
		 *
		 * 
		 */
		// return studentRepository.save(studentRequestInput);
	}

	@PostMapping("/newrelative")
	public void newRelativeRegistration(@RequestParam Integer studentid, @RequestBody Relatives relative) {
		if (studentid != 0) {
			Optional<Student> optionalStudent = studentRepository.findById(studentid);
			if (!optionalStudent.isEmpty()) {
				Student student = optionalStudent.get();
				if (student.getRelatives() == null) {
					student.setRelatives(new ArrayList<Relatives>());
					student.getRelatives().add(relative);
					studentRepository.save(student);
				} else if (student.getRelatives().size() <=4) {
					System.out.println("size of the New Relative Entry----"+student.getRelatives().size());
					student.getRelatives().add(relative);
					studentRepository.save(student);
				}
			}
		}
	}
	
	@PostMapping("/newmarks")
	public void newMarksRegistration(@RequestParam Integer studentid, @RequestBody Marks marks) {
		if (studentid != 0) {
			Optional<Student> optionalStudent = studentRepository.findById(studentid);
			if (!optionalStudent.isEmpty()) {
				Student student = optionalStudent.get();
				if(student.getMarks().size()<=0) {
					System.out.println("The Entry Size of Marks ---"+student.getMarks().size());
				List<Marks> marksList = student.getMarks();
				marksList.add(marks);
				Long totalMarks = 0L;
				totalMarks = marks.getEnglish() + marks.getHindi() + marks.getMarathi() + marks.getMaths()
						+ marks.getScience();
				marksList.get(0).setTotalmarks(totalMarks);
				double percentage = totalMarks.doubleValue() / 500 * 100;
				marksList.get(0).setStudentpercentage(percentage);
				studentRepository.save(student);
				}

			}
		}
	}


	@GetMapping("/relativelist")
	public List<Relatives> getAllStudentRelatives(@RequestParam Integer studentid) {
		System.out.println("In get realtives list-------- "+studentid);
		if (studentid != 0) {
			Optional<Student> optionalStudent = studentRepository.findById(studentid);
			if (!optionalStudent.isEmpty()) {
				Student student = optionalStudent.get();
				System.out.println(" Relative List is Runinig Fine------"+student.getRelatives());
				return student.getRelatives();
			}
		}
		return null;
	}
	
	
	@GetMapping("/markslist")
	public List<Marks> getAllStudentMarks(@RequestParam Integer studentid) {
		if (studentid != 0) {
			Optional<Student> optionalStudent = studentRepository.findById(studentid);
			if (!optionalStudent.isEmpty()) {
				Student student = optionalStudent.get();
				System.out.println(" Marks List is Runinig Fine");
				return student.getMarks();
			}
		}
		return null;
	}
	/*
	 * @GetMapping("/markslist") public StudentMarksResponse
	 * getAllStudentMarks(@RequestParam Integer studentid) { StudentMarksResponse
	 * studentMarksResponse = null; if (studentid != 0) { Optional<Student>
	 * optionalStudent = studentRepository.findById(studentid); if
	 * (!optionalStudent.isEmpty()) { Student student = optionalStudent.get();
	 * if(!student.getMarks().isEmpty()) { studentMarksResponse = new
	 * StudentMarksResponse();
	 * studentMarksResponse.setName(student.getStudentName());
	 * studentMarksResponse.setMarks(student.getMarks()); }
	 * System.out.println(" Marks List is Runinig Fine"); } } return
	 * studentMarksResponse; }
	 */


	@GetMapping("/studentlist")
	public List<Student> getAllStudent() {
		System.out.println(" StudentList Method is Runinig Fine");
		return studentRepository.findAll();
	}



	@GetMapping("/relativelists/{studentid}")
	public Relatives getAllRelatives(@PathVariable Integer studentid, @RequestBody Relatives relative) {
		if (studentid != 0) {
			Optional<Student> optionalStudent = studentRepository.findById(studentid);
			if (!optionalStudent.isEmpty()) {
				Student student = optionalStudent.get();
				student.getRelatives();
			}
			if (!optionalStudent.isPresent())
				throw new StudentNotFoundException("studentid-" + studentid);

		}
		return getAllRelatives(studentid, relative);
	}

	@PostMapping("/students")
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		Student body = studentRepository.save(student);
		return ResponseEntity.ok(body);

	}

}
