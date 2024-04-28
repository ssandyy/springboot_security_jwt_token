package com.ssandyy.jwtspringsecurity.service;

import com.ssandyy.jwtspringsecurity.entity.MyUser;
import com.ssandyy.jwtspringsecurity.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//public class MyUserService implements UserDetailsService {
public class MyUserService {
    private final MyUserRepository myUserRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public UserDetailsService userDetailsService(){
        return username -> myUserRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username+ "Not found..!"));
    }

//    public String addUser(MyUser userInfo){
//        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
//        myUserRepository.save(userInfo);
//        return "User added successfully";
//    }
//    public List<MyUser> getAllUser(){
//        return myUserRepository.findAll();
//    }
//    public MyUser getUser(Long id){
//        return myUserRepository.findById(id).orElse(null);
//    }





}
