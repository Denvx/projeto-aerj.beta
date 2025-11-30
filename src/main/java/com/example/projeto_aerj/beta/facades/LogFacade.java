package com.example.projeto_aerj.beta.facades;

import com.example.projeto_aerj.beta.applications.LogApplication;
import com.example.projeto_aerj.beta.entities.auditLog.LogEntitie;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LogFacade {

    private final LogApplication logApplication;

    public LogFacade(LogApplication logApplication) {
        this.logApplication = logApplication;
    }

    public List<LogEntitie> searchAll(){
        return this.logApplication.searchAll();
    }

    public LogEntitie searchForId(int id){
        return this.logApplication.searcForId(id);
    }

    public void toAdd(LogEntitie log){
        this.logApplication.toAdd(log);
    }

    public void delete(int id){
        this.logApplication.delete(id);
    }

    public void toUpdate(int id, LogEntitie log){
        this.logApplication.toUpdate(id, log);
    }
}
