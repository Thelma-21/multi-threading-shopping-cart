package services;

import enums.Roles;
import models.User;

public class ManagerService {
    private User manager;


    public User hireCashier(User manager, User user){
        if(manager.getRole().equals(Roles.MANAGER) && user.getRole().equals(Roles.APPLICANT)){
            if(user.getScore() > 50){
                System.out.println("Congratulations on your new role");
                return new User(user.getName(), Roles.CASHIER);
            }else {
                System.out.println("Sorry, you do not qualify for this role");
            }
        }else{
            System.out.println("User not authorized");
        }
        return user;
    }
}
