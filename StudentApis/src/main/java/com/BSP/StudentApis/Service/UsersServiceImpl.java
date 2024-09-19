package com.BSP.StudentApis.Service;

import com.BSP.StudentApis.Entity.Users;
import com.BSP.StudentApis.Repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    AuthenticationManager authenticationManager;
   @Autowired
    private JWTService jwtService;
    @Override
    public Users addUser(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public String verify(Users users) {
        try {
            // Authenticate the user using the authentication manager
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword())
            );

            // If authentication is successful
            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(users.getUsername());
            }
        } catch (AuthenticationException e) {
            // Log the exception and return failure
            // Consider using a logger like Log4j or SLF4J to log this exception
            System.out.println("Authentication failed: " + e.getMessage());
        }

        // Return "fail" if authentication was not successful
        return "fail";
    }


}
