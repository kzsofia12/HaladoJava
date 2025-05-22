package hu.unimiskolc.hu.university.controller;

import hu.unimiskolc.hu.university.model.Course;
import hu.unimiskolc.hu.university.model.Professor;
import hu.unimiskolc.hu.university.service.CourseService;
import hu.unimiskolc.hu.university.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/updateCourse")
    public void updateCourse(@RequestBody Course course) {
        courseService.modify(course);
    }

    @GetMapping("/searchCourse/{id}")
    public Course getCourse(@PathVariable long id) {
        return courseService.findById(id);
    }
    @GetMapping("/searchCourse/{professor_id}")
    public List<Course> getCourseByProfessor(@PathVariable long professor_id) {
        return courseService.findByProfessor(professor_id);
    }

    @GetMapping("/searchCourse/{name}")
    public List<Course> getCourseByProfessor(@PathVariable String name) {
        return courseService.findByName(name);
    }

}
