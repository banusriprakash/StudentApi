package com.BSP.StudentApis.Service;

import com.BSP.StudentApis.Entity.UserPrincipal;
import com.BSP.StudentApis.Entity.Users;
import com.BSP.StudentApis.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserServiceDetails implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users1=usersRepository.findByUsername(username);
        if (users1==null){
            System.out.println("USER NOT FOUND");
            throw new UsernameNotFoundException("User Not Found");
        }
        return new UserPrincipal(users1);
    }
}
