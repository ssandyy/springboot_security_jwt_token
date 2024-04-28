package com.ssandyy.jwtspringsecurity.repository;

import com.ssandyy.jwtspringsecurity.entity.MyUser;
import com.ssandyy.jwtspringsecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByEmail(String username);
    MyUser findByRole(Role role);
}
