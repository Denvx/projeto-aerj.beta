package com.example.projeto_aerj.beta.interfaces;

import com.example.projeto_aerj.beta.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressJPA extends JpaRepository<Address, Integer> {
}