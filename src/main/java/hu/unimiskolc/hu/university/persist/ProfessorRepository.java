package hu.unimiskolc.hu.university.persist;

import hu.unimiskolc.hu.university.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    List<Professor> findAllByNameContaining(String name);
    List<Professor> findAllByFaculty(String faculty);
    Professor findById(long id);
}
