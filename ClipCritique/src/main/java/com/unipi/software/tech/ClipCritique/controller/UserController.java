package com.unipi.software.tech.ClipCritique.controller;

import com.unipi.software.tech.ClipCritique.model.authentication.LoginRequest;
import com.unipi.software.tech.ClipCritique.model.authentication.RegisterRequest;
import com.unipi.software.tech.ClipCritique.model.Role;
import com.unipi.software.tech.ClipCritique.model.User;
import com.unipi.software.tech.ClipCritique.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/email/{encodedEmail}")
    public Optional<User> getUserByEmail(@PathVariable("encodedEmail") String encodedEmail){
        return userService.getUserByEmail(encodedEmail);
    }

    @GetMapping(path = "/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> updateUser(@PathVariable("id") Long user_id, @RequestBody User user){
        userService.updateUser(user_id,user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long user_id){
        userService.deleteUser(user_id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long user_id) {
        return userService.getUserById(user_id);
    }

    @GetMapping("/getAllRoles")
    public ResponseEntity<Role[]> getAllRoles() {
        return ResponseEntity.ok().body(Role.values());
    }

    @PostMapping("/")
    public ResponseEntity<Void> addUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest){
        return userService.login(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> login(@RequestBody RegisterRequest registerRequest){
        userService.register(registerRequest);
        return ResponseEntity.ok().build();
    }

}
