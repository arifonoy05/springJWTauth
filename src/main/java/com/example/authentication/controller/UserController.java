package com.example.authentication.controller;

import com.example.authentication.domain.User;
import com.example.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired private UserService userService;

    @PostConstruct
    public void addInitialsOnStartUp(){
        userService.addInitialsOnStartUp();
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/id/{id}")
    public User findById(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }

    @GetMapping("/name/{name}")
    public User findByName(@PathVariable(value = "name") String name){
        return userService.findByName(name);
    }

    @PostMapping("/register")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable(value = "id") Long id){
        return userService.deleteUser(id);
    }

    @PutMapping("/{id}/update")
    public User updateUser(@RequestBody User user,@PathVariable(value = "id") Long id){
        return userService.updateUser(user, id);
    }
}
