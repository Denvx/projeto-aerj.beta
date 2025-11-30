package com.example.projeto_aerj.beta.applications;

import com.example.projeto_aerj.beta.entities.person.StudentEntitie;
import com.example.projeto_aerj.beta.interfaces.LogRepository;
import com.example.projeto_aerj.beta.interfaces.StudentRepository;
import com.example.projeto_aerj.beta.models.Log;
import com.example.projeto_aerj.beta.models.Student;
import com.example.projeto_aerj.beta.repository.LogRepositoryJPA;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentApplication {

    private final StudentRepository studentRepository;
    private final LogRepositoryJPA logRepository;

    public StudentApplication(StudentRepository studentRepository, LogRepositoryJPA logRepository) {
        this.studentRepository = studentRepository;
        this.logRepository = logRepository;
    }

    public List<StudentEntitie> searchAll() {
        List<Student> students = this.studentRepository.searchAll();
        List<StudentEntitie> studentEntities = new ArrayList<>();
        for (Student student : students) {
            studentEntities.add(StudentEntitie.fromModel(student));
        }
        return studentEntities;
    }

    public StudentEntitie searcForId(int id){
        return StudentEntitie.fromModel(this.studentRepository.searchForId(id));
    }

    public void toAdd(StudentEntitie studentEntitie){
        Student student = studentEntitie.toModel();
        this.studentRepository.toAdd(student);

        Log log = new Log();
        log.setAcao("CRIACAO_STUDENT");
        log.setStudentId(student.getId());
        logRepository.toAdd(log);
    }

    public void delete(int id){
        this.studentRepository.delete(id);
    }

    public void toUpdate(int id, StudentEntitie studentEntitie){
        Student student = studentEntitie.toModel();
        this.studentRepository.toUpdate(id, student);
    }
}