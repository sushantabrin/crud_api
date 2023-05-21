package com.abrin.crudapi.controller;

import com.abrin.crudapi.models.User;
import com.abrin.crudapi.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class APIController {

    @Autowired
    private UserRepo userRepo ;

    @GetMapping("/")
    public String getPage() {
        return "Welcome!";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
       return userRepo.findAll() ;
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        userRepo.save(user) ;
        return "User saved successfully..." ;
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user) {
        User updatedUser = userRepo.findById(id).get() ;
        updatedUser.setAge(user.getAge());
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setOccupation(user.getOccupation());
        userRepo.save(updatedUser) ;
        return "User updated successfully...";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        User deletedUser = userRepo.findById(id).get() ;
        userRepo.delete(deletedUser);
        return "User deleted successfully..." ;
    }

}
