package hu.unimiskolc.hu.university.persist;

import hu.unimiskolc.hu.university.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByNameContaining(String name);
    List<Course> findAllByProfessorId(long professorId);
    Course findById(long id);
}

