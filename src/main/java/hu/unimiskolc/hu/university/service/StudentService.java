package hu.unimiskolc.hu.university.service;

import hu.unimiskolc.hu.university.model.Professor;
import hu.unimiskolc.hu.university.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findByName(String name);
    List<Student> findByMajor(String major);
    Student getStudent(long id);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(long id);
}
