package com.BSP.StudentApis.Controller;

import com.BSP.StudentApis.Entity.Users;
import com.BSP.StudentApis.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UsersService usersService;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    @PostMapping("/reg")
    public Users addUser(@RequestBody Users users){
        users.setPassword(encoder.encode(users.getPassword()));
        return usersService.addUser(users);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users users){
        return usersService.verify(users);
    }
}
