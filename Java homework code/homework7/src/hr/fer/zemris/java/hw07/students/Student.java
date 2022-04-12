package hr.fer.zemris.java.hw07.students;

public class Student {

	private String studentID;
	private String firstName;
	private String lastName;
	
	public Student(String studentID, String lastName, String firstName) {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getStudentID() {
		return studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
