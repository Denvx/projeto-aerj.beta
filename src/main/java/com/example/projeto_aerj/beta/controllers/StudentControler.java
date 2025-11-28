package com.example.projeto_aerj.beta.controllers;

import com.example.projeto_aerj.beta.entities.person.StudentEntitie;
import com.example.projeto_aerj.beta.facades.StudentFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4/student")
public class StudentControler {

    private final StudentFacade studentFacade;
    @Autowired
    public StudentControler(StudentFacade studentFacade){
        this.studentFacade = studentFacade;
    }

    @GetMapping
    public List<StudentEntitie> getStudents(){
        return studentFacade.searchAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentEntitie> getStudent(@PathVariable int id){
        StudentEntitie studentEntitie = studentFacade.searchForId(id);
        if(studentEntitie != null){
            return ResponseEntity.ok(studentEntitie);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void createStudent(@RequestBody StudentEntitie studentEntitie){
        studentFacade.toAdd(studentEntitie);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        studentFacade.delete(id);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody StudentEntitie studentEntitie){
        studentFacade.toUpdate(id,studentEntitie);
    }
}
