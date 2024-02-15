package com.example.Ecommerce.Web.Apk.Modules;



import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @OneToOne
    private Order order;

    private Float amount;

}
