package com.unipi.software.tech.ClipCritique.service;

import com.unipi.software.tech.ClipCritique.model.User;
import com.unipi.software.tech.ClipCritique.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findUserById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long user_id){
        if(userRepository.findUserById(user_id).isEmpty()){
            throw new IllegalArgumentException("The given user does not exist");
        }
        userRepository.deleteById(user_id);
    }

    public void updateUser(long id,User userUpd){
        User user=userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("The User does not exist"));
        if(userUpd.getEmail()!=null && !userUpd.getEmail().isEmpty()){
            user.setEmail(userUpd.getEmail());
        }
        if(userUpd.getFullName()!=null && !userUpd.getFullName().isEmpty()){
            user.setFullName(userUpd.getFullName());
        }
        if(userUpd.getRole()!=null){
            user.setRole(userUpd.getRole());
        }

        userRepository.save(user);
    }


    public void addUser(User user) {
        User createdUser = User.builder()
                .dateOfBirth(user.getDateOfBirth())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .build();

        userRepository.save(createdUser);
    }
}
