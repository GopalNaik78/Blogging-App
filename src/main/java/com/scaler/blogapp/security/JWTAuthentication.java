package com.scaler.blogapp.security;

import com.scaler.blogapp.users.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class JWTAuthentication implements Authentication {
    String jwt;
    UserEntity userEntity;

    public JWTAuthentication(String jwt) {
        this.jwt = jwt;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    /**
     * Returns the credentials of the {@Code Authentication} request.
     * For eg, the password, or the Bearer token, or the cookie.
     * @return
      */
    @Override
    public String getCredentials() {
        return jwt;
    }

    @Override
    public Object getDetails() {
        return null;
    }
    /** Returns the principal of the {@code Authentication} request.
    * The "principal" is the entity that is being authenticated.
    * In this case it is the User.
     * @return
    **/

    @Override
    public UserEntity getPrincipal() {
        return userEntity;
    }

    @Override
    public boolean isAuthenticated() {
        return (userEntity != null) ;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }



    @Override
    public String getName() {
        return "";
    }


}
