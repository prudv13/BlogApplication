package com.springboot.BlogApplication.Service;

import com.springboot.BlogApplication.DTO.LoginDTO;

public interface AuthService {
    public String login(LoginDTO loginDTO);
}
