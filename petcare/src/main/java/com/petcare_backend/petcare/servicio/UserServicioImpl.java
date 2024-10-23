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
        if (userRepositorio.findUserByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("El nombre de usuario ya está en uso.");
        }

        if (userRepositorio.findUserByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("El email ya está en uso.");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepositorio.save(user);
    }

    @Override
    public User saveUser(User user) {
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

    public User updateUser(Long id, User userDetails) {
        User existingUser = findUserById(id);
        if (existingUser != null) {
            if (userDetails.getPassword() != null) {
                existingUser.setPassword(userDetails.getPassword());
            }
            if (userDetails.getAvatar() != null) {
                existingUser.setAvatar(userDetails.getAvatar());
            }
            return saveUser(existingUser);
        }
        return null;
    }

    // Método adicional para buscar usuarios por nombre de usuario e email
    public User findUserByUsername(String username) {
        return userRepositorio.findUserByUsername(username);
    }

    public User findUserByEmail(String email) {
        return userRepositorio.findUserByEmail(email);
    }
}
