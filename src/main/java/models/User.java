package models;

import enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import services.StoreService;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private String name;
    private Roles role;
    private int score;
    private double wallet;
    private Map<String, Product> cart;
    StoreService storeService;

    public User(String name, Roles role) {
        this.name = name;
        this.role = role;
    }

    public User(String name, Roles role, double wallet) {
        this.name = name;
        this.role = role;
        this.wallet = wallet;
        this.cart =  new HashMap<>();
    }

    public User(String name, Roles role, int score) {
        this.name = name;
        this.role = role;
        this.score = score;
    }

    @Override
    public String toString() {
        return "" + "Name: " + name + " " +  " Role: " + role;



    }
}
