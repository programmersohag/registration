package com.blog.registration.service;


import com.blog.registration.model.PasswordResetToken;
import com.blog.registration.repository.PasswordResetTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

@Service
@Transactional
public class UserSecurityService {

    private final PasswordResetTokenRepository passwordTokenRepository;

    public UserSecurityService(PasswordResetTokenRepository passwordTokenRepository) {
        this.passwordTokenRepository = passwordTokenRepository;
    }


    public String validatePasswordResetToken(String token) {
        final PasswordResetToken passToken = passwordTokenRepository.findByToken(token);

        return !isTokenFound(passToken) ? "invalidToken"
                : isTokenExpired(passToken) ? "expired"
                : null;
    }

    private boolean isTokenFound(PasswordResetToken passToken) {
        return passToken != null;
    }

    private boolean isTokenExpired(PasswordResetToken passToken) {
        final Calendar cal = Calendar.getInstance();
        return passToken.getExpiryDate().before(cal.getTime());
    }
}
