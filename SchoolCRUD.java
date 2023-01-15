package com.ty.one_to_many_student_school_uni.dao;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.one_to_many_student_school_uni.dto.School;
import com.ty.one_to_many_student_school_uni.dto.Student;


public class SchoolCRUD {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void saveSchool(School school) {
		
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		List<Student> list=school.getList();
		for(Student student:list) {
			entityManager.persist(student);
		}
		entityManager.persist(school);
		
		entityTransaction.commit();
		
	}
	
	
	public void updateSchool(int id, School school) {
		
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
	
		School receivedSchool=entityManager.find(School.class,id);
		
		if(receivedSchool!=null) {
			receivedSchool.setSid(id);
			receivedSchool.setList(school.getList());
			
			entityTransaction.begin();
			entityManager.merge(school);

			entityTransaction.commit();
			System.out.println("Updated successfully");
			
		}
		else {
			System.out.println("this School id is not present");
		}
			
	}
	
	public void deleteSchool(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		School school=entityManager.find(School.class,id);
		
		entityTransaction.begin();
		
		if(school!=null) {
			school.setSid(id);
			school.setList(school.getList());
			
			
			entityManager.remove(school);

			entityTransaction.commit();
			
		}
		else {
			System.out.println("Deleted successfully");
		}
			
	}
	
	public School getSchoolById(int id) {
		EntityManager entityManager=getEntityManager();
		
		
		School school=entityManager.find(School.class,id);
		return school;
		
	}

	public List<School> getAllSchool() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select s from School s");
		List<School> list=query.getResultList();
		return list;
		
		
	}
	
	
}
