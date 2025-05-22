package hu.unimiskolc.hu.university.service;

import hu.unimiskolc.hu.university.model.Course;

import java.util.List;

public interface CourseService  {
    List<Course> findByName(String name);
    List<Course> findByProfessor(Long professorId);
    Course findById(long id);
    void modify(Course course);
}
