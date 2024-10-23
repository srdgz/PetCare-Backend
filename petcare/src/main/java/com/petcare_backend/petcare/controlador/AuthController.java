package com.petcare_backend.petcare.controlador;

import com.petcare_backend.petcare.modelo.User;
import com.petcare_backend.petcare.servicio.UserServicio;
import com.petcare_backend.petcare.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserServicio userServicio;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody User user) {
        try {
            User newUser = userServicio.register(user);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Usuario registrado exitosamente: " + newUser.getUsername());
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) throws Exception {
        try {
            String username = user.getUsername();
            String pass = user.getPassword();
            UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(username, pass);
            authenticationManager.authenticate(userToken);

            final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            String token = jwtUtil.generateToken(userDetails.getUsername());

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (Exception error) {
            throw new Exception("No se ha podido hacer login: " + error.getMessage());
        }
    }
}
