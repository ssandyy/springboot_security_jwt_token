package com.ssandyy.jwtspringsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi/user")
@RequiredArgsConstructor
public class MyUserController {

//    private MyUserService userService;

//    @GetMapping("/{id}")
//    public MyUser getUserById(@PathVariable Long id) {
//        return userService.getUser(id);
//    }

//@PostMapping("/login")
//public String addUser(@RequestBody AuthRequest authRequest){
//    Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
//    if(authenticate.isAuthenticated()){
//        return jwtService.generateToken(authRequest.getUserName());
//    }else {
//        throw new UsernameNotFoundException("Invalid user request");
//    }
//}



}
