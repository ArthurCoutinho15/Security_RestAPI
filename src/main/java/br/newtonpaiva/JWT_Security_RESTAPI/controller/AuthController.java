package br.newtonpaiva.JWT_Security_RESTAPI.controller;

import br.newtonpaiva.JWT_Security_RESTAPI.model.LoginRequest;
import br.newtonpaiva.JWT_Security_RESTAPI.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody LoginRequest user) {
        authService.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String token = authService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        LoginRequest user = authService.findByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(404).body("User not found");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editUser(@PathVariable String id, @RequestBody LoginRequest user) {
        boolean isUpdated = authService.updateUser(id, user);
        if (isUpdated) {
            return ResponseEntity.ok("User updated successfully");
        }
        return ResponseEntity.status(404).body("User not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        boolean isDeleted = authService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.ok("User deleted successfully");
        }
        return ResponseEntity.status(404).body("User not found");
    }
}