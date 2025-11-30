package com.example.projeto_aerj.beta.repository;

import com.example.projeto_aerj.beta.interfaces.LogJPA;
import com.example.projeto_aerj.beta.interfaces.LogRepository;
import com.example.projeto_aerj.beta.models.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LogRepositoryJPA implements LogRepository {

    private final LogJPA logJPA;
    @Autowired
    public LogRepositoryJPA(LogJPA logJPA) {
        this.logJPA = logJPA;
    }

    @Override
    public List<Log> searchAll() {
        return this.logJPA.findAll();
    }

    @Override
    public Log searchForId(int id) {
        return this.logJPA.findById(id).get();
    }

    @Override
    public void toAdd(Log log) {
        this.logJPA.save(log);
    }

    @Override
    public void delete(int id) {
        this.logJPA.deleteById(id);
    }

    @Override
    public void toUpdate(int id, Log log) {
        log.setId(id);
        this.logJPA.save(log);
    }
}
