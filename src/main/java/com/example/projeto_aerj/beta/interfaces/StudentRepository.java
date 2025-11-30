package com.example.projeto_aerj.beta.interfaces;

import com.example.projeto_aerj.beta.models.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> searchAll();
    Student searchForId(int id);
    void toAdd(Student student);
    void delete(int id);
    void toUpdate(int id, Student student);
}