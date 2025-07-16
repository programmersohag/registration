package com.blog.registration.model;

import com.blog.registration.annotation.PasswordMatches;
import com.blog.registration.annotation.ValidEmail;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@PasswordMatches
public class UserDto {
    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;
    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;
    private boolean enabled;
    private boolean isUsing2FA;
    private String secret;
}
