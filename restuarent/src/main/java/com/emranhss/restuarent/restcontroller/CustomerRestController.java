package com.emranhss.restuarent.restcontroller;


import com.emranhss.restuarent.entity.Customer;
import com.emranhss.restuarent.entity.User;
import com.emranhss.restuarent.repository.CustomerRepository;
import com.emranhss.restuarent.repository.IUserRepo;
import com.emranhss.restuarent.service.AuthService;
import com.emranhss.restuarent.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    @Autowired
    private AuthService userService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/reg")
    public ResponseEntity<Map<String, String>> registerCustomer(
            @RequestPart(value = "user") String userJson,
            @RequestPart(value = "customer") String customerJson,
            @RequestParam(value = "photo") MultipartFile file
    ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(userJson, User.class);
        Customer customer = objectMapper.readValue(customerJson, Customer.class);

        try {
            userService.registerCustomer(user, file, customer);
            Map<String, String> response = new HashMap<>();
            response.put("Message", "User Added Successfully ");

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Message", "User Add Faild " + e);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllUsers() {
        List<Customer> customerList = customerService.getAll();
        return ResponseEntity.ok(customerList);

    }



    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(Authentication authentication) {
        System.out.println("Authenticated User: " + authentication.getName());
        System.out.println("Authorities: " + authentication.getAuthorities());
        String email = authentication.getName();
        Optional<User> user =userRepo.findByEmail(email);
        Customer customer = customerService.getProfileByUserId(user.get().getId());
        return ResponseEntity.ok(customer);

    }
}
