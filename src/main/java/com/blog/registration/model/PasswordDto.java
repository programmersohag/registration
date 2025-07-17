package com.blog.registration.model;

import com.blog.registration.annotation.ValidPassword;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordDto {
    private String oldPassword;
    private String token;
    @ValidPassword
    private String newPassword;

}
