package com.example.Ecommerce.Web.Apk.Services;


import com.example.Ecommerce.Web.Apk.Modules.Address;
import com.example.Ecommerce.Web.Apk.Repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServicesImpl implements AddressServices{
    private AddressRepository addressRepository;
    @Override
    public Address saveAddress(Address address) {
        return this.addressRepository.save(address);
    }

    @Override
    public List<Address> getAllAddress() {
        return this.addressRepository.findAll();
    }

    @Override
    public Address getAddressById(long id) {
        return this.addressRepository.findById(id).orElseThrow(()->
                new RuntimeException("Address not found!"));
    }

    @Override
    public Address updateAddressById(Address address, long id) {
        Address existingAddress = addressRepository.findById(id).orElseThrow(()->
                new RuntimeException("Address not found!"));
        existingAddress.setStreet(address.getStreet());
        existingAddress.setCity(address.getCity());
        existingAddress.setState(address.getState());
        existingAddress.setCountry(address.getCountry());
        existingAddress.setOrders(address.getOrders());

        return this.addressRepository.save(existingAddress);
    }

    @Override
    public void deleteAddressById(long id) {
        addressRepository.findById(id).orElseThrow(()->
                new RuntimeException("Address not found!"));
        addressRepository.deleteById(id);
    }
}
