package com.blog.registration.model;

import com.blog.registration.annotation.ValidPassword;
import lombok.Getter;

public class PasswordDto {

    private String oldPassword;

    @ValidPassword
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }
}
