package com.savio.sha.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.savio.sha.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	Student findByStudentId(int studentId);

}
