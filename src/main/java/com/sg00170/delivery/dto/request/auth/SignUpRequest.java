package com.sg00170.delivery.dto.request.auth;

import com.sg00170.delivery.validation.constraints.Password;
import com.sg00170.delivery.validation.constraints.PasswordMatch;
import com.sg00170.delivery.validation.constraints.UniqueField;
import jakarta.validation.constraints.NotBlank;

import lombok.*;

@PasswordMatch(message = "비밀번호와 비밀번호 확인이 일치하지않습니다.")
@UniqueField(table = "users", field = "username", message = "이미 사용 중인 사용자명입니다.")
@Getter @Setter
public class SignUpRequest {
    @NotBlank(message = "사용자명은 필수입니다.")
    private String username;

    @NotBlank(message = "비밀번호는 필수입니다.")
    @Password
    private String password;

    @NotBlank(message = "비밀번호 확인은 필수입니다.")
    @Password
    private String confirmPassword;
}