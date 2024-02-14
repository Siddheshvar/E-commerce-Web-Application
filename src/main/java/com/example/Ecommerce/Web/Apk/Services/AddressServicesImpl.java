package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Address;
import com.example.Ecommerce.Web.Apk.Repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServicesImpl implements AddressServices{
    @Autowired
    private AddressRepository addressRepository;


    @Override
    public Address save(Address address) {
        return this.addressRepository.save(address);
    }

    @Override
    public List<Address> getAll() {
        return this.addressRepository.findAll();
    }

    @Override
    public Address getById(Long id) {
        return this.addressRepository.findById(id).orElseThrow(()->
         new RuntimeException("Address not found!"));
    }

    @Override
    public Address updateById(Address address, Long id) {
        Address oldAddress = addressRepository.findById(id).orElseThrow(()->
                new RuntimeException("Address not found!"));

        oldAddress.setFlatOrHouseNo(address.getFlatOrHouseNo());
        oldAddress.setResidencyOrApartment(address.getResidencyOrApartment());
        oldAddress.setAreaOrColony(address.getAreaOrColony());
        oldAddress.setTownOrVillage(address.getTownOrVillage());
        oldAddress.setCity(address.getCity());
        oldAddress.setSubDistrict(address.getSubDistrict());
        oldAddress.setDistrict(address.getDistrict());
        oldAddress.setPinCode(address.getPinCode());
        oldAddress.setState(address.getState());
        oldAddress.setCountry(address.getCountry());

        return this.addressRepository.save(oldAddress);
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.findById(id).orElseThrow(()->
                new RuntimeException("Address not found!"));
        addressRepository.deleteById(id);
    }
}
