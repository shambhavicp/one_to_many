package com.ty.one_to_many_student_school_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.one_to_many_student_school_uni.dto.School;
import com.ty.one_to_many_student_school_uni.dto.Student;

public class StudentCRUD {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void saveStudent(Student student) {
		
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();

		entityManager.persist(student);
		
		entityTransaction.commit();
		System.out.println("Inserted ");
		
	}
	
	
	public void updateStudent(int id,Student student) {
		
		
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student receivedStudent=entityManager.find(Student.class, id);
		if(receivedStudent!=null) {
			student.setId(id);
			
			entityTransaction.begin();

			entityManager.merge(student);
			
			entityTransaction.commit();		
			
		}
		
		else {
			
			System.out.println("Student id not exist");
		}
		
	}
	
	public void deleteStudent(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student student=entityManager.find(Student.class,id);
		
		if(student!=null) {
			student.setId(id);
			
			entityTransaction.begin();
			entityManager.remove(student);

			entityTransaction.commit();
			
		}
		else {
			System.out.println("Deleted successfully");
		}
			
	}
	
	public Student getStudentById(int id) {
		EntityManager entityManager=getEntityManager();
		
		
		Student student=entityManager.find(Student.class,id);
		return student;
		
	}

	public List<Student> getAllStudent() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select s from Student s");
		List<Student> list=query.getResultList();
		return list;
		
		
	}
	
	

}
