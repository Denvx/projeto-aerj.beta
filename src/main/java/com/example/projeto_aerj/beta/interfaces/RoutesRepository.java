package com.example.projeto_aerj.beta.interfaces;

import com.example.projeto_aerj.beta.models.Routes;

import java.util.List;

public interface RoutesRepository {
    List<Routes> searchAll();
    Routes searchForId(int id);
    void toAdd(Routes routes);
    void delete(int id);
    void toUpdate(int id, Routes routes);
}
