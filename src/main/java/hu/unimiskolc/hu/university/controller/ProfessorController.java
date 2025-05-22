package hu.unimiskolc.hu.university.controller;

import hu.unimiskolc.hu.university.model.Professor;
import hu.unimiskolc.hu.university.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/addProfessor")
    public void saveProfessor(@RequestBody Professor professor) {
        professorService.addProfessor(professor);
    }

    @PostMapping("/updateProfessor")
    public void updateProfessor(@RequestBody Professor professor) {
        professorService.updateProfessor(professor);
    }
    @PostMapping("/deleteProfessor/{id}")
    public void deleteProfessor(@PathVariable long id) {
        professorService.deleteProfessor(id);
    }

    @GetMapping("/searchProfessor/{name}")
    public List<Professor> findByName(@PathVariable String name) {
        return professorService.findByName(name).stream().toList();
    }

    @GetMapping("/searchProfessor/{faculty}")
    public List<Professor> findByFaculty(@PathVariable String faculty) {
        return professorService.findByFaculty(faculty);
    }

    @GetMapping("/searchProfessor/{id}")
    public Professor getProfessor(@PathVariable long id) {
        return professorService.getProfessor(id);
    }


}
