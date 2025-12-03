package com.example.projeto_aerj.beta.applications;

import com.example.projeto_aerj.beta.entities.travels.TravelsEntitie;
import com.example.projeto_aerj.beta.interfaces.TravelsRepository;
import com.example.projeto_aerj.beta.models.Travel;
import com.example.projeto_aerj.beta.repository.LogRepositoryJPA;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TravelApplication {

    private final TravelsRepository travelsRepository;
    private final LogRepositoryJPA logRepositoryJPA;

    public TravelApplication(TravelsRepository travelsRepository, LogRepositoryJPA logRepositoryJPA) {
        this.travelsRepository = travelsRepository;
        this.logRepositoryJPA = logRepositoryJPA;
    }

    public List<TravelsEntitie> searchAll() {
        List<Travel> travels = this.travelsRepository.searchAll();
        List<TravelsEntitie> travelsEntities = new ArrayList<>();
        for (Travel travel : travels) {
            travelsEntities.add(TravelsEntitie.fromModel(travel));
        }
        return travelsEntities;
    }

    public TravelsEntitie searcForId(int id) {
        return TravelsEntitie.fromModel(this.travelsRepository.searchForId(id));
    }

    public void toAdd(TravelsEntitie travelsEntitie){
        Travel travel = travelsEntitie.toModel();
        this.travelsRepository.toAdd(travel);
    }

    public void delete(int id) {
        this.travelsRepository.delete(id);
    }

    public void toUpdate(int id, TravelsEntitie travelsEntitie) {
        Travel travel = travelsEntitie.toModel();
        this.travelsRepository.toUpdate(id, travel);
    }
}