package com.example.projeto_aerj.beta.controllers;

import com.example.projeto_aerj.beta.entities.notification.WarningsEntitie;
import com.example.projeto_aerj.beta.facades.WarningFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v4/warning")
public class WarningController {

    private final WarningFacade warningFacade;
    @Autowired
    public WarningController(WarningFacade warningFacade) {
        this.warningFacade = warningFacade;
    }

    @GetMapping
    public List<WarningsEntitie> getWarnings() {
        return warningFacade.searchAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<WarningsEntitie> getWarning(@PathVariable int id) {
        WarningsEntitie warningsEntitie = warningFacade.searchForId(id);
        if (warningsEntitie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(warningsEntitie);
    }

    @PostMapping
    public void createWarning(@RequestBody WarningsEntitie warning) {
        warningFacade.toAdd(warning);
    }

    @DeleteMapping("/{id}")
    public void deleteWarning(@PathVariable int id) {
        warningFacade.delete(id);
    }

    @PutMapping("/{id}")
    public void updateWarning(@PathVariable int id, @RequestBody WarningsEntitie warning) {
        warningFacade.toUpdate(id, warning);
    }
}