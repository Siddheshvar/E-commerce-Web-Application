package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Payment;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface PaymentServices {
    Payment save(Payment payment);
    List<Payment> getall();
    Payment getById(int id);
    Payment updateById(Payment payment,int id);
    void deleteById(int id);
}
