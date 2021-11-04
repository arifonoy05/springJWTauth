package com.example.authentication.controller;

import com.example.authentication.domain.Role;
import com.example.authentication.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired private RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/id/{id}")
    public Role getRoleById(@PathVariable(value = "id") Long id){
        return roleService.findById(id);
    }

    @GetMapping("/name/{name}")
    public Role getByRoleName(@PathVariable(value = "name") String roleName){
        return roleService.findByRoleName(roleName);
    }

    @PostMapping("/save")
    public Role saveRole(@RequestBody Role role){
        return roleService.saveRole(role);
    }

    @PutMapping("/{id}/update")
    public Role updateRole(@RequestBody Role role,@PathVariable(value = "id") Long id){
        return roleService.updateRole(role, id);
    }

    @DeleteMapping("/{id}/delete")
    public String deleteRole(@PathVariable(value = "id") Long id){
        return roleService.deleteRole(id);
    }
}
