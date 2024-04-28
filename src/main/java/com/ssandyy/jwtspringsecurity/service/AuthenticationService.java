package com.ssandyy.jwtspringsecurity.service;


import com.ssandyy.jwtspringsecurity.dto.SignUpRequest;
import com.ssandyy.jwtspringsecurity.entity.MyUser;
import com.ssandyy.jwtspringsecurity.entity.Role;
import com.ssandyy.jwtspringsecurity.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final MyUserRepository myUserRepository;
    private final PasswordEncoder passwordEncoder;

    public MyUser signUp(SignUpRequest signUpRequest){
        MyUser myUser = new MyUser();
        myUser.setFname(signUpRequest.getFName());
        myUser.setLname(signUpRequest.getLName());
        myUser.setEmail(signUpRequest.getEmail());
        myUser.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        myUser.setRole(Role.USER);

        return myUserRepository.save(myUser);
    }


}
