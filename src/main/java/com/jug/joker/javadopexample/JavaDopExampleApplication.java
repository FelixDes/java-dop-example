package com.jug.joker.javadopexample;

import com.jug.joker.javadopexample.model.entity.Customer;
import com.jug.joker.javadopexample.model.entity.Purchase;
import com.jug.joker.javadopexample.model.entity.PurchasePart;
import com.jug.joker.javadopexample.repository.CustomerRepository;
import com.jug.joker.javadopexample.repository.PurchasePartRepository;
import com.jug.joker.javadopexample.repository.PurchaseRepository;
import com.jug.joker.javadopexample.service.EntityWalkerService;
import org.springframework.ai.autoconfigure.openai.OpenAiAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@SpringBootApplication(exclude = OpenAiAutoConfiguration.class)
public class JavaDopExampleApplication implements CommandLineRunner {

    @Autowired
    EntityWalkerService<Boolean> walkerService;

    @Autowired
    PurchaseRepository purchaseRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PurchasePartRepository purchasePartRepository;

    public static void main(String[] args) {
        SpringApplication.run(JavaDopExampleApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) {
        var customer = new Customer();
        customer.setName("Customer");
        customerRepository.save(customer);

        var purchasePart = new PurchasePart();
        purchasePart.setName("PP1");
        purchasePartRepository.save(purchasePart);

        var purchase = new Purchase();
        purchase.setName("123");
        purchase.setCustomers(Set.of(customer));
        purchase.setPurchaseParts(Set.of(purchasePart));
        purchaseRepository.save(purchase);

        var found = purchaseRepository.findById(1L).orElseThrow();
        System.out.println(walkerService.processEntityTree(found, (e) -> switch (e) {
            case Customer c -> true;
            case Purchase p -> true;
            case PurchasePart pp -> false;
        }));
    }
}
