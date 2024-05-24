package com.ata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ata.entity.Grade;
import com.ata.repository.StudentgradeRepository;

@Service
public class GradeServiceImpl implements GradeService {
	
	@Autowired
	private StudentgradeRepository studentgraderepository;

	@Override
	public List<Grade> getAllStudentgrades() {
		return studentgraderepository.findAll();
	}

	@Override
	public Grade getStudentgradeById(int id) {
		return studentgraderepository.findById(id).orElse(null);
	}

	@Override
	public Grade createStudentgrade(Grade student) {
		return studentgraderepository.save(student);

	}

	@Override
	public Grade updateStudentgrade(int id, Grade student) {
		if (studentgraderepository.existsById(id)) {
            //student.setId(id);
            return studentgraderepository.save(student);
        }
        return null; // Handle not found case
	}
	

	@Override
	public void deletestudentgrade(int id) {
		studentgraderepository.deleteById(id);
	}

	@Override
	public Grade getStudentgradeByRollno(int rollNo) {
		return studentgraderepository.findByRollNo(rollNo);
	}
}
