package com.example.Ecommerce.Web.Apk.Controllers;

import com.example.Ecommerce.Web.Apk.Modules.Address;
import com.example.Ecommerce.Web.Apk.Services.AddressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressServices addressServices;
    public AddressController(AddressServices addressServices) {
        this.addressServices = addressServices;
    }

    @PostMapping("/saveAddress")
    public ResponseEntity<Address> saveAddress(Address address){
        return new ResponseEntity<>(addressServices.saveAddress(address), HttpStatus.OK);
    }

    @GetMapping("/getAddresses")
    public List<Address> getAllAddress(){
        return  new ArrayList<>(addressServices.getAllAddress());
    }

    @GetMapping("/getAddress/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id")long id){
        return new ResponseEntity<Address>(addressServices.getAddressById(id),HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Address> updateAddressById(@PathVariable("id")long id,
                                                     @RequestBody Address address){
        return  new ResponseEntity<Address>(addressServices.updateAddressById(address,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Address> deleteAddressById(@PathVariable("id")long id){
        addressServices.deleteAddressById(id);
        return new ResponseEntity<Address>(HttpStatus.OK);
    }
}
