package com.example.projeto_aerj.beta.facades;

import com.example.projeto_aerj.beta.applications.StudentApplication;
import com.example.projeto_aerj.beta.applications.UserApplication;
import com.example.projeto_aerj.beta.entities.person.StudentEntitie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentFacade {

    private final StudentApplication studentApplication;

    public StudentFacade(StudentApplication studentApplication) {
        this.studentApplication = studentApplication;
    }

    public List<StudentEntitie> searchAll(){
        return this.studentApplication.searchAll();
    }

    public StudentEntitie searchForId(int id){
        return this.studentApplication.searcForId(id);
    }

    public void toAdd (StudentEntitie studentEntitie){
        this.studentApplication.toAdd(studentEntitie);
    }

    public void delete(int id){
        this.studentApplication.delete(id);
    }

    public void toUpdate (int id, StudentEntitie studentEntitie){
        this.studentApplication.toUpdate(id, studentEntitie);
    }
}
