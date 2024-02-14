package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressServices {
    Address save(Address address);
    List<Address> getAll();
    Address getById(Long id);
    Address updateById(Address address,Long id);
    void deleteById(Long id);
}
