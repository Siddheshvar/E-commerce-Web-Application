package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressServices {
    Address saveAddress(Address address);
    List<Address> getall();
    Address getAddressById(int id);
    Address updateAddressById(Address address,int id);
    void deleteAddressById(int id);
}
