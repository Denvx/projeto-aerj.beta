package com.example.projeto_aerj.beta.controllers;

import com.example.projeto_aerj.beta.entities.vehicles.VehiclesEntitie;
import com.example.projeto_aerj.beta.facades.VehicleFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4/vehicle")
public class VehicleController {

    private VehicleFacade vehicleFacade;
    @Autowired
    public VehicleController(VehicleFacade vehicleFacade) {
        this.vehicleFacade = vehicleFacade;
    }

    @GetMapping
    public List<VehiclesEntitie> getVehicles() {
        return vehicleFacade.searchAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<VehiclesEntitie> getVehicle(@PathVariable int id) {
        VehiclesEntitie vehicles = vehicleFacade.searchForId(id);
        if (vehicles == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicles);
    }

    @PostMapping
    public void createVehicle(@RequestBody VehiclesEntitie vehicle) {
        vehicleFacade.toAdd(vehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable int id) {
        vehicleFacade.delete(id);
    }

    @PutMapping("/{id}")
    public void updateVehicle(@PathVariable int id, @RequestBody VehiclesEntitie vehicle) {
        vehicleFacade.toUpdate(id, vehicle);
    }
}