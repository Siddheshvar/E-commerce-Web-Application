package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Payment;
import com.example.Ecommerce.Web.Apk.Repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServicesImpl implements PaymentServices{
    @Autowired
    private PaymentRepository paymentRepository;
    public PaymentServicesImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment savePayment(Payment payment) {
        return this.paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return this.paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(long id) {
        return this.paymentRepository.findById(id).orElseThrow(()->
                new RuntimeException("No payment record found!"));
    }

    @Override
    public Payment updatePaymentById(Payment payment, long id) {
        Payment existingPayment = paymentRepository.findById(id).orElseThrow(()->
                new RuntimeException("No payment record found!"));
        existingPayment.setAmount(payment.getAmount());
        return this.paymentRepository.save(existingPayment);
    }

    @Override
    public void deletePaymentById(long id) {
        paymentRepository.findById(id).orElseThrow(()->
                new RuntimeException("No payment record found!"));
        paymentRepository.deleteById(id);
    }
}
