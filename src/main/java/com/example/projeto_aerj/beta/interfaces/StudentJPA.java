package com.example.projeto_aerj.beta.interfaces;

import com.example.projeto_aerj.beta.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJPA extends JpaRepository<Student, Integer> {
}
