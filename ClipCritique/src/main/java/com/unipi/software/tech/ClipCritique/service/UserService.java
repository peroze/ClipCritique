package com.unipi.software.tech.ClipCritique.service;

import com.unipi.software.tech.ClipCritique.exception.InvalidCredentialsException;
import com.unipi.software.tech.ClipCritique.model.Role;
import com.unipi.software.tech.ClipCritique.model.User;
import com.unipi.software.tech.ClipCritique.model.authentication.LoginRequest;
import com.unipi.software.tech.ClipCritique.model.authentication.RegisterRequest;
import com.unipi.software.tech.ClipCritique.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findUserById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long user_id) {
        if (userRepository.findUserById(user_id).isEmpty()) {
            throw new IllegalArgumentException("The given user does not exist");
        }
        userRepository.deleteById(user_id);
    }

    public void updateUser(long id, User userUpd) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("The User does not exist"));
        if (userUpd.getEmail() != null && !userUpd.getEmail().isEmpty()) {
            user.setEmail(userUpd.getEmail());
        }
        if (userUpd.getFullName() != null && !userUpd.getFullName().isEmpty()) {
            user.setFullName(userUpd.getFullName());
        }
        if (userUpd.getRole() != null) {
            user.setRole(userUpd.getRole());
        }

        userRepository.save(user);
    }


    public User addUser(User user) {
        User createdUser = User.builder()
                .dateOfBirth(user.getDateOfBirth())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .build();

        return userRepository.save(createdUser);
    }

    public ResponseEntity<User> login(LoginRequest loginRequest) {

        User user = userRepository.findUserByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new IllegalStateException("User was not found"));
        if (user.getEmail().equals(loginRequest.getEmail()) && user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(user);
        } else {
            throw new InvalidCredentialsException("Invalid credentials");
        }

    }

    public User register(RegisterRequest registerRequest) {
        Optional<User> user1 = userRepository.findUserByEmail(registerRequest.getEmail());
        if (user1.isPresent()) {
            throw new IllegalStateException("User already exists");
        }
        User user = User.builder()
                .password(registerRequest.getPassword())
                .email(registerRequest.getEmail())
                .dateOfBirth(registerRequest.getDateOfBirth())
                .role(Role.USER)
                .build();

        return userRepository.save(user);
    }

    public List<User> findUserByAge(LocalDate dateofbirth) {
        LocalDate younger = dateofbirth.minusYears(30);
        LocalDate older = dateofbirth.plusYears(30);
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getDateOfBirth().getYear() - older.getYear() <= 5 && user.getDateOfBirth().getYear() - older.getYear() <= 0) {
                continue;
            } else {
                if (younger.getYear() - user.getDateOfBirth().getYear() <= 5 && younger.getYear() - user.getDateOfBirth().getYear() >= 0 ) {
                    continue;
                } else {
                    users.remove(user);
                }
            }
        }
        return users;
    }
}
