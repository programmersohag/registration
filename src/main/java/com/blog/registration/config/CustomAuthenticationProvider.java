package com.blog.registration.config;

import com.blog.registration.exception.ErrorCodes;
import com.blog.registration.exception.UserNotFoundException;
import com.blog.registration.model.User;
import com.blog.registration.repository.UserRepository;
import org.jboss.aerogear.security.otp.Totp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationProvider extends DaoAuthenticationProvider{

        @Autowired
        private UserRepository userRepository;

        @Override
        public Authentication authenticate(Authentication auth) throws AuthenticationException {
            final User user = userRepository.findByEmail(auth.getName()).orElseThrow(() ->new UserNotFoundException(auth.getName(), ErrorCodes.U_0000));
            // to verify verification code
            if (user.isUsing2FA()) {
                final String verificationCode = ((CustomWebAuthenticationDetails) auth.getDetails()).getVerificationCode();
                final Totp totp = new Totp(user.getSecret());
                if (!isValidLong(verificationCode) || !totp.verify(verificationCode)) {
                    throw new BadCredentialsException("Invalid verification code");
                }

            }
            final Authentication result = super.authenticate(auth);
            return new UsernamePasswordAuthenticationToken(user, result.getCredentials(), result.getAuthorities());
        }

        private boolean isValidLong(String code) {
            try {
                Long.parseLong(code);
            } catch (final NumberFormatException e) {
                return false;
            }
            return true;
        }

        @Override
        public boolean supports(Class<?> authentication) {
            return authentication.equals(UsernamePasswordAuthenticationToken.class);
        }
}
