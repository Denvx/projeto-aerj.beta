package com.example.projeto_aerj.beta.facades;

import com.example.projeto_aerj.beta.applications.VehicleApplication;
import com.example.projeto_aerj.beta.entities.vehicles.VehiclesEntitie;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleFacade {

    private final VehicleApplication vehicleApplication;
    public VehicleFacade(VehicleApplication vehicleApplication) {
        this.vehicleApplication = vehicleApplication;
    }

    public List<VehiclesEntitie> searchAll(){
        return this.vehicleApplication.searchAll();
    }

    public VehiclesEntitie searchForId(int id){
        return this.vehicleApplication.searcForId(id);
    }

    public void toAdd(VehiclesEntitie vehicle){
        this.vehicleApplication.toAdd(vehicle);
    }

    public void delete(int id){
        this.vehicleApplication.delete(id);
    }

    public void toUpdate(int id, VehiclesEntitie vehicle){
        this.vehicleApplication.toUpdate(id, vehicle);
    }
}