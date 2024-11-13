package com.example.final_project.repositories;

import com.example.final_project.databaseaccesslayer.RoleDaoImpl;
import com.example.final_project.databaseaccesslayer.UsersDaoImpl;
import com.example.final_project.models.UsersDTO;
import com.example.final_project.services.Utility;

public class AuthenticationRepo {
    public UsersDTO checkLoginData(String email, String pwd) {
        if (Utility.isNullOrEmpty(email) || Utility.isNullOrEmpty(pwd)) {
            throw new IllegalArgumentException("**Username or password can not be empty**");
        }
        UsersDaoImpl usersDao = new UsersDaoImpl();
        UsersDTO user = usersDao.checkAuthenticationByUsernameAndPwd(email, pwd);
        if (user == null) {
            throw new IllegalArgumentException("**Username or password is incorrect**");
        }
//        if (user.getStatus() != 1) {
//            throw new IllegalArgumentException("**User account is suspended**");
//        }
        return user;
    }

    public String returnUserRole(int uid) {
        RoleDaoImpl roleDao = new RoleDaoImpl();
        return roleDao.returnRoleName(uid);
    }
}
