package com.petcare_backend.petcare.repositorio;

import com.petcare_backend.petcare.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositorio extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
    User findUserByEmail(String email);
}
