package com.ata.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ata.entity.Grade;
import com.ata.service.GradeService;

@RestController
@RequestMapping("/StudentGrade")
public class GradeController {
	
	@Autowired
	private GradeService gradeservice;
	
	@GetMapping
    public List<Grade> getAllStudentgrades() {
        return gradeservice.getAllStudentgrades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getStudentById(@PathVariable int id) {
    	Grade student = gradeservice.getStudentgradeById(id);
        return ResponseEntity.of(Optional.ofNullable(student));
    }

    @GetMapping("rollNo/{id}")
    public ResponseEntity<Grade> getStudentByRollNo(@PathVariable int id){
    	Grade grade = gradeservice.getStudentgradeByRollno(id);
		return ResponseEntity.of(Optional.ofNullable(grade));
    	
    }
    @PostMapping("/")
    public ResponseEntity<Grade> createStudent(@RequestBody Grade student) {
    	Grade createdstudent = gradeservice.createStudentgrade(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdstudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grade> updateStudent(@PathVariable int id, @RequestBody Grade student) {
    	Grade updatedStudent = gradeservice.updateStudentgrade(id, student);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
    	gradeservice.deletestudentgrade(id);
        return ResponseEntity.noContent().build();
    }
}
