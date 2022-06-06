package org.example.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.example.jpa.domain.Branch;
import org.example.jpa.domain.Student;


public class BiDirectionalTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			emf = Persistence.createEntityManagerFactory("jbd-pu");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			Branch branch = entityManager.find(Branch.class, new Integer(1));
			System.err.println("================= From Branch ===================");
			System.err.println("Branch Id: " + branch.getBranchId());
			System.err.println("Branch Name: " + branch.getBranchName());
			System.err.println("[1]First Name: " + branch.getStudents().get(0).getFirstName());
			System.err.println("[1]Last Name: " + branch.getStudents().get(0).getLastName());
			System.err.println("[2]First Name: " + branch.getStudents().get(1).getFirstName());
			System.err.println("[2]Last Name: " + branch.getStudents().get(1).getLastName());
			
			Student student1 = entityManager.find(Student.class, new Integer(1));
			System.err.println("================= From Student 1 ===================");
			System.err.println("FirstName: " + student1.getFirstName());
			System.err.println("Last name: " + student1.getLastName());
			System.err.println("Branch Id: " + student1.getBranch().getBranchId());
			System.err.println("Branch Name: " + student1.getBranch().getBranchName());
			
			Student student2 = entityManager.find(Student.class, new Integer(2));
			System.err.println("================= From Student 2 ===================");
			System.err.println("FirstName: " + student2.getFirstName());
			System.err.println("Last name: " + student2.getLastName());
			System.err.println("Branch Id: " + student2.getBranch().getBranchId());
			System.err.println("Branch Name: " + student2.getBranch().getBranchName());
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			entityManager.close();
			emf.close();
		}
	}
}
