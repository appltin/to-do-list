package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean autenticate(String username, String password){

        boolean isvalidUser = username.equalsIgnoreCase("in28minutes");
        boolean isvalidPassword = password.equalsIgnoreCase("dummy");

        return isvalidUser && isvalidPassword;
    }
}
