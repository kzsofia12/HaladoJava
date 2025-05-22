package hu.unimiskolc.hu.university.controller;

import hu.unimiskolc.hu.university.model.Student;
import hu.unimiskolc.hu.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public void saveStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @PostMapping("/updateStudent")
    public void updateProfessor(@RequestBody Student student) {
        studentService.updateStudent(student);
    }
    @PostMapping("/deleteStudent/{id}")
    public void deleteProfessor(@PathVariable long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/searchStudent/{name}")
    public List<Student> findByName(@PathVariable String name) {
        return studentService.findByName(name);
    }

    @GetMapping("/searchStudent/{major}")
    public List<Student> findByFaculty(@PathVariable String major) {
        return studentService.findByMajor(major);
    }

    @GetMapping("/searchStudent/{id}")
    public Student getProfessor(@PathVariable long id) {
        return studentService.getStudent(id);
    }
}
