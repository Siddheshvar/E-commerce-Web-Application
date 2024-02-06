package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Address;
import com.example.Ecommerce.Web.Apk.Modules.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressServices {
    Address saveAddress(Address address);
    List<Address> getAllAddress();
    Address getAddressById(long id);
    Address updateAddressById(Address address, long id);
    void deleteAddressById(long id);
}
