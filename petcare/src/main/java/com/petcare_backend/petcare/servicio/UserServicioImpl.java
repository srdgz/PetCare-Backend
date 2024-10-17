package com.petcare_backend.petcare.servicio;

import com.petcare_backend.petcare.modelo.User;
import com.petcare_backend.petcare.repositorio.UserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicioImpl implements UserServicio {

    private final UserRepositorio userRepositorio;

    @Autowired
    public UserServicioImpl(UserRepositorio userRepository) {
        this.userRepositorio = userRepository;
    }

    @Override
    public User saveUser(User user) {
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
}
