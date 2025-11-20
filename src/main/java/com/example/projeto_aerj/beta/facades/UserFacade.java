package com.example.projeto_aerj.beta.facades;

import com.example.projeto_aerj.beta.applications.UserApplication;
import com.example.projeto_aerj.beta.entities.person.UserEntitie;
import com.example.projeto_aerj.beta.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFacade {

    private final UserApplication userApplication;

    public UserFacade(UserApplication userApplication) {
        this.userApplication = userApplication;
    }

    public List<UserEntitie> searchAll(){
        return this.userApplication.searchAll();
    }

    public UserEntitie searchForId(int id){
        return this.userApplication.searchForId(id);
    }

    public void toAdd (UserEntitie userEntitie){
        this.userApplication.toAdd(userEntitie);
    }

    public void delete(int id){
        this.userApplication.delete(id);
    }

    public void update(int id, UserEntitie userEntitie){
        this.userApplication.toUpdate(id, userEntitie);
    }
}
