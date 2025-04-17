package com.sg00170.delivery.dto.request;

import lombok.*;

@Getter @Setter
public class SignUpRequest {
    private String username;

    private String password;

    private String confirmPassword;
}