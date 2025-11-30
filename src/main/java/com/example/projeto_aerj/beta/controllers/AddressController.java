package com.example.projeto_aerj.beta.controllers;

import com.example.projeto_aerj.beta.entities.address.AddressEntitie;
import com.example.projeto_aerj.beta.facades.AddressFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v4/address")
public class AddressController {

    private final AddressFacade addressFacade;
    @Autowired
    public AddressController(AddressFacade addressFacade) {
        this.addressFacade = addressFacade;
    }

    @GetMapping
    public List<AddressEntitie> getAddresses() {
        return addressFacade.searchAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<AddressEntitie> getAddress(@PathVariable int id) {
        AddressEntitie addressEntitie = addressFacade.searchForId(id);
        if (addressEntitie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(addressEntitie);
    }

    @PostMapping
    public void createAddress(@RequestBody AddressEntitie address) {
        addressFacade.toAdd(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable int id) {
        addressFacade.delete(id);
    }

    @PutMapping("/{id}")
    public void updateAddress(@PathVariable int id, @RequestBody AddressEntitie address) {
        addressFacade.toUpdate(id, address);
    }
}