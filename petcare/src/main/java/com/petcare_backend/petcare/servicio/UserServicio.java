package com.petcare_backend.petcare.servicio;

import com.petcare_backend.petcare.modelo.User;
import java.util.List;

public interface UserServicio {
    User saveUser(User user);
    User findUserById(Long id);
    List<User> findAllUsers();
    void deleteUser(Long id);
}
