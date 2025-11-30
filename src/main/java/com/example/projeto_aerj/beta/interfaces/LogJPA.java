package com.example.projeto_aerj.beta.interfaces;

import com.example.projeto_aerj.beta.models.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogJPA extends JpaRepository<Log, Integer> {
}
