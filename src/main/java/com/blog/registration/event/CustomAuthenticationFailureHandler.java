package com.blog.registration.event;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final MessageSource messages;
    private final LocaleResolver localeResolver;

    public CustomAuthenticationFailureHandler(@Qualifier("messageSource") MessageSource messages, LocaleResolver localeResolver) {
        this.messages = messages;
        this.localeResolver = localeResolver;
    }

    @Override
    public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException exception) throws IOException, ServletException {
        setDefaultFailureUrl("/login?error=true");
        super.onAuthenticationFailure(request, response, exception);
        final Locale locale = localeResolver.resolveLocale(request);
        String errorMessage = messages.getMessage("message.badCredentials", null, locale);
        if (exception.getMessage().equalsIgnoreCase("User is disabled")) {
            errorMessage = messages.getMessage("auth.message.disabled", null, locale);
        } else if (exception.getMessage().equalsIgnoreCase("User account has expired")) {
            errorMessage = messages.getMessage("auth.message.expired", null, locale);
        } else if (exception.getMessage().equalsIgnoreCase("blocked")) {
            errorMessage = messages.getMessage("auth.message.blocked", null, locale);
        }
        request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, errorMessage);
    }
}
