package com.ssandyy.jwtspringsecurity.controller;

import com.ssandyy.jwtspringsecurity.dto.JwtAuthenticationResponse;
import com.ssandyy.jwtspringsecurity.dto.SignInRequest;
import com.ssandyy.jwtspringsecurity.dto.SignUpRequest;
import com.ssandyy.jwtspringsecurity.entity.MyUser;
import com.ssandyy.jwtspringsecurity.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<MyUser> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.signin(signInRequest));
    }
}
