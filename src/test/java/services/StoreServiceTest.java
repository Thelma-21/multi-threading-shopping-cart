package services;

import enums.Roles;
import models.Inventory;
import models.Product;
import models.Store;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreServiceTest {

        Store store = new Store();
        User cashier = new User("Franca", Roles.CASHIER);
        StoreService storeService = new StoreService();
        User eunice = new User("Eunice", Roles.CUSTOMER, 1000.0);
        User thelma = new User("Thelma", Roles.CUSTOMER, 1500.0);
        User dorcas = new User("Dorcas", Roles.CUSTOMER, 200.0);
        Inventory inventory = new Inventory();
        List<Product> productList = new ArrayList<>();




    @Test
    void addToCart() {
        productList.add(new Product("snacks", "potato chips", 25, 1.67 ));
        String message = storeService.addToCart(productList, eunice, "potato chips", 20);
        assertEquals("products added to cart", message);

    }

    @Test
    void productOutOfStockTest() {
        productList.add(new Product("snacks", "potato chips", 25, 1.67 ));
        String message = storeService.addToCart(productList, eunice, "potato chips", 30);
        assertEquals("product out of stock", message);

    }

    @Test
    void productNotFoundTest() {
        productList.add(new Product("snacks", "potato chips", 25, 1.67 ));
        String message = storeService.addToCart(productList, thelma, "carrot", 10);
        assertEquals("Product not found!", message);

    }

    @Test
    void sellProduct() {
        productList.add(new Product("cookies", "chocolate chips", 25, 1.67 ));
        storeService.addToCart(productList, dorcas, "chocolate chips", 10);
        boolean output = storeService.sellProduct(cashier, dorcas);
        assertTrue(output);
        output = storeService.sellProduct(thelma,dorcas);
        assertFalse(output);
    }

    @Test
    void customerWalletTest() {
        productList.add(new Product("cookies", "chocolate chips", 25, 1.67));
        storeService.addToCart(productList, dorcas, "chocolate chips", 20);
        boolean output = storeService.sellProduct(cashier, dorcas);
    }



}