package com.ayaancode.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ayaancode.cruddemo.dao.StudentDAO;
import com.ayaancode.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean // for commaand line appliction
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			createMultipleStudent(studentDAO); 

			// readStudent(studentDAO);
			// queryForStudent(studentDAO);
			// queryForStudentByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudent(studentDAO);

		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {

		System.out.println("Deleting All the students...");
		int numRowDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count : " +numRowDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		//retrieve student based on the id : primary key
		int studentId = 2;
		System.out.println("Deleting Student with id : " +studentId);
		studentDAO.delete(studentId);


	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id  : primary key
		int studentId = 3;
		System.out.println("Getting Student with Student Id : " +studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change the firstName
		System.out.println("Updating the Student...");
		myStudent.setFirstName("Imran");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated Student...." + myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {

		// get a list of students
		System.out.println("Querying the Students with LastName...");
		List<Student> theStudents = studentDAO.findByLastName("Alam");

		// display the list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		// get a list of student
		System.out.println("Querying the Students...");
		List<Student> theStudents = studentDAO.findAll();

		// display the list of student
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating the new student . . .");
		Student tempStudent = new Student("Sameer", "Alam", "sam@gmail.com");

		// save the student
		System.out.println("Saving the student . . .");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theID = tempStudent.getId();
		System.out.println("Saved Student--Generated ID : " + theID);

		// retrieve student based on the primary key
		System.out.println("Retrieving student with ID : " + theID);
		Student myStudent = studentDAO.findById(theID);

		// display student
		System.out.println("Found the student : " + myStudent);

	}

	public void createMultipleStudent(StudentDAO studentDAO) {

		// creating multiple students
		System.out.println("Creating 3 Student objects. . . ");
		Student tempStudent1 = new Student("Harsh", "Singh", "harsh00@gmail.com");
		Student tempStudent2 = new Student("John", "Doe", "johnnydoe@gmail.com");
		Student tempStudent3 = new Student("Alice", "Smith", "alicesmith@gmail.com");

		// save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

		// creaate the Student object
		System.out.println("Creating new Student Object . . . ");
		Student tempStudent = new Student("Ayaan", "Alam", "ayaancode.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("\n\n Saved Student Id , Generated ID : " + tempStudent.getId());
	}

}
