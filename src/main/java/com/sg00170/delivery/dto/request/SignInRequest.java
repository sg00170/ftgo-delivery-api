package com.sg00170.delivery.dto.request;

import lombok.*;

@Getter @Setter
public class SignInRequest {
    private String username;
    private String password;
}