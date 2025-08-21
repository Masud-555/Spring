package com.emranhss.restuarent.restcontroller;

import com.emranhss.restuarent.dto.AdminDTO;
import com.emranhss.restuarent.entity.Admin;
import com.emranhss.restuarent.entity.User;

import com.emranhss.restuarent.service.AdminService;
import com.emranhss.restuarent.service.AuthService;
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

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AuthService authService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    // Admin Registration
    @PostMapping("/reg")
    public ResponseEntity<Map<String, String>> registerAdmin(
            @RequestPart("user") String userJson,
            @RequestPart("admin") String adminJson,
            @RequestPart(value = "photo", required = false) MultipartFile file
    ) throws JsonProcessingException {
        User user = objectMapper.readValue(userJson, User.class);
        Admin admin = objectMapper.readValue(adminJson, Admin.class);

        try {
            authService.registerAdmin(user, file, admin);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Admin registered successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Admin registration failed: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    // Get all admins
    @GetMapping("/all")
    public ResponseEntity<List<AdminDTO>> getAllAdmins() {
        List<AdminDTO> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    // Get logged-in admin profile
    @GetMapping("/profile")
    public ResponseEntity<AdminDTO> getProfile(Authentication authentication) {
        if (authentication == null || authentication.getName() == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        String email = authentication.getName();
        AdminDTO admin = adminService.getProfileByEmail(email);
        return ResponseEntity.ok(admin);
    }

}
