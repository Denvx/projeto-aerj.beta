package com.example.projeto_aerj.beta.controllers;

import com.example.projeto_aerj.beta.entities.auditLog.LogEntitie;
import com.example.projeto_aerj.beta.facades.LogFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v4/log")
public class LogController {

    private final LogFacade logFacade;
    @Autowired
    public LogController(LogFacade logFacade){
        this.logFacade = logFacade;
    }

    @GetMapping
    public List<LogEntitie> getLogs(){
        return logFacade.searchAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<LogEntitie> getLog(@PathVariable int id){
        LogEntitie logEntitie = logFacade.searchForId(id);
        if(logEntitie == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(logEntitie);
    }

    @PostMapping("{id}")
    public void createLog(@RequestBody LogEntitie log){
        logFacade.toAdd(log);
    }

    @DeleteMapping("/{id}")
    public void deleteLog(@PathVariable int id){
        logFacade.delete(id);
    }

    @PutMapping("/{id}")
    public void updateLog(@PathVariable int id, @RequestBody LogEntitie log){
        logFacade.toUpdate(id, log);
    }
}
