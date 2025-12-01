package com.example.projeto_aerj.beta.interfaces;

import com.example.projeto_aerj.beta.models.Warning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarningJPA extends JpaRepository<Warning, Integer> {
}
