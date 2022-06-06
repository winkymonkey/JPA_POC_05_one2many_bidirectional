package org.example.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.example.jpa.domain.Branch;
import org.example.jpa.domain.Student;


public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			emf = Persistence.createEntityManagerFactory("jbd-pu");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			Branch branch = new Branch();
			branch.setBranchShortName("CSE");
			branch.setBranchName("Computer Science and Engineering");
			branch.setDescription("CSE department offers courses");
			
			List<Student> students = new ArrayList<Student>();
			branch.setStudents(students);
			branch.addStudent(getStudent1());
			branch.addStudent(getStudent2());
			
			entityManager.persist(branch);
			transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			entityManager.close();
			emf.close();
		}
	}

	private static Student getStudent1() {
		Student student = new Student();
		student.setFirstName("Peter");
		student.setLastName("Milanovich");
		student.setContactNo("+1-408-575-1317");
		return student;
	}

	private static Student getStudent2() {
		Student student = new Student();
		student.setFirstName("Rosy");
		student.setLastName("Larsen");
		student.setContactNo("+1-408-575-1219");
		return student;
	}
}
