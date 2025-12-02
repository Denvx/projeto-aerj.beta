package com.example.projeto_aerj.beta.repository;

import com.example.projeto_aerj.beta.interfaces.VehicleJPA;
import com.example.projeto_aerj.beta.interfaces.VehicleRepository;
import com.example.projeto_aerj.beta.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class VehiclesRepositoryJPA implements VehicleRepository {

    private VehicleJPA vehicleJPA;
    @Autowired
    public VehiclesRepositoryJPA(VehicleJPA vehicleJPA) {
        this.vehicleJPA = vehicleJPA;
    }

    @Override
    public List<Vehicle> searchAll() {
        return this.vehicleJPA.findAll();
    }

    @Override
    public Vehicle searchForId(int id) {
        return this.vehicleJPA.findById(id).get();
    }

    @Override
    public void toAdd(Vehicle vehicle) {
        this.vehicleJPA.save(vehicle);
    }

    @Override
    public void delete(int id) {
        this.vehicleJPA.deleteById(id);
    }

    @Override
    public void toUpdate(int id, Vehicle vehicle) {
        vehicle.setId(id);
        this.vehicleJPA.save(vehicle);
    }
}