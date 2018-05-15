package com.deepak.springdataonetoonemappingexamples.controller;

import com.deepak.springdataonetoonemappingexamples.domain.Gender;
import com.deepak.springdataonetoonemappingexamples.domain.User;
import com.deepak.springdataonetoonemappingexamples.domain.UserProfile;
import com.deepak.springdataonetoonemappingexamples.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/update")
    public String updateObject(){


        User user1 = userRepository.getOne(145l);

        UserProfile profile = user1.getUserProfile();

        profile.setCity("Hyderabad");
        user1.setPassword("Pass");
        user1.setUserProfile(profile);
        userRepository.save(user1);
        return "Success";
    }
}
