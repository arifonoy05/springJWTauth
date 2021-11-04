package com.example.authentication.service;

import com.example.authentication.domain.Role;
import com.example.authentication.domain.User;
import com.example.authentication.repository.RoleRepository;
import com.example.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired private UserRepository userRepository;
    @Autowired private RoleRepository roleRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("USER_NOT_FOUND")
        );
    }

    public User findByName(String name){
        return userRepository.findByName(name);
    }

    public User saveUser(User user){
        addDefaultRole(user);
        return userRepository.save(user);
    }

    public String deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("USER_NOT_FOUND")
        );
        userRepository.delete(user);

        return "User "+ user.getName() + " has been deleted";
    }

    public User updateUser(User user, Long id){
        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("USER_NOT_FOUND")
        );

        existingUser.setName(user.getName());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
//        existingUser.setRoles(user.getRoles());

        return userRepository.save(existingUser);
    }

    public void addDefaultRole(User user){
        Role defaultRole = roleRepository.findByName("USER");
        user.addRole(defaultRole);
    }

    public void addInitialsOnStartUp(){
        Role adminRole = new Role();
        adminRole.setName("ADMIN");

        User adminUser = new User();
        adminUser.setName("admin");
        adminUser.setPassword("admin123");
        adminUser.setEmail("admin@gg.gg");
        adminUser.addRole(adminRole);
        userRepository.save(adminUser);

        Role userRole = new Role();
        userRole.setName("USER");
        roleRepository.save(userRole);
    }
}
