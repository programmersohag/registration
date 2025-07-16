package com.blog.registration.model;

import com.blog.registration.annotation.ValidPassword;
import lombok.Getter;

@Getter
public class PasswordDto {

    private String oldPassword;

    @ValidPassword
    private String newPassword;

}
