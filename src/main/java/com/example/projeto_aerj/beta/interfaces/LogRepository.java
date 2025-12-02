package com.example.projeto_aerj.beta.interfaces;

import com.example.projeto_aerj.beta.models.Log;
import java.util.List;

public interface LogRepository {
    List<Log> searchAll();
    Log searchForId(int id);
    void toAdd(Log log);
    void delete(int id);
    void toUpdate(int id, Log log);
}