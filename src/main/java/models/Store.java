package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Store {

    Queue<User>queueFifo = new LinkedList<>();
    Queue<User>priorityQueue = new PriorityQueue<>();
}
