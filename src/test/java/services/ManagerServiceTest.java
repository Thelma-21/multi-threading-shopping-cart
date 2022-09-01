package services;

import enums.Roles;
import models.Store;
import models.User;

import static org.junit.jupiter.api.Assertions.*;

class ManagerServiceTest {
    ManagerService managerService;
    User manager;
    User applicant;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        //Store store = new Store();
        managerService = new ManagerService();
        manager = new User("kay", Roles.MANAGER);
        applicant = new User("Bill", Roles.APPLICANT, 65);

    }

    @org.junit.jupiter.api.Test
    void hireCashier() {
        User cashier = managerService.hireCashier(manager, applicant);
        assertEquals(applicant.getName(), cashier.getName());
        assertNotEquals(applicant.getRole(), cashier.getRole());

    }
}