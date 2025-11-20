package com.example.projeto_aerj.beta.controllers;

import com.example.projeto_aerj.beta.entities.person.UserEntitie;
import com.example.projeto_aerj.beta.facades.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserControler {

    private final UserFacade userFacade;
    @Autowired
    public UserControler(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping
    public List<UserEntitie> getUser(){
        return userFacade.searchAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<UserEntitie> getUserId(@PathVariable int id){
            UserEntitie userEntitie = userFacade.searchForId(id);
        if (userEntitie != null){
            return ResponseEntity.ok(userEntitie);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void createUser(@RequestBody UserEntitie userEntitie){
        userFacade.toAdd(userEntitie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        userFacade.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UserEntitie userEntitie){
        userFacade.update(id, userEntitie);
    }
}
