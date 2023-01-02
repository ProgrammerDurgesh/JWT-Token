package com.durgesh.Services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class CustomUserDetailsServices implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals("Durgesh"))
        {
            return new User("Durgesh","Durgesh123",new ArrayList<>());
        }
        else
        {
            throw  new UsernameNotFoundException("User Not found ");
        }
    }
}
