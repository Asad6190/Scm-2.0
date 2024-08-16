package com.scm.config;

import com.scm.services.impl.SecurityCustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;

@Configuration
public class SecurityConfig {

    @Autowired
    private SecurityCustomUserDetailService userDetailsService;

    public AuthenticationProvider authenticationProvider(){

    }




}
