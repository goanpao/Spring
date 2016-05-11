package com.savio.sha.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.savio.sha.dao.StudentRepository;
import com.savio.sha.model.Student;

@RestController
@RequestMapping("/school/service")
public class RestServiceController {

//	private StudentDao studentDao = new StudentDao();
	@Autowired
	StudentRepository repository;
	
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public Iterable<Student> students() {
		return repository.findAll();
	}
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public Student student(HttpServletRequest request) {
		if (request.getParameter("id") != null)
			return repository.findOne(Integer.parseInt(request.getParameter("id")));
//			return studentDao.getStudent(Integer.parseInt(request.getParameter("id")));
		return null;
	}

}
