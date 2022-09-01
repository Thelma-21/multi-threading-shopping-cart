package services;

import enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.Product;
import models.User;
import java.util.List;
import java.util.Map;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StoreService {
    private QueueImplementation queueImplementation;
    private Product product;
    private User user;


    public String addToCart(List<Product> inventory, User customer, String productName, long quantity) {
        String print = "";
        if (customer.getRole().equals(Roles.CUSTOMER)) {
            for (Product productInv : inventory) {
                if (productInv.getName().equalsIgnoreCase(productName)) {
                    if (productInv.getQuantity() >= quantity) {
                        if (customer.getCart().containsKey(productName)) {
                            Product duplicateProduct = customer.getCart().get(productName);
                            duplicateProduct.setQuantity(duplicateProduct.getQuantity() + quantity);
                            productInv.setQuantity(productInv.getQuantity() - duplicateProduct.getQuantity());
                           System.out.println(quantity + "more" + duplicateProduct.getName() + "has been added to cart");

                        } else {
                            customer.getCart().put(productName, new Product(productInv.getName(), quantity, productInv.getPrice()));
                            productInv.setQuantity(productInv.getQuantity() - quantity);
                           System.out.println(quantity + " " + productName + " added to cart");

                        }
                       print = "products added to cart";

                    } else {
                        print = "product out of stock";
                    }
                } else {
                    print = "Product not found!";
                }
            }
        }else {
            print = "User not authorized for this transaction";
        }
        return print;
    }



    public boolean sellProduct(User cashier, User customer){
        boolean outcome = false;
        double totalPrice = 0;
        double balance = 0;
       if(cashier.getRole().equals(Roles.CASHIER)){
            for(Map.Entry<String, Product> entry : customer.getCart().entrySet()){
                totalPrice += entry.getValue().getQuantity() * entry.getValue().getPrice();
                if(customer.getWallet() >= totalPrice){
                    balance = customer.getWallet() - totalPrice;
                    dispenseReceipt(customer,totalPrice, balance);
                    outcome = true;
                }else{
                System.out.println("Insufficient fund");}
            }
        }else{
           System.out.println("User not authorized");
        }

        return outcome;
    }

        public boolean dispenseReceipt(User customer, double totalPrice, double balance ) {
            boolean print = false;
            System.out.println(customer.getName() + '\n' + customer.getCart() + '\n' + "TOTAL PRICE = " + " $" + totalPrice + '\n' +
                    "Wallet Balance, = " + balance + '\n');


            return print;
        }
    }

