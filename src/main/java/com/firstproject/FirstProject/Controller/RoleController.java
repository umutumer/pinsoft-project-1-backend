package com.firstproject.FirstProject.Controller;

import com.firstproject.FirstProject.Entity.Role;
import com.firstproject.FirstProject.Service.RoleService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    @PermitAll
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
    @GetMapping("/roles/{id}")
    @PermitAll
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Optional<Role> roleOptional = roleService.getRoleById(id);
        if (roleOptional.isPresent()) {
            return new ResponseEntity<>(roleOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
