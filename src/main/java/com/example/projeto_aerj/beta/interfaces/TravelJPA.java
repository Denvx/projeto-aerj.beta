package com.example.projeto_aerj.beta.interfaces;

import com.example.projeto_aerj.beta.models.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelJPA extends JpaRepository<Travel, Integer> {
}