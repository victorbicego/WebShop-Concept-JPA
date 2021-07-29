package com.victorbicego.webshopconcept;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class WebShopFunctions {

    public WebShopFunctions(CustomerRepository customerRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public WebShopFunctions() {
    }

    CustomerRepository customerRepository;
    OrderRepository orderRepository;
    ProductRepository productRepository;

    public void webShopMainMenu() {
        boolean stayInProgram = true;
        while (stayInProgram) {
            stayInProgram = webShopOptionsMenu();
        }
        System.out.println("See you next time!");
    }

    private boolean webShopOptionsMenu() {
        String selectedOption = getAnOptionFromUser();

        switch (selectedOption) {
            case "1":
                addNewProduct();
                break;
            case "2":
                addNewCustomer();
                break;
            case "3":
                addNewOrder();
                break;
            case "4":
                printAllOrders();
                break;
            case "5":
                return false;
            default:
                System.out.println("Enter a valid option!");
        }

        return true;
    }

    private String getAnOptionFromUser() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n1: New Product");
        System.out.println("2: New Customer");
        System.out.println("3: Order");
        System.out.println("4: Report.");
        System.out.println("5: Exit.");
        System.out.print("Choose an option: ");

        return input.nextLine();
    }

    private void addNewProduct() {
        Product productToBeAdded = Product.newProduct();
        productRepository.save(productToBeAdded);
    }

    private void addNewCustomer() {
        Customer customerToBeAdded = Customer.newCustomer();
        customerRepository.save(customerToBeAdded);
    }

    private void addNewOrder() {
        Orders ordersToBeAdded = newOrder();
        orderRepository.save(ordersToBeAdded);
    }

    private Orders newOrder() {
        Scanner input = new Scanner(System.in);

        Orders newOrders = new Orders();

        System.out.print("Which customer did the order: ");
        String customerName = input.nextLine();
        newOrders.setOrderCustomer(customerRepository.findCustomerByCustomerName(customerName));

        System.out.print("Which product was ordered: ");
        String productName = input.nextLine();
        newOrders.setOderProduct(productRepository.findProductByProductName(productName));

        return newOrders;
    }

    private void printAllOrders() {
        List<Orders> allOrders = orderRepository.findAll();
        for (Orders allOrder : allOrders) {
            System.out.println(allOrder);
        }
    }

}
