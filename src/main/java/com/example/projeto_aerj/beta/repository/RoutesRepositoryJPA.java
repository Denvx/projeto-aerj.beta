package com.example.projeto_aerj.beta.repository;

import com.example.projeto_aerj.beta.interfaces.RoutesJPA;
import com.example.projeto_aerj.beta.interfaces.RoutesRepository;
import com.example.projeto_aerj.beta.models.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class RoutesRepositoryJPA implements RoutesRepository {

    private final RoutesJPA routesJPA;
    @Autowired
    public RoutesRepositoryJPA(RoutesJPA routesJPA) {
        this.routesJPA = routesJPA;
    }

    @Override
    public List<Routes> searchAll() {
        return this.routesJPA.findAll();
    }

    @Override
    public Routes searchForId(int id) {
        return this.routesJPA.findById(id).get();
    }

    @Override
    public void toAdd(Routes routes) {
        this.routesJPA.save(routes);
    }

    @Override
    public void delete(int id) {
        this.routesJPA.deleteById(id);
    }

    @Override
    public void toUpdate(int id, Routes route) {
        route.setId(id);
        this.routesJPA.save(route);
    }
}
