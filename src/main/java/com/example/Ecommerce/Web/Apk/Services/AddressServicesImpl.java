package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Address;
import com.example.Ecommerce.Web.Apk.Repositories.AddressRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServicesImpl implements AddressServices{
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address saveAddress(Address address) {
        return this.addressRepository.save(address);
    }

    @Override
    public List<Address> getall() {
        return this.addressRepository.findAll();
    }

    @Override
    public Address getAddressById(int id) {
        return this.addressRepository.findById(id).orElseThrow(()->
                new RuntimeException("Address not found!"));
    }

    @Override
    public Address updateAddressById(@NotNull Address address, int id) {
        Address oldAddress = addressRepository.findById(id).orElseThrow(()->
                new RuntimeException("Address not found!"));

        oldAddress.setFlatOrHouseNo(address.getFlatOrHouseNo());
        oldAddress.setApartmentOrColony(address.getApartmentOrColony());
        oldAddress.setAreaOrVillage(address.getAreaOrVillage());
        oldAddress.setCity(address.getCity());
        oldAddress.setDistrict(address.getDistrict());
        oldAddress.setPinCode(address.getPinCode());

        return this.addressRepository.save(oldAddress);
    }

    @Override
    public void deleteAddressById(int id) {
        addressRepository.findById(id).orElseThrow(()->
                new RuntimeException("Address not found!"));
        addressRepository.deleteById(id);
    }
}
