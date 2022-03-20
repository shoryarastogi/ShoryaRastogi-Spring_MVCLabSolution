package studentDebate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import studentDebate.dao.StudentDAO;
import studentDebate.model.Student;

@Service
@EnableTransactionManagement
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}

	@Override
	@Transactional
	public Student findById(int id) {
		return studentDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Student student) {
		studentDAO.save(student);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		studentDAO.deleteById(id);
	}
}
