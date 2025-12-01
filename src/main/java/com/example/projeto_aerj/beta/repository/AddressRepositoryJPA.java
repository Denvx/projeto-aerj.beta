package com.example.projeto_aerj.beta.repository;

import com.example.projeto_aerj.beta.interfaces.AddressJPA;
import com.example.projeto_aerj.beta.interfaces.AddressRepository;
import com.example.projeto_aerj.beta.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AddressRepositoryJPA implements AddressRepository {

    private final AddressJPA addressJPA;
    @Autowired
    public AddressRepositoryJPA(AddressJPA addressJPA) {
        this.addressJPA = addressJPA;
    }

    @Override
    public List<Address> searchAll() {
        return this.addressJPA.findAll();
    }

    @Override
    public Address searchForId(int id) {
        return this.addressJPA.findById(id).get();
    }

    @Override
    public void toAdd(Address address) {
        this.addressJPA.save(address);
    }

    @Override
    public void delete(int id) {
        this.addressJPA.deleteById(id);
    }

    @Override
    public void toUpdate(int id, Address address) {
        address.setId(id);
        this.addressJPA.save(address);
    }
}