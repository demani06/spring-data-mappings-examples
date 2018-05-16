package com.deepak.springdataonetoonemappingexamples.controller;

import com.deepak.springdataonetoonemappingexamples.domain.User;
import com.deepak.springdataonetoonemappingexamples.domain.UserProfile;
import com.deepak.springdataonetoonemappingexamples.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable("id") long id){
        return userRepository.findById(id);
    }



    @GetMapping("/update")
    public String updateObject(){
        User user1 = userRepository.getOne(145l);
        UserProfile profile = user1.getUserProfile();
        User user = new User(145L, "Deepak", "Emani", "rajeev@callicoder.com",
                "MY_SUPER_SECRET_PASSWORD");
        /*profile.setCity("Hyderabad");
        user1.setPassword("Pass");
        user1.setUserProfile(profile);*/
        userRepository.save(user);
        return "Success";
    }
}
