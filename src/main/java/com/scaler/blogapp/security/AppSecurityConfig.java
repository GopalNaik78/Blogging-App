package com.scaler.blogapp.security;

import com.scaler.blogapp.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@Configuration
//@EnableWebSecurity
//public class AppSecurityConfig  {
////    private JWTAuthenticationFilter jwtAuthenticationFilter;
//    private JWTService jwtService;
//    private UsersService usersService;
//
////    public AppSecurityConfig(JWTAuthenticationFilter jwtAuthenticationFilter, JWTService jwtService, UsersService usersService) {
////        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
////        this.jwtService = jwtService;
////        this.usersService = usersService;
////    }
////public AppSecurityConfig(JWTService jwtService, UsersService usersService) {
////    this.jwtService = jwtService;
////    this.usersService = usersService;
////    this.jwtAuthenticationFilter = new JWTAuthenticationFilter(
////            new JWTAuthenticationManager(jwtService, usersService));
////}
//@Autowired
//public AppSecurityConfig(JWTService jwtService, UsersService usersService) {
//    this.jwtService = jwtService;
//    this.usersService = usersService;
//}
//
//    @Bean
//    public JWTAuthenticationFilter jwtAuthenticationFilter() {
//        return new JWTAuthenticationFilter(new JWTAuthenticationManager(jwtService, usersService));
//    }
//
////    @Bean
////    JWTAuthenticationFilter jwtAuthenticationFilter() throws Exception {
////        return new JWTAuthenticationFilter(
////                new JWTAuthenticationManager(jwtService, usersService)
////        );
////    }
////@Bean
////public JWTAuthenticationFilter jwtAuthenticationFilter() {
////    return new JWTAuthenticationFilter(new JWTAuthenticationManager(jwtService, usersService));
////}
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
//    {
//        http
//                .securityMatcher("/users/","/users/login/","/articles/","/articles/*")
//                .authorizeHttpRequests((authz)->authz
//                        .anyRequest().authenticated())
//                .addFilterBefore(jwtAuthenticationFilter(), AnonymousAuthenticationFilter.class);
//        return http.build();
//
//    }
//}

@Configuration
@EnableWebSecurity
public class AppSecurityConfig  {
    private JWTService jwtService;

    @Autowired
    public AppSecurityConfig(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @Bean
    public JWTAuthenticationManager jwtAuthenticationManager(UsersService usersService) {
        return new JWTAuthenticationManager(jwtService, usersService);
    }

    @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter(JWTAuthenticationManager jwtAuthenticationManager) {
        return new JWTAuthenticationFilter(jwtAuthenticationManager);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JWTAuthenticationFilter jwtAuthenticationFilter) throws Exception {
        http
                .securityMatcher("/users/", "/users/login/", "/articles/", "/articles/*")
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().authenticated())
                .addFilterBefore(jwtAuthenticationFilter, AnonymousAuthenticationFilter.class);
        return http.build();
    }
}
