package com.example.projeto_aerj.beta.applications;

import com.example.projeto_aerj.beta.entities.person.UserEntitie;
import com.example.projeto_aerj.beta.interfaces.UserRepository;
import com.example.projeto_aerj.beta.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserApplication {

    private final UserRepository userRepository;

    public UserApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntitie> searchAll(){

        List<User> users = this.userRepository.searchAll();
        List<UserEntitie> userEntities = new ArrayList<>();
        for(User user: users){
            userEntities.add(new UserEntitie().fromUser(user));
        }
        return userEntities;
    }


    public UserEntitie searchForId(int id){
        UserEntitie userEntitie = new UserEntitie().fromUser(this.userRepository.searchForId(id));
        return userEntitie;
    }

    public void toAdd(UserEntitie userEntitie){
        User user = userEntitie.toUser();
        this.userRepository.toAdd(user);
    }

    public void delete(int id){
        this.userRepository.delete(id);
    }

    public void toUpdate(int id, UserEntitie userEntitie){
        User user = userEntitie.toUser();
        this.userRepository.toUpdate(id, user);
    }
}