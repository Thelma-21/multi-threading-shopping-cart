package services;

import enums.Roles;
import models.CustomerDTO;
import models.Store;
import models.User;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueThread extends Thread{
    private User customer;
    private User cashier;
    QueueImplementation queueImpl;
    Store store;
    StoreService storeService;
    CustomerDTO customerDTO;


    public QueueThread(User customer, User cashier) {
        this.customer = customer;
        this.cashier = cashier;
        this.queueImpl = new QueueImplementation();
        this.storeService = new StoreService();
        this.store = new Store();
    }




    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+ " is running");
            queueImpl.addCustomersToQueueFifo(customer, store);
            queueImpl.printQueue(cashier, store, storeService);



        //queueImpl.addProductsToQueue(customer);
        //queueImpl.addCustomersToQueueFifo(customer, store);
    }

}
