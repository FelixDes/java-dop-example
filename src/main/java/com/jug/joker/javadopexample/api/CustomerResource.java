//package com.jug.joker.javadopexample.api;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jug.joker.javadopexample.model.entity.Customer;
//import com.jug.joker.javadopexample.repository.CustomerRepository;
//import lombok.RequiredArgsConstructor;
//import org.springdoc.core.annotations.ParameterObject;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/customers")
//@RequiredArgsConstructor
//public class CustomerResource {
//
//    private final CustomerRepository customerRepository;
//
//    private final ObjectMapper objectMapper;
//
//    @GetMapping
//    public Page<Customer> getList(@ParameterObject Pageable pageable) {
//        return customerRepository.findAll(pageable);
//    }
//
//    @GetMapping("/{id}")
//    public Customer getOne(@PathVariable Long id) {
//        Optional<Customer> customerOptional = customerRepository.findById(id);
//        return customerOptional.orElseThrow(() ->
//                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));
//    }
//
//    @GetMapping("/by-ids")
//    public List<Customer> getMany(@RequestParam List<Long> ids) {
//        return customerRepository.findAllById(ids);
//    }
//
//    @PostMapping
//    public Customer create(@RequestBody Customer customer) {
//        return customerRepository.save(customer);
//    }
//
//    @PatchMapping("/{id}")
//    public Customer patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
//        Customer customer = customerRepository.findById(id).orElseThrow(() ->
//                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));
//
//        objectMapper.readerForUpdating(customer).readValue(patchNode);
//
//        return customerRepository.save(customer);
//    }
//
//
//    @DeleteMapping("/{id}")
//    public Customer delete(@PathVariable Long id) {
//        Customer customer = customerRepository.findById(id).orElse(null);
//        if (customer != null) {
//            customerRepository.delete(customer);
//        }
//        return customer;
//    }
//
//    @DeleteMapping
//    public void deleteMany(@RequestParam List<Long> ids) {
//        customerRepository.deleteAllById(ids);
//    }
//}
