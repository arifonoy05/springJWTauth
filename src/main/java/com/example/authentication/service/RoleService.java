package com.example.authentication.service;

import com.example.authentication.domain.Role;
import com.example.authentication.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoleService {
    @Autowired private RoleRepository roleRepository;

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    public Role findById(Long id){
        return roleRepository.findById(id).orElseThrow(
                ()-> new NoSuchElementException("ROLE_NOT_FOUND")
        );
    }

    public Role findByRoleName(String name){
        return roleRepository.findByName(name);
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

    public String deleteRole(Long id){
        Role role = roleRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("ROLE_NOT_FOUND")
        );
        roleRepository.delete(role);
        return "Role "+ role.getName() + " has been deleted";
    }

    public Role updateRole(Role role, Long id){
        Role existingRole = roleRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("ROLE_NOT_FOUND")
        );
        existingRole.setName(role.getName());
        return roleRepository.save(existingRole);
    }
}
