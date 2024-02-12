package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Payment;
import com.example.Ecommerce.Web.Apk.Repositories.PaymentRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PaymentServicesImpl implements PaymentServices{
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment save(Payment payment) {
        return this.paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getall() {
        return this.paymentRepository.findAll();
    }

    @Override
    public Payment getById(int id) {
        return this.paymentRepository.findById(id).orElseThrow(()->
                new RuntimeException("Payment not found!"));
    }

    @Override
    public Payment updateById(@NotNull Payment payment, int id) {
        Payment oldPayment = paymentRepository.findById(id).orElseThrow(()->
                new RuntimeException("Payment not found!"));

        oldPayment.setAmount(payment.getAmount());
        return this.paymentRepository.save(oldPayment);
    }

    @Override
    public void deleteById(int id) {
        paymentRepository.findById(id).orElseThrow(()->
                new RuntimeException("Payment not found!"));
        paymentRepository.deleteById(id);
    }
}
