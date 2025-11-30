package com.example.projeto_aerj.beta.facades;

import com.example.projeto_aerj.beta.applications.AddressApplication;
import com.example.projeto_aerj.beta.entities.address.AddressEntitie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressFacade {

    private final AddressApplication addressApplication;

    public AddressFacade(AddressApplication addressApplication) {
        this.addressApplication = addressApplication;
    }

    public List<AddressEntitie> searchAll(){
        return this.addressApplication.searchAll();
    }

    public AddressEntitie searchForId(int id){
        return this.addressApplication.searcForId(id);
    }

    public void toAdd(AddressEntitie address){
        this.addressApplication.toAdd(address);
    }

    public void delete(int id){
        this.addressApplication.delete(id);
    }

    public void toUpdate(int id, AddressEntitie address){
        this.addressApplication.toUpdate(id, address);
    }
}