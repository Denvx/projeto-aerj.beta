package com.example.projeto_aerj.beta.applications;

import com.example.projeto_aerj.beta.entities.auditLog.LogEntitie;
import com.example.projeto_aerj.beta.interfaces.LogRepository;
import com.example.projeto_aerj.beta.models.Log;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogApplication {

    private final LogRepository logRepository;

    public LogApplication(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<LogEntitie> searchAll(){
        List<Log> logs = this.logRepository.searchAll();
        List<LogEntitie> logEntitie = new ArrayList<>();
        for (Log log : logs){
            logEntitie.add(LogEntitie.fromModel(log));
        }
        return logEntitie;
    }

    public LogEntitie searcForId(int id){
        return LogEntitie.fromModel(this.logRepository.searchForId(id));
    }

    public void toAdd(LogEntitie logEntitie){
        Log log = logEntitie.toModel();
        this.logRepository.toAdd(log);

    }

    public void delete(int id){
        this.logRepository.delete(id);
    }

    public void toUpdate(int id, LogEntitie logEntitie){
        Log log = logEntitie.toModel();
        this.logRepository.toUpdate(id,log);
    }
}