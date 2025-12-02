package com.example.projeto_aerj.beta.controllers;

import com.example.projeto_aerj.beta.entities.travels.TravelsEntitie;
import com.example.projeto_aerj.beta.facades.TravelFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4/travel")
public class TravelController {
    
    private final TravelFacade travelFacade;
    @Autowired
    public TravelController(TravelFacade travelFacade) {
        this.travelFacade = travelFacade;
    }
    
    @GetMapping
    public List<TravelsEntitie> getTravels(){
        return travelFacade.searchAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<TravelsEntitie> getTravel(@PathVariable int id){
        TravelsEntitie travelsEntitie = travelFacade.searchForId(id);
        if (travelsEntitie == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(travelsEntitie);
    }

    @PostMapping
    public void createTravel(@RequestBody TravelsEntitie travelsEntitie){
        travelFacade.toAdd(travelsEntitie);
    }

    @DeleteMapping("/{id}")
    public void deleteTravel(@PathVariable int id){
        travelFacade.delete(id);
    }

    @PutMapping("/{id}")
    public void updateTravel(@PathVariable int id, @RequestBody TravelsEntitie travelsEntitie){
        travelFacade.toUpdate(id, travelsEntitie);
    }
}