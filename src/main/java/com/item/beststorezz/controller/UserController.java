package com.item.beststorezz.controller;


import com.item.beststorezz.models.Users;
import com.item.beststorezz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public List<Users> GetAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id){
        Optional<Users> users = userService.findById(id);
        return users.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/user/add")
    public Users addUser(@RequestBody Users user){
        return userService.addUser(user);
    }

    @PutMapping("/user/edit/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id,@RequestBody Users users){
        Optional<Users> user = userService.findById(id);
        if(user.isPresent()){
            Users userUpdate = user.get();
            userUpdate.setFirstName(users.getFirstName());
            userUpdate.setLastName(users.getLastName());
            userUpdate.setEmail(users.getEmail());
            userUpdate.setAddress(users.getAddress());
            userUpdate.setPassword(users.getPassword());
            return ResponseEntity.ok(userService.addUser(userUpdate));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/user/byFirstName")
    public ResponseEntity<List<Users>> searchByFirstName(@RequestParam(name = "firstName") String firstName) {
        List<Users> users = userService.searchByFirstName(firstName);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/search/user/byLastName")
    public ResponseEntity<List<Users>> searchByLastName(@RequestParam(name = "lastName") String lastName) {
        List<Users> users = userService.searchByLastName(lastName);
        return ResponseEntity.ok(users);
    }



}
