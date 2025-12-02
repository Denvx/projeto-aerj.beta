package com.example.projeto_aerj.beta.interfaces;

import com.example.projeto_aerj.beta.models.Vehicle;

import java.util.List;

public interface VehicleRepository {
    List<Vehicle> searchAll();
    Vehicle searchForId(int id);
    void toAdd(Vehicle vehicle);
    void delete(int id);
    void toUpdate(int id, Vehicle vehicle);
}