package com.savio.sha.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.savio.sha.model.Student;
import com.savio.sha.util.HibernateUtil;

public class StudentDao {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public StudentDao() {}
	
	public List<Student> getStudents() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Student> students = session.createCriteria(Student.class).list();
		session.close();
		return students;
	}
	
	public Student getStudent(int studentId) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("studentId", studentId));
		Student student = (Student) criteria.list().get(0);
		session.close();
		return student;
	}
}
