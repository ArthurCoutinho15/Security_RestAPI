package br.newtonpaiva.JWT_Security_RESTAPI.service;

import br.newtonpaiva.JWT_Security_RESTAPI.model.LoginRequest;
import br.newtonpaiva.JWT_Security_RESTAPI.repository.SecurityRepository;
import br.newtonpaiva.JWT_Security_RESTAPI.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private SecurityRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String generateToken(String username, String role) {
        return JwtUtil.generateToken(username, role);
    }

    public String extractUsername(String token) {
        return JwtUtil.extractUsername(token);
    }

    public String extractUserRole(String token) {
        return JwtUtil.extractUserRole(token);
    }

    public String authenticateUser(String username, String password) {
        LoginRequest user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return generateToken(username, user.getRole());
        }
        return null;
    }

    public void saveUser(LoginRequest user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public LoginRequest findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
