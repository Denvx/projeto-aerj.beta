package com.example.projeto_aerj.beta.repository;

import com.example.projeto_aerj.beta.interfaces.TravelJPA;
import com.example.projeto_aerj.beta.interfaces.TravelsRepository;
import com.example.projeto_aerj.beta.models.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TravelRepositoryJPA implements TravelsRepository {

    private TravelJPA travelJPA;
    @Autowired
    public TravelRepositoryJPA(TravelJPA travelJPA) {
        this.travelJPA = travelJPA;
    }

    @Override
    public List<Travel> searchAll() {
        return this.travelJPA.findAll();
    }

    @Override
    public Travel searchForId(int id) {
        return this.travelJPA.findById(id).get();
    }

    @Override
    public void toAdd(Travel travel) {
        this.travelJPA.save(travel);
    }

    @Override
    public void delete(int id) {
        this.travelJPA.deleteById(id);
    }

    @Override
    public void toUpdate(int id, Travel travel) {
        travel.setId(id);
        this.travelJPA.save(travel);
    }
}