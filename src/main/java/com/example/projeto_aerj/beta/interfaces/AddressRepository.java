package com.example.projeto_aerj.beta.interfaces;

import com.example.projeto_aerj.beta.models.Address;
import java.util.List;

public interface AddressRepository {
    List<Address> searchAll();
    Address searchForId(int id);
    void toAdd(Address address);
    void delete(int id);
    void toUpdate(int id, Address address);
}
