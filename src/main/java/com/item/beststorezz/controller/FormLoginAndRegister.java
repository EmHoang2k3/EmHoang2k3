package com.item.beststorezz.controller;

import com.item.beststorezz.dto.EmloyeeDTO;
import com.item.beststorezz.models.Users;
import com.item.beststorezz.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class FormLoginAndRegister {

    @Autowired
    private ServiceUser serviceUser;


    @PostMapping("/register")
    public  String register(@RequestBody EmloyeeDTO emloyeeDTO){
        serviceUser.addusers(emloyeeDTO);
        return "Đăng kí thành công";
    }

    @PostMapping("/login")
    public Users login(@RequestBody EmloyeeDTO emloyeeDTO){
        return serviceUser.login(emloyeeDTO.getEmail(),emloyeeDTO.getPassword());

    }
}
