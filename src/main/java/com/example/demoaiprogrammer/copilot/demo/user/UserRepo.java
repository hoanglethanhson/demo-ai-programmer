package com.example.demoaiprogrammer.copilot.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    //find by msisdn return Optional<User>
    Optional<User> findByMsisdn(String msisdn);
}
