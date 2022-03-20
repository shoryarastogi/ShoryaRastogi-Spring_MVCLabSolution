package studentDebate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import studentDebate.model.Student;
import studentDebate.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/entries")
	public String getEntries(Model model) {
		List<Student> students = studentService.getStudents();
		model.addAttribute("students",students);
		return "list-entries";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("student",student);
		return "add-student-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, Model theModel) {
		Student student = studentService.findById(id);
		theModel.addAttribute("student",student);
		return "add-student-form";
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("department") String department, @RequestParam("country") String country) {
		
		Student student;
		
		if(id != 0) {
			student = studentService.findById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		}
		else {
			student = new Student(name, department, country);
		}
		studentService.save(student);
		
		return "redirect:/student/entries";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int id) {
		studentService.deleteById(id);
		return "redirect:/student/entries";
	}
}
