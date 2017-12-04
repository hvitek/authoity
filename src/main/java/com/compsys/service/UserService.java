package com.compsys.service;

import com.compsys.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> getList();
    

	User getUserByUsernamePassword(String username, String password);

}
