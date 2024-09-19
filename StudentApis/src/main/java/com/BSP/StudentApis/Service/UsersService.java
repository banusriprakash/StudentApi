package com.BSP.StudentApis.Service;

import com.BSP.StudentApis.Entity.Users;

public interface UsersService {
    Users addUser(Users users);

    String verify(Users users);
}
