package hr.fer.zemris.java.hw07.students;

public interface StudentDatabase {

	int size();

	Student getStudent(int index);

	int indexOf(Student student);

	void remove(int index);

	boolean addStudent(String studentID, String lastName, String firstName);
}
