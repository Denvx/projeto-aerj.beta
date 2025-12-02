package com.example.projeto_aerj.beta.applications;

import com.example.projeto_aerj.beta.entities.vehicles.VehiclesEntitie;
import com.example.projeto_aerj.beta.interfaces.VehicleRepository;
import com.example.projeto_aerj.beta.models.Vehicle;
import com.example.projeto_aerj.beta.repository.LogRepositoryJPA;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleApplication {

    private final VehicleRepository vehicleRepository;

    public VehicleApplication(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<VehiclesEntitie> searchAll() {
        List<Vehicle> vehicles = vehicleRepository.searchAll();
        List<VehiclesEntitie>  vehiclesEntities = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            vehiclesEntities.add(VehiclesEntitie.fromModel(vehicle));
        }
        return vehiclesEntities;
    }

    public VehiclesEntitie searcForId(int id){
        return VehiclesEntitie.fromModel(this.vehicleRepository.searchForId(id));
    }

    public void toAdd(VehiclesEntitie vehiclesEntitie) {
        Vehicle vehicle = vehiclesEntitie.toModel();
        this.vehicleRepository.toAdd(vehicle);
    }

    public void delete(int id){
        this.vehicleRepository.delete(id);
    }

    public void toUpdate(int id, VehiclesEntitie vehiclesEntitie) {
        Vehicle vehicle = vehiclesEntitie.toModel();
        this.vehicleRepository.toUpdate(id, vehicle);
    }
}
