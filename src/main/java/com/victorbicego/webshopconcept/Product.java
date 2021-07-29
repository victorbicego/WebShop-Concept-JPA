package com.victorbicego.webshopconcept;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long productId;

    private String productName;

    private String productShortDescription;

    private Double productPrice;

    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    @OneToMany(mappedBy = "oderProduct")
    private List<Orders> productOrders;

    public static Product newProduct() {
        Scanner input = new Scanner(System.in);

        Product newProduct = new Product();

        System.out.print("Product name: ");
        String productName = input.nextLine();
        newProduct.setProductName(productName);

        System.out.print("Product short description: ");
        String productShortDescription = input.nextLine();
        newProduct.setProductShortDescription(productShortDescription);

        System.out.print("Product price: ");
        String productPrice = input.nextLine();
        newProduct.setProductPrice(Double.parseDouble(productPrice));

        System.out.print("Product category (Fresh, Dry, Spice, Spreads, Jams): ");
        ProductCategory productCategory = ProductCategory.valueOf(input.nextLine().toUpperCase());
        newProduct.setProductCategory(productCategory);

        return newProduct;
    }

}
