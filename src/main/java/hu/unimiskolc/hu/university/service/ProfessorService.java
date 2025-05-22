package hu.unimiskolc.hu.university.service;

import hu.unimiskolc.hu.university.model.Professor;

import java.util.List;

public interface ProfessorService {
    List<Professor> findByName(String name);
    List<Professor> findByFaculty(String faculty);
    Professor getProfessor(long id);
    void addProfessor(Professor professor);
    void updateProfessor(Professor professor);
    void deleteProfessor(long id);
}
