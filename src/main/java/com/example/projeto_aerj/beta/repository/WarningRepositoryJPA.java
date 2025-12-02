package com.example.projeto_aerj.beta.repository;

import com.example.projeto_aerj.beta.interfaces.WarningJPA;
import com.example.projeto_aerj.beta.interfaces.WarningRepository;
import com.example.projeto_aerj.beta.models.Warning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class WarningRepositoryJPA implements WarningRepository {

    private final WarningJPA warningJPA;
    @Autowired
    public WarningRepositoryJPA(WarningJPA warningJPA) {
        this.warningJPA = warningJPA;
    }

    @Override
    public List<Warning> searchAll() {
        return this.warningJPA.findAll();
    }

    @Override
    public Warning searchForId(int id) {
        return this.warningJPA.findById(id).get();
    }

    @Override
    public void toAdd(Warning warning) {
        this.warningJPA.save(warning);
    }

    @Override
    public void delete(int id) {
        this.warningJPA.deleteById(id);
    }

    @Override
    public void toUpdate(int id, Warning warning) {
        warning.setId(id);
        this.warningJPA.save(warning);
    }
}
