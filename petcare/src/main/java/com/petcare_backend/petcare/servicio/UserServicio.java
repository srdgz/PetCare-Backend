package com.petcare_backend.petcare.servicio;

import com.petcare_backend.petcare.modelo.User;
import java.util.List;

public interface UserServicio {
    User register(User user);
    User saveUser(User user);
    User saveUserWithoutEncoder(User user);
    User findUserById(Long id);
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    List<User> findAllUsers();
    User updateUser(Long id, User userDetails);
    void deleteUser(Long id);
}
