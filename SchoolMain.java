package com.ty.one_to_many_student_school_uni.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.one_to_many_student_school_uni.dao.SchoolCRUD;
import com.ty.one_to_many_student_school_uni.dao.StudentCRUD;
import com.ty.one_to_many_student_school_uni.dto.School;
import com.ty.one_to_many_student_school_uni.dto.Student;

public class SchoolMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		
		SchoolCRUD schoolCRUD=new SchoolCRUD();
		StudentCRUD studentCRUD=new StudentCRUD();
		
		
		School school=new School();
		
		Scanner scanner=new Scanner(System.in);
		boolean exit=true;
		
		
		do {
			
			System.out.println("do you want 1.save school \n 2.add student \n 3.update student \n 4.remove student \n 5.get student by id \n 6.get all \n 7.exit");
			System.out.println("enter ur choice");
			int choose = scanner.nextInt();
			switch (choose) {
			case 1: {

				System.out.println("enter the id");
				int id = scanner.nextInt();

				System.out.println("enter the name");
				String name = scanner.next();

				System.out.println("enter the address");
				String address = scanner.next();
				
				System.out.println("enter the fees");
				double fees= scanner.nextDouble();

				school.setSid(id);
				school.setName(name);
				school.setAddress(address);
				school.setFees(fees);
				
				boolean repeat = true;

				do {

					System.out.println("do you want to add student details click on 1.to add 2.exit");

					int select = scanner.nextInt();
					switch (select) {

					case 1: {
						System.out.println("enter the id to be inserted");
						int student_id = scanner.nextInt();

						System.out.println("enter the student name :");
						String student_name = scanner.next();

						System.out.println("enter the address");
						String student_address= scanner.next();

						System.out.println("enter the marks ");
						int student_marks = scanner.nextInt();


						Student student=new Student();
						student.setId(student_id);
						student.setName(student_name);
						student.setAddress(student_address);
						student.setMarks(student_marks);
						
						List<Student> list = new ArrayList<Student>();
						
						list.add(student);
						school.setList(list);

						schoolCRUD.saveSchool(school);

						//studentCRUD.saveStudent(student);
						
						
						System.out.println("inserted");

					}
					break;

					case 2: {
						repeat = false;

						System.out.println("Thank you");

					}
					break;

					default:System.out.println("Invalid choice");

					}

				} while (repeat);
				
				

			}
			break;

			case 2: {
				boolean repeat = true;

				do {
					System.out.println("do you want to add student details click on 1.to add 2.exit");
					int select = scanner.nextInt();

					switch (select) {
					case 1: {
						System.out.println("enter the school id");
						int id = scanner.nextInt();

						System.out.println("enter the id to be inserted");
						int student_id = scanner.nextInt();

						System.out.println("enter the student name :");
						String student_name = scanner.next();

						System.out.println("enter the address");
						String student_address= scanner.next();

						System.out.println("enter the marks ");
						int student_marks = scanner.nextInt();


						Student student=new Student();
						student.setId(student_id);
						student.setName(student_name);
						student.setAddress(student_address);
						student.setMarks(student_marks);

						studentCRUD.saveStudent(student);

						List<Student> list = new ArrayList<Student>();
						list.add(student);
						//School school=new School();
		
						school.setList(list);

						System.out.println("inserted");

					}
					break;

					case 2: {
						repeat = false;

						System.out.println("Thank you");

					}
					break;

					default:System.out.println("Invalid choice");

					}

				} while (repeat);

			}
			break;

			case 3: {

				boolean choose1 = true;

				do {

					System.out.println("do you want to update 1.school 2.student 3.exit");

					int key = scanner.nextInt();

					switch (key) {

					case 1: {

						System.out.println("enter the id to be updated");
						int school_id = scanner.nextInt();

						System.out.println("enter the name");
						String name = scanner.next();

						System.out.println("enter the address");
						String address = scanner.next();
						
						//School school=new School();
						school.setSid(school_id);
						school.setName(name);
						school.setAddress(address);
						
						schoolCRUD.updateSchool(school_id, school);

		

					}
					break;

					case 2: {

						System.out.println("enter the student id to be updated");
						int student_id = scanner.nextInt();

						System.out.println("enter the student name :");
						String student_name = scanner.next();

						System.out.println("enter the address");
						String student_address= scanner.next();

						System.out.println("enter the marks ");
						int student_marks = scanner.nextInt();

						Student student = new Student();
					
						student.setId(student_id);
						student.setName(student_name);
						student.setAddress(student_address);
						student.setMarks(student_marks);
						studentCRUD.updateStudent(student_id, student);

						

					}
					break;

					case 3: {
						choose1 = false;

						System.out.println("Thank you");

					}
					break;

					default:System.out.println("Invalid choice");

					}

				} while (choose1);

			}
			break;

			case 4: {

				boolean exit1 = true;

				do {

					System.out.println("do you want to remove 1.School 2.Student 3.exit");
					System.out.println("choose any one");

					int key = scanner.nextInt();
					switch (key) {

					case 1: {
						System.out.println("enter the school id to be removed");
						int school_id = scanner.nextInt();
						
						//School school=new School();
						school.setSid(school_id);
						schoolCRUD.deleteSchool(school_id);


					}
					break;

					case 2: {
						System.out.println("enter the student id to be removed");
						int student_id = scanner.nextInt();
						Student student= new Student();
						studentCRUD.deleteStudent(student_id);
					
					}
					break;

			
					case 3: {
						exit1 = false;

						System.out.println("=========THANK YOU============");

					}
					break;

					default: {
						System.out.println("Invalid");

					}
					break;

					}

				} while (exit1);

			}
			break;

			case 5: {

				System.out.println("enter the id to get the details");

				int school_id = scanner.nextInt();
				//School school=new School();
				school.setSid(school_id);
				schoolCRUD.getSchoolById(school_id);

			}
				break;

			case 6: {
				schoolCRUD.getAllSchool();

			}
			break;

			case 7: {
				exit = false;

				System.out.println("THANK YOU");

			}
			break;

			default:System.out.println("Invalid choice");

			}	
			
			
		}while(exit);
		
	}

}
