package com.ata.service;

import java.util.List;

import com.ata.entity.Grade;

public interface GradeService {

	List<Grade> getAllStudentgrades();

	Grade getStudentgradeById(int id);

	Grade createStudentgrade(Grade student);

	Grade updateStudentgrade(int id, Grade student);

	void deletestudentgrade(int id);
	
	Grade getStudentgradeByRollno(int rollNo);

}
