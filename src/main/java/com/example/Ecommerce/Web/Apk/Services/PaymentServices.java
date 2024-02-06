package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentServices {
    Payment savePayment(Payment payment);
    List<Payment> getAllPayments();
    Payment getPaymentById(long id);
    Payment updatePaymentById(Payment payment, long id);
    void deletePaymentById(long id);

}
