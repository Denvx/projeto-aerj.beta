package com.example.projeto_aerj.beta.interfaces;

import com.example.projeto_aerj.beta.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleJPA extends JpaRepository<Vehicle, Integer> {
}