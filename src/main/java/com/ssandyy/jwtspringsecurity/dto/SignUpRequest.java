package com.ssandyy.jwtspringsecurity.dto;

import lombok.Data;

@Data
public class SignUpRequest {
    private String fName;
    private String lName;
    private String email;
    private String password;

}
