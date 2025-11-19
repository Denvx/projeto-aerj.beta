package com.example.projeto_aerj.beta.interfaces;

import com.example.projeto_aerj.beta.models.User;

import java.util.List;

public interface UserRepository {
    List<User> searchAll();
    User searchForId(int id);
    void toAdd(User user);
    void delete(int id);
    void toUpdate(int id, User user);
}
