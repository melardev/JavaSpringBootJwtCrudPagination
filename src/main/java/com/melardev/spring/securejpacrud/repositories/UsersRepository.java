package com.melardev.spring.securejpacrud.repositories;


import com.melardev.spring.securejpacrud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
