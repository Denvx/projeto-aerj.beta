package com.example.projeto_aerj.beta.applications;

import com.example.projeto_aerj.beta.entities.travels.RoutesEntitie;
import com.example.projeto_aerj.beta.interfaces.RoutesRepository;
import com.example.projeto_aerj.beta.models.Routes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteAppication {

    private final RoutesRepository routesRepository;

    public RouteAppication(RoutesRepository routesRepository) {
        this.routesRepository = routesRepository;
    }

    List<RoutesEntitie> searchAll(){
        List<Routes> routes = this.routesRepository.searchAll();
        List<RoutesEntitie> routesEntities = new ArrayList<>();
        for (Routes route : routes){
            routesEntities.add(RoutesEntitie.fromModel(route));
        }
        return routesEntities;
    }

    public RoutesEntitie searcForId(int id){
        return RoutesEntitie.fromModel(this.routesRepository.searchForId(id));
    }

}
