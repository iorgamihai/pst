package com.proiect.ecommerce.controllers;

import com.proiect.ecommerce.model.Address;
import com.proiect.ecommerce.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    //GET
    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    //GET dupa ID
    @GetMapping("/{id}")
    public Address getAddresses(Integer id) {
        return addressService.getAddresses(id);
    }

    //POST
    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

    //PUT
    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable("id") Integer id, @RequestBody Address address) {
        return addressService.updateAddress(id, address);
    }

    //PATCH
    @PatchMapping("/{id}")
    public Address updatePatchAddress(@PathVariable("id") Integer id, @RequestBody Address address) {
        return addressService.updatePatchAddress(id, address);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void DeleteAddress(@PathVariable("id") Integer id) {
        addressService.DeleteAddress(id);
    }
}
