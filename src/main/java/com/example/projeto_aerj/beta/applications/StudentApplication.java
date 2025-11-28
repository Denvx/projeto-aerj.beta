package com.example.projeto_aerj.beta.applications;

import com.example.projeto_aerj.beta.entities.person.StudentEntitie;
import com.example.projeto_aerj.beta.interfaces.StudentRepository;
import com.example.projeto_aerj.beta.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentApplication {

    private final StudentRepository studentRepository;

    public StudentApplication(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentEntitie> searchAll() {
        List<Student> students = this.studentRepository.searchAll();
        List<StudentEntitie> studentEntities = new ArrayList<>();
        for (Student student : students) {
            studentEntities.add(new StudentEntitie().fromModel(student));
        }
        return studentEntities;
    }

    public StudentEntitie searcForId(int id){
        StudentEntitie studentEntitie = new StudentEntitie().fromModel(this.studentRepository.searchForId(id));
        return studentEntitie;
    }

    public void toAdd(StudentEntitie studentEntitie){
        Student student = studentEntitie.toModel();
        this.studentRepository.toAdd(student);
    }

    public void delete(int id){
        this.studentRepository.delete(id);
    }

    public void toUpdate(int id, StudentEntitie studentEntitie){
        Student student = studentEntitie.toModel();
        this.studentRepository.toUpdate(id, student);
    }
}