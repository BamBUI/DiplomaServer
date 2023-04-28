package com.psuti.Server.controller;


import com.psuti.Server.dao.AddressRepository;
import com.psuti.Server.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/address")
@RestController
@CrossOrigin(origins = "*", allowCredentials = "false")
public class AddressRestController {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressRestController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping
    public List<Address> getAll(){
        return addressRepository.findAll();
    }

    @GetMapping("/{id}")
    public Address getById (@PathVariable("id") UUID id){
        return addressRepository.findById(id).get();
    }

    @PutMapping
    public Address update (@RequestBody Address address){
        if(addressRepository.existsById (address.getId())) {
            return addressRepository.save(address);
        }
        throw new EntityExistsException("Address with id:'"+ address.getId() +"' doesn't exist");
    }

    @PostMapping
    public Address create(@RequestBody Address address){
        return addressRepository.save(address);
    }

    @DeleteMapping("/{id}")
    public void remove (@PathVariable("id") UUID id){
        addressRepository.deleteById(id);
    }
}
