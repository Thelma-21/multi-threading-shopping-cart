package services;

import lombok.Getter;
import lombok.Setter;
import models.CustomerDTO;
import models.Product;
import models.Store;
import models.User;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
@Getter
@Setter
public class QueueImplementation {
    private Queue<CustomerDTO> carrotQueue = new PriorityQueue<>(5, new CustomerDTO());
    private Queue<CustomerDTO> bananaQueue = new PriorityQueue<>(5, new CustomerDTO());
    private Queue<CustomerDTO> wholeWheatQueue = new PriorityQueue<>(5, new CustomerDTO());
    private Queue<CustomerDTO> arrowRootQueue = new PriorityQueue<>(5, new CustomerDTO());
    private Queue<CustomerDTO> potatoChipsQueue = new PriorityQueue<>(5, new CustomerDTO());

    //private Product product;


    public String addCustomersToQueueFifo(User customer , Store store){
        store.getQueueFifo().add(customer);
        return "Customer added";
    }

    public String printQueue(User cashier , Store store , StoreService storeService){
        while (store.getQueueFifo().peek() != null){
            //System.out.println(store.getQueueFifo().poll());
            storeService.sellProduct(cashier , store.getQueueFifo().poll());
        }
        return "printed";
    }

//

    public String addProductsToQueue(User customer){
        String print = "";
        for(Map.Entry<String, Product> entry : customer.getCart().entrySet()) {
            if (entry.getKey().equalsIgnoreCase("carrot")) {
                carrotQueue.add(new CustomerDTO(customer.getName(), entry.getValue().getName(), entry.getValue().getQuantity()));
                System.out.println(customer.getName() + " " + entry.getValue().getName() + " added to queue");
                print = "Items added";
            }
            if (entry.getKey().equalsIgnoreCase("banana")) {
                bananaQueue.add(new CustomerDTO(customer.getName(), entry.getValue().getName(), entry.getValue().getQuantity()));
                System.out.println(customer.getName() + " " + entry.getValue().getName() + " added to queue");
                print = "Items added";
            }
            if (entry.getKey().equalsIgnoreCase("whole wheat")) {
                wholeWheatQueue.add(new CustomerDTO(customer.getName(), entry.getValue().getName(), entry.getValue().getQuantity()));
                System.out.println(customer.getName() + " " + entry.getValue().getName() + " added to queue");
                print = "Items added";
            }
            if (entry.getKey().equalsIgnoreCase("arrowroot")) {
                arrowRootQueue.add(new CustomerDTO(customer.getName(), entry.getValue().getName(), entry.getValue().getQuantity()));
                System.out.println(customer.getName() + " " + entry.getValue().getName() + " added to queue");
                print = "Items added";
            }
            if (entry.getKey().equalsIgnoreCase("potato Chips")) {
                potatoChipsQueue.add(new CustomerDTO(customer.getName(), entry.getValue().getName(), entry.getValue().getQuantity()));
                System.out.println(customer.getName() + " " + entry.getValue().getName() + " added to queue");
                print = "Items added";
            }
        }
        return print;

    }

    public void showPriorityQueue(Queue<CustomerDTO> productQueue){
        while (!productQueue.isEmpty()){
            System.out.println(productQueue.poll());
        }
    }

}
