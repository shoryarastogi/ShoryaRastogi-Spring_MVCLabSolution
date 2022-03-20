package studentDebate.service;

import java.util.List;

import studentDebate.model.Student;

public interface StudentService {
	public List<Student> getStudents();

	public Student findById(int id);

	public void save(Student student);

	public void deleteById(int id);
}
