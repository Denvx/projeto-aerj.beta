package com.example.projeto_aerj.beta.applications;

import com.example.projeto_aerj.beta.entities.address.AddressEntitie;
import com.example.projeto_aerj.beta.interfaces.AddressRepository;
import com.example.projeto_aerj.beta.models.Address;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressApplication {

    private final AddressRepository addressRepository;

    public AddressApplication(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressEntitie> searchAll(){
        List<Address> addresses = this.addressRepository.searchAll();
        List<AddressEntitie> addressEntities = new ArrayList<>();
        for(Address address: addresses){
            addressEntities.add(AddressEntitie.fromModel(address));
        }
        return addressEntities;
    }

    public AddressEntitie searcForId(int id){
        return AddressEntitie.fromModel(this.addressRepository.searchForId(id));
    }

    public void toAdd (AddressEntitie addressEntitie){
        Address address = addressEntitie.toModel();
        this.addressRepository.toAdd(address);
    }

    public void delete(int id){
        this.addressRepository.delete(id);
    }

    public void toUpdate (int id, AddressEntitie addressEntitie){
        Address address = addressEntitie.toModel();
        this.addressRepository.toUpdate(id,address);
    }
}