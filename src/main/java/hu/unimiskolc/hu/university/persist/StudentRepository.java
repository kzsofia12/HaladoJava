package hu.unimiskolc.hu.university.persist;

import hu.unimiskolc.hu.university.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNameContaining(String name);
    Student findById(long id);
    List<Student> findByMajor(String major);
}
