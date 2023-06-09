package com.springboot.BlogApplication.Controller;

import com.springboot.BlogApplication.DTO.LoginDTO;
import com.springboot.BlogApplication.DTO.RegisterDTO;
import com.springboot.BlogApplication.Payload.JwtAuthResponse;
import com.springboot.BlogApplication.Service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Tag(name="Authentication - Generate JWT Token")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = {"/login", "/signin"})
    @Operation(summary = "Login/Signin REST API", description = "This API is used to login or signin existing user, generates JWT token for authentication")
    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDTO loginDTO){
        String token = authService.login(loginDTO);
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }

    @PostMapping(value = {"/register", "/signup"})
    @Operation(summary = "Register/Signup REST API", description = "This API is used to register/signup new user")
    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO){
        String response = authService.register(registerDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
