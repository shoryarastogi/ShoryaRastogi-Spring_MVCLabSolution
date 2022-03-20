package studentDebate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import studentDebate.model.Student;

@Repository
@EnableTransactionManagement
public class StudentDAOImpl implements StudentDAO {

	private Session session;
	private SessionFactory sessionFactory;
	
	@Autowired
	public StudentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;		
		try {
			this.session = this.sessionFactory.getCurrentSession();
		}
		catch(HibernateException e) {
			this.session = this.sessionFactory.openSession();
		}
	}
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		Transaction tx = this.session.beginTransaction();
		List<Student> students = this.session.createQuery("from Student").list();
		tx.commit();
		return students;
	}

	@Override
	@Transactional
	public Student findById(int id) {
		Transaction tx = this.session.beginTransaction();
		Student student = this.session.get(Student.class, id);
		tx.commit();
		return student;
	}

	@Override
	@Transactional
	public void save(Student student) {
		Transaction tx = this.session.beginTransaction();
		this.session.saveOrUpdate(student);
		tx.commit();		
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Transaction tx = this.session.beginTransaction();
		Student student = this.session.get(Student.class, id);
		session.delete(student);
		tx.commit();		
	}

}
