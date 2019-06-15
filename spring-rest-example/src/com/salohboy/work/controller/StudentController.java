package com.salohboy.work.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salohboy.work.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {
	List<Student> students;
	
	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();
		students.add(new Student("bobo", "boboyjon"));
		students.add(new Student("momo", "momoyjon"));
		students.add(new Student("Salohiddin", "Norqobilov"));
		students.add(new Student("Firuza", "Sarimsoqova"));
		students.add(new Student("Mubina", "SALOHIDDIN QIZI"));
		students.add(new Student("MUHAMMAD", "ANVAROV"));
	}
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// check the studentId against the list size
		if((studentId>=students.size()) || studentId<0) {
			throw new StudentNotFoundException("StudentId not found : "+studentId);
		}
		return students.get(studentId); 
	}

	@GetMapping("/students")
	public List<Student> getStudents(){
		return students;
	}
	

	
	
}
