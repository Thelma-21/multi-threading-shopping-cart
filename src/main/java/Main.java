import enums.Roles;
import models.*;
import services.ManagerService;
import services.QueueImplementation;
import services.QueueThread;
import services.StoreService;

import java.util.*;


public class Main {
    
    public static void main(String[] args) {

        User manager = new User("kay", Roles.MANAGER);
        User applicant = new User("Ben", Roles.APPLICANT, 60);
        ManagerService managerService = new ManagerService();
      //  QueueImplementation queueImplementation = new QueueImplementation();
        User cashier = managerService.hireCashier(manager, applicant);
        System.out.println(cashier);
        System.out.println("~".repeat(100));
        System.out.println("~".repeat(100));

        //************* All Products available in the store ***************//
        Product product = new Product();
        Store store = new Store();
        Inventory inventory = new Inventory();
        System.out.println(inventory.addToProductList());

        StoreService storeService = new StoreService();

        //************* Adding Customers to Cart *******************************//


        User customer1 = new User("Mathew", Roles.CUSTOMER, 1000.0);
        storeService.addToCart(inventory.productList, customer1, "carrot", 20);
        storeService.addToCart(inventory.productList, customer1, "banana", 10);
        storeService.addToCart(inventory.productList, customer1, "arrowroot", 30);

        User customer2 = new User("Ella", Roles.CUSTOMER, 500.0);
        storeService.addToCart(inventory.productList, customer2, "banana", 20);
        storeService.addToCart(inventory.productList, customer2, "carrot", 30);

        User customer3 = new User("Caleb", Roles.CUSTOMER, 1200.0);
        storeService.addToCart(inventory.productList, customer3, "whole wheat", 15);
        storeService.addToCart(inventory.productList, customer3, "carrot", 10);
        storeService.addToCart(inventory.productList, customer3, "potato chips", 25);

        User customer4 = new User("Amanda", Roles.CUSTOMER, 1500.0);
        storeService.addToCart(inventory.productList, customer4, "whole wheat", 20);
        storeService.addToCart(inventory.productList, customer4, "arrowroot", 25);
        storeService.addToCart(inventory.productList, customer4, "potato chips", 35);


        System.out.println(storeService.sellProduct(cashier, customer1));


//        storeService.sellProduct(cashier, customer1);
        //************* Display Items in Cart *******************************//
        System.out.println("~".repeat(100));
        System.out.println("~".repeat(100));
//        storeService.sellProduct(cashier, customer1);
//        storeService.sellProduct(cashier, customer2);
//        storeService.sellProduct(cashier, customer3);
//        storeService.sellProduct(cashier, customer4);
        //************* Implementing First in First Out *******************************//

        QueueImplementation queue = new QueueImplementation();
        System.out.println("~".repeat(100));
        System.out.println("*** *** *** *** *** First In First Out *** *** *** *** *** ");
        System.out.println("~".repeat(100));

        queue.addCustomersToQueueFifo(customer1 , store);
        queue.addCustomersToQueueFifo(customer2 , store);
        queue.addCustomersToQueueFifo(customer3 , store);
        queue.addCustomersToQueueFifo(customer4 , store);


        queue.printQueue(cashier , store , storeService);

        //************* Implementing Priority Queue *******************************//

        System.out.println("~".repeat(100));
        System.out.println("*** *** *** *** *** Priority Queue *** *** *** *** ***");
        System.out.println("~".repeat(100));

        queue.addProductsToQueue(customer1);
        queue.addProductsToQueue(customer2);
        queue.addProductsToQueue(customer3);
        queue.addProductsToQueue(customer4);
        System.out.println("~".repeat(100));
        System.out.println("*** *** *** Printing items based on Priority Queue *** *** *** *** ***");
        System.out.println("~".repeat(100));


        queue.showPriorityQueue(queue.getCarrotQueue());
        queue.showPriorityQueue(queue.getBananaQueue());
        queue.showPriorityQueue(queue.getArrowRootQueue());
        queue.showPriorityQueue(queue.getPotatoChipsQueue());
        queue.showPriorityQueue(queue.getWholeWheatQueue());
        System.out.println("~".repeat(100));

        //System.out.println(inventory.addToProductList());


        QueueThread queueThread1 = new QueueThread(cashier, customer1);
        QueueThread queueThread2 = new QueueThread(cashier, customer2);
        QueueThread queueThread3 = new QueueThread(cashier, customer3);
        QueueThread queueThread4 = new QueueThread(cashier, customer4);

        List<QueueThread> threads = new ArrayList<>(4);
        Collections.addAll(threads, queueThread1, queueThread2,queueThread3,queueThread4);


        for(QueueThread thread : threads){
            thread.start();
            try {
                thread.join();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }





    }



}