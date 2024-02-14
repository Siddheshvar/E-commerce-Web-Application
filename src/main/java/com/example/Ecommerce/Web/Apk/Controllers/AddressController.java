package com.example.Ecommerce.Web.Apk.Controllers;

import com.example.Ecommerce.Web.Apk.Modules.Address;
import com.example.Ecommerce.Web.Apk.Services.AddressServices;
import lombok.Getter;
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
    public ResponseEntity<Address>save(@RequestBody Address address){
        return new ResponseEntity<Address>(addressServices.save(address), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public List<Address>getAll(){
        return new ArrayList<Address>(addressServices.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Address>getById(@PathVariable("id")Long id){
        return new ResponseEntity<Address>(addressServices.getById(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Address> updateById(@PathVariable("id")Long id,
                                              @RequestBody Address address){
        return new ResponseEntity<>(addressServices.updateById(address,id),HttpStatus.OK);
    }

    public ResponseEntity<Address>deleteById(@PathVariable("id")Long id){
        addressServices.deleteById(id);
        return new ResponseEntity<Address>(HttpStatus.OK);
    }
}
