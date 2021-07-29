package com.victorbicego.webshopconcept;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long customerId;

    private String customerName;

    @Enumerated(EnumType.STRING)
    private Gender customerGender;

    @OneToMany(mappedBy = "orderCustomer")
    private List<Orders> customerOrders;

    public static Customer newCustomer() {
        Scanner input = new Scanner(System.in);

        Customer newCustomer = new Customer();

        System.out.print("Customer name: ");
        String customerName = input.nextLine();
        newCustomer.setCustomerName(customerName);

        System.out.print("Customer gender (Male, Female, Divers): ");
        Gender customerGender = Gender.valueOf(input.nextLine().toUpperCase());
        newCustomer.setCustomerGender(customerGender);

        return newCustomer;
    }

}
