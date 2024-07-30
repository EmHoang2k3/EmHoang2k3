package com.item.beststorezz.service;

import com.item.beststorezz.dto.EmloyeeDTO;
import com.item.beststorezz.models.Users;

import java.util.List;

public interface ServiceUser {
    String addusers(EmloyeeDTO emloyeeDTO);

    Users login(String email, String password);

}
