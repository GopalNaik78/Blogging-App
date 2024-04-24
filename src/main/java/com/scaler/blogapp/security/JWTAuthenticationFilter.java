package com.scaler.blogapp.security;

import org.springframework.security.web.authentication.AuthenticationFilter;

public class JWTAuthenticationFilter extends AuthenticationFilter {

    private JWTAuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(JWTAuthenticationManager authenticationManager) {
        super(authenticationManager, new JWTAuthenticationConverter());
    }
}
