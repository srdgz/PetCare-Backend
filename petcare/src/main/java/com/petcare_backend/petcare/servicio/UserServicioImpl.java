package com.petcare_backend.petcare.servicio;

import com.petcare_backend.petcare.modelo.User;
import com.petcare_backend.petcare.repositorio.UserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicioImpl implements UserServicio {

    private final UserRepositorio userRepositorio;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServicioImpl(UserRepositorio userRepository, PasswordEncoder passwordEncoder) {
        this.userRepositorio = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        // Verificar si el nombre de usuario o el email ya están en uso
        if (userRepositorio.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("El nombre de usuario ya está en uso.");
        }

        if (userRepositorio.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("El email ya está en uso.");
        }

        // Encriptar la contraseña
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Guardar el usuario
        return userRepositorio.save(user);
    }

    @Override
    public User saveUser(User user) {
        // Encriptar la contraseña antes de guardar el usuario
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepositorio.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepositorio.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepositorio.deleteById(id);
    }

    // Método adicional para buscar usuarios por nombre de usuario
    public User findByUsername(String username) {
        return userRepositorio.findByUsername(username);
    }
}
