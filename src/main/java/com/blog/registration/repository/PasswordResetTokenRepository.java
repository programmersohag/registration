package com.blog.registration.repository;

import com.blog.registration.model.PasswordResetToken;
import com.blog.registration.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PasswordResetTokenRepository extends CrudRepository <PasswordResetToken, Long> {

    PasswordResetToken findByUser(User user);

    PasswordResetToken findByToken(String token);
}