package com.victorbicego.webshopconcept;

import lombok.Data;

import javax.persistence.*;

@Entity
public class Orders {

    @Id
    @GeneratedValue
    private Long orderId;

    private Double orderTotalPrice;

    @ManyToOne
    private Customer orderCustomer;

    @ManyToOne
    private Product oderProduct;

    public void setOrderCustomer(Customer orderCustomer) {
        this.orderCustomer = orderCustomer;
    }

    public void setOderProduct(Product oderProduct) {
        this.oderProduct = oderProduct;
    }
}
