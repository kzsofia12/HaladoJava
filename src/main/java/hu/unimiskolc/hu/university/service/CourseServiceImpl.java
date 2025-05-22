package hu.unimiskolc.hu.university.service;

import hu.unimiskolc.hu.university.model.Course;
import hu.unimiskolc.hu.university.persist.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @Override
    public List<Course> findByName(String name) {
        return courseRepository.findByNameContaining(name);
    }

    @Override
    public List<Course> findByProfessor(Long professorId) {
        return courseRepository.findAllByProfessorId(professorId);
    }

    @Override
    public Course findById(long id) {
        return courseRepository.findById(id);
    }

    @Override
    public void modify(Course course) {
        Course cour = courseRepository.findById(course.getId());
        cour.setName(course.getName());
        cour.setDescription(course.getDescription());
        courseRepository.save(cour);
    }
}
