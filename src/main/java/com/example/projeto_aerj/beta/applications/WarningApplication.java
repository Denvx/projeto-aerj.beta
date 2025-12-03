package com.example.projeto_aerj.beta.applications;

import com.example.projeto_aerj.beta.entities.notification.WarningsEntitie;
import com.example.projeto_aerj.beta.interfaces.WarningRepository;
import com.example.projeto_aerj.beta.models.Warning;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarningApplication {

    private final WarningRepository warningRepository;

    public WarningApplication(WarningRepository warningRepository){
        this.warningRepository = warningRepository;
    }

    public List<WarningsEntitie> searchAll(){
        List<Warning> warnings = this.warningRepository.searchAll();
        List<WarningsEntitie> warningsEntities = new ArrayList<>();
        for (Warning warning : warnings){
            warningsEntities.add(WarningsEntitie.fromModel(warning));
        }
        return warningsEntities;
    }

    public WarningsEntitie searcForId(int id){
        return WarningsEntitie.fromModel(this.warningRepository.searchForId(id));
    }

    public void toAdd(WarningsEntitie warningsEntitie){
        Warning warning = warningsEntitie.toModel();
        this.warningRepository.toAdd(warning);
    }

    public void delete(int id){
        this.warningRepository.delete(id);
    }

    public void toUpdate(int id, WarningsEntitie warningsEntitie){
        Warning warning = warningsEntitie.toModel();
        this.warningRepository.toUpdate(id, warning);
    }
}
