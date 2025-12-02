package com.example.projeto_aerj.beta.interfaces;

import com.example.projeto_aerj.beta.models.Warning;
import java.util.List;

public interface WarningRepository {

    List<Warning> searchAll();
    Warning searchForId(int id);
    void toAdd(Warning warning);
    void delete(int id);
    void toUpdate(int id, Warning warning);
}
