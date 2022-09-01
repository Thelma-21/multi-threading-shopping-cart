package services;

import enums.Roles;
import models.Inventory;
import models.Product;
import models.Store;
import models.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QueueImplementationTest {
    Store store = new Store();
    StoreService storeService = new StoreService();
    User cashier = new User("Ada", Roles.CASHIER);
    QueueImplementation queueImplementation = new QueueImplementation();
    User customer1 = new User("Tony", Roles.CUSTOMER, 500.0);
    User customer2 = new User("Ken", Roles.CUSTOMER, 1000.0);
    User customer3 = new User("Bill", Roles.CUSTOMER, 1500.0);
    User customer4 = new User("Ben", Roles.CUSTOMER, 2000.0);
    List<Product> productList = new ArrayList<>();

    @Test
    void addCustomersToQueueFifo() {
        assertEquals("Customer added", queueImplementation.addCustomersToQueueFifo(customer1, store));
        assertEquals("Customer added", queueImplementation.addCustomersToQueueFifo(customer2, store));
        assertEquals("Customer added", queueImplementation.addCustomersToQueueFifo(customer3, store));
        assertEquals("Customer added", queueImplementation.addCustomersToQueueFifo(customer4, store));

    }

    @Test
    void printQueue(){
        queueImplementation.addCustomersToQueueFifo(customer1, store);
        queueImplementation.addCustomersToQueueFifo(customer2, store);
        assertEquals("printed", queueImplementation.printQueue(cashier, store, storeService));

    }

    @Test
    void addProductsToQueue() {
        productList.add(new Product("Cookies", "banana", 20, 2.35));
        productList.add(new Product("snacks", "potato chips", 20, 2.35));

        storeService.addToCart(productList, customer1, "banana", 6);
        storeService.addToCart(productList, customer2, "potato chips", 7);
        storeService.addToCart(productList, customer3, "banana", 12);
        storeService.addToCart(productList, customer4, "potato chips", 10);

        assertEquals("Items added", queueImplementation.addProductsToQueue(customer1));
        assertEquals("Items added", queueImplementation.addProductsToQueue(customer2));
        assertEquals("Items added", queueImplementation.addProductsToQueue(customer3));
        assertEquals("Items added", queueImplementation.addProductsToQueue(customer4));
    }
}