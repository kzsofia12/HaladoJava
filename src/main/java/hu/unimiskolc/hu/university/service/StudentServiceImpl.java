package hu.unimiskolc.hu.university.service;

import hu.unimiskolc.hu.university.model.Professor;
import hu.unimiskolc.hu.university.model.Student;
import hu.unimiskolc.hu.university.persist.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findByNameContaining(name);
    }

    @Override
    public List<Student> findByMajor(String major) {
        return studentRepository.findByMajor(major);
    }

    @Override
    public Student getStudent(long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        Student stud = studentRepository.findById(student.getId());
        stud.setName(student.getName());
        stud.setMajor(student.getMajor());
        stud.setEmail(student.getEmail());
        studentRepository.save(stud);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }
}
