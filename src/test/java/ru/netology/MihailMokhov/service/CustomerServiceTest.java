package ru.netology.MihailMokhov.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.MihailMokhov.OperationHistoryApiApplicationTest;
import ru.netology.MihailMokhov.domain.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceTest extends OperationHistoryApiApplicationTest {
    @Autowired
    private CustomerService customerService;

    @Test
    public void getClientsTest() {
        assertEquals(new Customer(2, "Boot", "password"), customerService.getCustomer(1));
        assertEquals(new Customer(1, "Spring", "password"), customerService.getCustomer(0));
    }

    @Test
    public void saveInCustomerServiceTest(){
        int customerId = 19;
        String customerName = "Misha";
        String customerPassword = "143749";
        Customer john = new Customer(customerId, customerName, customerPassword);
        customerService.addCustomer(john);
        Customer customer = customerService.getCustomer(2);
        assertEquals(john, customer);
        assertEquals(customerId, customer.getId());
        assertEquals(customerName, customer.getName());
        assertEquals(customerPassword, customer.getPassword());
    }
}