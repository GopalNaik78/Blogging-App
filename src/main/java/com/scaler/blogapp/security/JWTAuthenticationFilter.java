package com.scaler.blogapp.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class JWTAuthenticationFilter extends AuthenticationFilter {

    private JWTAuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(JWTAuthenticationManager authenticationManager) {
        super(authenticationManager, new JWTAuthenticationConverter());
        this.setSuccessHandler((request, response, authentication) -> {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        });
    }

}
