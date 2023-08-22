package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer vale = new Customer(1L,
                "Valentinita",
                "hello",
                "vale@gmail.com");
        Customer nicole = new Customer(2L,
                "Nicole M",
                "hello",
                "nicole@gmail.com");

        customerRepository.saveAll(Arrays.asList(vale,nicole));

        List<Customer> customers = underTest.getCustomers();
        assertEquals(2,customers.size());
    }

    @Test
    void getCustomer() {
        Customer vale = new Customer(1L,
                "Valentinita",
                "hello",
                "vale@gmail.com");

        customerRepository.save(vale);

        Customer actual = underTest.getCustomer(1L);
         assertEquals(1l,actual.getId());
         assertEquals("Valentinita",actual.getName());
         assertEquals("hello",actual.getPassword());
         assertEquals("vale@gmail.com",actual.getEmail());
    }
}