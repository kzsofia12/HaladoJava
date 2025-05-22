package hu.unimiskolc.hu.university.service;

import hu.unimiskolc.hu.university.model.Professor;
import hu.unimiskolc.hu.university.persist.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    private ProfessorRepository professorRepository;

    @Autowired
   public ProfessorServiceImpl(ProfessorRepository professorRepository) {
       this.professorRepository = professorRepository;
   }
    @Override
    public List<Professor> findByName(String name) {
        return professorRepository.findAllByNameContaining(name);
    }

    @Override
    public List<Professor> findByFaculty(String faculty) {
        return professorRepository.findAllByFaculty(faculty);
    }

    @Override
    public Professor getProfessor(long id) {
        return professorRepository.findById(id);
    }

    @Override
    public void addProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    @Override
    public void updateProfessor(Professor professor) {
        Professor prof = professorRepository.findById(professor.getId());
        prof.setName(professor.getName());
        prof.setFaculty(professor.getFaculty());
        prof.setEmail(professor.getEmail());
        professorRepository.save(professor);
    }

    @Override
    public void deleteProfessor(long id) {
        professorRepository.deleteById(id);
    }
}
