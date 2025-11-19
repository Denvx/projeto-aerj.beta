package com.example.projeto_aerj.beta.repository;

import com.example.projeto_aerj.beta.interfaces.UserJPA;
import com.example.projeto_aerj.beta.interfaces.UserRepository;
import com.example.projeto_aerj.beta.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryJPA implements UserRepository { //no repository, eu implemento o interfaçes dispositivo com o CRUD e uso a outra como atributos...

    private final UserJPA userJPA;
    @Autowired
    public UserRepositoryJPA(UserJPA userJPA) {
        this.userJPA = userJPA;
    }

    @Override
    public List<User> searchAll() {
        return this.userJPA.findAll();
    }

    @Override
    public User searchForId(int id) {
        return userJPA.findById(id).get();
    }

    @Override
    public void toAdd(User user) {
        this.userJPA.save(user);
    }

    @Override
    public void delete(int id) {
        this.userJPA.deleteById(id);
    }

    @Override
    public void toUpdate(int id, User user) {
        user.setId(id);
        this.userJPA.save(user);
    }
}
