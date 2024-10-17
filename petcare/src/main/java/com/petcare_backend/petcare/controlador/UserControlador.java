package com.petcare_backend.petcare.controlador;

import com.petcare_backend.petcare.modelo.User;
import com.petcare_backend.petcare.servicio.UserServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserControlador {

    private final UserServicio userServicio;

    @Autowired
    public UserControlador(UserServicio userService) {
        this.userServicio = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userServicio.saveUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userServicio.findUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userServicio.findAllUsers();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userServicio.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
