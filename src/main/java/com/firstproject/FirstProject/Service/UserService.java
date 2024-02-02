package com.firstproject.FirstProject.Service;

import com.firstproject.FirstProject.Entity.User;
import com.firstproject.FirstProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
