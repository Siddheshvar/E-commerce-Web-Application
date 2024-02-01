package com.example.Ecommerce.Web.Apk.DTO;

import com.example.Ecommerce.Web.Apk.Modules.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Customer customer;
}
