package studentDebate.dao;

import java.util.List;

import studentDebate.model.Student;

public interface StudentDAO {

	public List<Student> getStudents();

	public Student findById(int id);

	public void save(Student student);

	public void deleteById(int id);

}
