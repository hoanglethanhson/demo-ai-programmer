package com.example.demoaiprogrammer.copilot.demo.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    //create register user method, throw exception if user msisdn already exist
    public void registerUser(User user){
        //check if user msisdn already exist
        if(userRepo.findByMsisdn(user.getMsisdn()).isPresent()){
            throw new RuntimeException("User already exist");
        }
        userRepo.save(user);
    }

    //create delete user method, throw exception if user msisdn not exist
    public void deleteUser(User user){
        //check if user msisdn not exist
        if(userRepo.findByMsisdn(user.getMsisdn()).isEmpty()){
            throw new RuntimeException("User not exist");
        }
        userRepo.delete(user);
    }
}
