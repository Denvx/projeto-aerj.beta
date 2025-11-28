package com.example.projeto_aerj.beta.repository;

import com.example.projeto_aerj.beta.interfaces.StudentJPA;
import com.example.projeto_aerj.beta.interfaces.StudentRepository;
import com.example.projeto_aerj.beta.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryJPA implements StudentRepository {

    private StudentJPA studentJPA;
    @Autowired
    public StudentRepositoryJPA(StudentJPA studentJPA) {
        this.studentJPA = studentJPA;
    }

    @Override
    public List<Student> searchAll() {
        return this.studentJPA.findAll();
    }

    @Override
    public Student searchForId(int id) {
        return this.studentJPA.findById(id).get();
    }

    @Override
    public void toAdd(Student student) {
        this.studentJPA.save(student);
    }

    @Override
    public void delete(int id) {
        this.studentJPA.deleteById(id);
    }

    @Override
    public void toUpdate(int id, Student student) {
        student.setId(id);
        this.studentJPA.save(student);
    }
}
