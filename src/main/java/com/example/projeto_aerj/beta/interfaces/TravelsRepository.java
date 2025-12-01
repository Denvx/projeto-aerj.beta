package com.example.projeto_aerj.beta.interfaces;

import com.example.projeto_aerj.beta.models.Travel;
import java.util.List;

public interface TravelsRepository {
    List<Travel> searchAll();
    Travel searchForId(int id);
    void toAdd(Travel travel);
    void delete(int id);
    void toUpdate(int id, Travel travel);
}