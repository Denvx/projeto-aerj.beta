package com.example.projeto_aerj.beta.facades;

import com.example.projeto_aerj.beta.applications.WarningApplication;
import com.example.projeto_aerj.beta.entities.notification.WarningsEntitie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarningFacade {

    private final WarningApplication warningApplication;
    public WarningFacade(WarningApplication warningApplication){
        this.warningApplication = warningApplication;
    }

    public List<WarningsEntitie> searchAll(){
        return this.warningApplication.searchAll();
    }

    public WarningsEntitie searchForId(int id){
        return this.warningApplication.searcForId(id);
    }

    public void toAdd(WarningsEntitie warningsEntitie){
        this.warningApplication.toAdd(warningsEntitie);
    }

    public void delete(int id){
        this.warningApplication.delete(id);
    }

    public void toUpdate(int id, WarningsEntitie warningsEntitie){
        this.warningApplication.toUpdate(id, warningsEntitie);
    }
}
