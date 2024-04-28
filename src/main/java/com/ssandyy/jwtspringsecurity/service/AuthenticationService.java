package com.ssandyy.jwtspringsecurity.service;


import com.ssandyy.jwtspringsecurity.dto.JwtAuthenticationResponse;
import com.ssandyy.jwtspringsecurity.dto.SignInRequest;
import com.ssandyy.jwtspringsecurity.dto.SignUpRequest;
import com.ssandyy.jwtspringsecurity.entity.MyUser;
import com.ssandyy.jwtspringsecurity.entity.Role;
import com.ssandyy.jwtspringsecurity.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationService extends JwtAuthenticationResponse {
    @Autowired
    private final MyUserRepository myUserRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final JwtService jwtService;

    public MyUser signUp(SignUpRequest signUpRequest){
        MyUser myUser = new MyUser();
        myUser.setFname(signUpRequest.getFName());
        myUser.setLname(signUpRequest.getLName());
        myUser.setEmail(signUpRequest.getEmail());
        myUser.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        myUser.setRole(Role.USER);
        return myUserRepository.save(myUser);
    }

    public JwtAuthenticationResponse signin(SignInRequest signInRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),
                signInRequest.getPassword()));

        var user = myUserRepository.findByEmail(signInRequest.getEmail()).orElseThrow(()->new IllegalArgumentException("Invalid email entered..!"));
        var jwt = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        JwtAuthenticationResponse authenticationResponse = new JwtAuthenticationResponse();

        authenticationResponse.setToken(jwt);
        authenticationResponse.setRefreshToken(refreshToken);
        return authenticationResponse;
    }


}
