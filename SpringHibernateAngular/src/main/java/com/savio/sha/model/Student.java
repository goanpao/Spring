package com.savio.sha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="student")
public class Student {
	
	@Id
	@Column(name="studentid")
	int studentId;
	
	@Column(name="name",nullable=false,length=50)
	String name;
	
	@Column(name="imageurl",nullable=false,length=255)
	String imageUrl;
	
	@Column(name="address",nullable=false,length=255)
	String address;
	
	@Column(name="grade",nullable=false,length=50)
	String grade;

	
	public Student() {
	}

	public Student(int studentId, String name, String imageUrl, String address, String grade) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.address = address;
		this.grade = grade;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return String.format("Student  [id=%s, name='%s']", studentId, name  );
	}
}
