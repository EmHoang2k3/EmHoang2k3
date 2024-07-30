package com.item.beststorezz.service.impl;

import com.item.beststorezz.dto.EmloyeeDTO;
import com.item.beststorezz.models.Users;
import com.item.beststorezz.repository.UserRepository;
import com.item.beststorezz.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserIMPL implements ServiceUser {

   @Autowired
    private UserRepository userRepository;

   @Override
    public String addusers(EmloyeeDTO emloyeeDTO){
       Users users = new Users();
       users.setFirstName(emloyeeDTO.getFirstName());
       users.setLastName(emloyeeDTO.getLastName());
       users.setEmail(emloyeeDTO.getEmail());
       users.setPassword(emloyeeDTO.getPassword());
        users.setAddress(emloyeeDTO.getAddress());
       Users users1 = userRepository.save(users);
       return String.valueOf(users1.getId());
   }

   @Override
    public Users login(String email, String password){
       Users users = userRepository.findByEmail(email);

       if(users != null && users.getPassword().equals(password)){
           return users;
       }
       return null;
   }

}
