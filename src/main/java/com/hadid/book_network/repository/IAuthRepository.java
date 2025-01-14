package com.hadid.book_network.repository;

import com.hadid.book_network.entity.auth.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAuthRepository extends JpaRepository<Auth, Long> {

    Optional<Auth> findByToken(String token);

}
