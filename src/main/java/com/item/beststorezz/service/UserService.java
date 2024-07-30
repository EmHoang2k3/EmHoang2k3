package com.item.beststorezz.service;

import com.item.beststorezz.dto.EmloyeeDTO;
import com.item.beststorezz.models.Users;
import com.item.beststorezz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> findAll(){
        return userRepository.findAll();
    }
    public Optional<Users> findById(Long id){
        return userRepository.findById(id);
    }
    public Users addUser(Users user){
        return userRepository.save(user);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
    public List<Users> searchByFirstName(String firstName) {
        return userRepository.findByFirstNameContainingIgnoreCase(firstName);
    }

    public List<Users> searchByLastName(String lastName) {
        return userRepository.findByLastNameContainingIgnoreCase(lastName);
    }

    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

