package com.ata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ata.entity.Grade;

public interface StudentgradeRepository  extends JpaRepository<Grade, Integer>{

	public Grade findByRollNo(int id);
}
