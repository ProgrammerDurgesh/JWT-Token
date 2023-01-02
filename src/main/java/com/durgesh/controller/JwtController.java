package com.durgesh.controller;

import com.durgesh.Services.CustomUserDetailsServices;
import com.durgesh.helper.JwtUtil;
import com.durgesh.model.JwtRequest;
import com.durgesh.model.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsServices customUserDetailsServices;

    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        System.out.println(jwtRequest);
        System.out.println(jwtRequest.getUserName());
        System.out.println(jwtRequest.getPassword());

        try
        {

            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(),
                    jwtRequest.getPassword()));
        }
        catch (UsernameNotFoundException e)
        {
            e.printStackTrace();
            throw  new Exception("Bad Credentials");
        }

        UserDetails userDetails =this.customUserDetailsServices.loadUserByUsername(jwtRequest.getUserName());

        String token=this.jwtUtil.generateToken(userDetails);
        System.out.println("Jwt Token :        "+token);


        return  ResponseEntity.ok(new JwtResponse(token));
    }
}
