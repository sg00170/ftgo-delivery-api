package com.sg00170.delivery.dto.request.auth;

import com.sg00170.delivery.validation.constraints.ExistsField;
import com.sg00170.delivery.validation.constraints.Password;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@ExistsField(table = "users", field = "username", message = "존재하지않는 사용자입니다.")
@Getter @Setter
public class SignInRequest {
    @NotBlank(message = "사용자명은 필수입니다.")
    private String username;

    @NotBlank(message = "비밀번호는 필수입니다.")
    @Password
    private String password;
}