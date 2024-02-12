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

    @PostMapping("/save")
    public ResponseEntity<Address> save(@RequestBody Address address){
        return new ResponseEntity<Address>(addressServices.saveAddress(address), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public List<Address> allAddress(){
        return new ArrayList<Address>(addressServices.getall());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Address> getById(@PathVariable("id") int id){
        return new ResponseEntity<Address>(addressServices.getAddressById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Address> update(@PathVariable("id")int id,
                                              @RequestBody Address address){
        return new ResponseEntity<Address>(addressServices.updateAddressById(address,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Address> delete(@PathVariable("id")int id){
        addressServices.deleteAddressById(id);
        return new ResponseEntity<Address>(HttpStatus.OK);
    }
}
