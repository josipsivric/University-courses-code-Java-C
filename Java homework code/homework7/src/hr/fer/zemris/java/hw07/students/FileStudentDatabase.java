package hr.fer.zemris.java.hw07.students;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileStudentDatabase implements StudentDatabase {

	private Path filePath;
	File databaseOnDisk = new File(filePath.toString());

	private List<Student> database = new ArrayList<Student>();

	public FileStudentDatabase(Path filePath) {
		this.filePath = filePath;
		String lineInFile = null;
		String[] parts = new String[3];

		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new BufferedInputStream(
							new FileInputStream(databaseOnDisk)), "UTF-8"));
			try {
				while ((lineInFile = br.readLine()) != null) {
					Scanner s = new Scanner(lineInFile).useDelimiter("\t");
					parts[0] = s.next();
					parts[1] = s.next();
					parts[2] = s.next();

					addStudent(parts[0], parts[1], parts[2]);
				}
			} catch (IOException e) {
				// JoptionPane.showMessage
			}
		} catch (UnsupportedEncodingException e) {
			// JoptionPane.showMessage
		} catch (FileNotFoundException e) {
			// JoptionPane.showMessage
		}
	}

	@Override
	public int size() {
		return database.size();
	}

	@Override
	public Student getStudent(int index) {
		return database.get(index);
	}

	@Override
	public int indexOf(Student student) {
		return database.indexOf(student);
	}

	@Override
	public void remove(int index) {
		database.remove(index);
	}

	@Override
	public boolean addStudent(String studentID, String lastName, String firstName) {

		Student newStudent = new Student(studentID, lastName, firstName);

		return database.add(newStudent);
	}
}
