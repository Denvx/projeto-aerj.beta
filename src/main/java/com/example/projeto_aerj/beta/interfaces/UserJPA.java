package com.example.projeto_aerj.beta.interfaces;

import com.example.projeto_aerj.beta.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPA extends JpaRepository<User, Integer> {
}
