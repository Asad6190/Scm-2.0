package com.scm.repositories;

import com.scm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    //Extra methods db related
    //or custom query

    Optional<User> findByEmail(String email);


    Optional<User> findByEmailAndPassword(String email,String password);
}
