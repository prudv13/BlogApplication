package com.springboot.BlogApplication.Service;

import com.springboot.BlogApplication.DTO.LoginDTO;
import com.springboot.BlogApplication.DTO.RegisterDTO;

public interface AuthService {
    public String login(LoginDTO loginDTO);
    public String register(RegisterDTO registerDTO);
}
