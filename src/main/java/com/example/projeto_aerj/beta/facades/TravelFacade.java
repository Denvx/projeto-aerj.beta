package com.example.projeto_aerj.beta.facades;

import com.example.projeto_aerj.beta.applications.TravelApplication;
import com.example.projeto_aerj.beta.entities.travels.TravelsEntitie;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TravelFacade {

    private final TravelApplication travelApplication;
    public TravelFacade(TravelApplication travelApplication){
        this.travelApplication = travelApplication;
    }

    public List<TravelsEntitie> searchAll(){
        return this.travelApplication.searchAll();
    }

    public TravelsEntitie searchForId(int id){
        return this.travelApplication.searcForId(id);
    }

    public void toAdd(TravelsEntitie travelsEntitie) {
        this.travelApplication.toAdd(travelsEntitie);
    }

    public void delete(int id) {
        this.travelApplication.delete(id);
    }

    public void toUpdate(int id, TravelsEntitie travelsEntitie) {
        this.travelApplication.toUpdate(id, travelsEntitie);
    }
}