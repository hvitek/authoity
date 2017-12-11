package com.compsys.service;


import com.compsys.model.User;
import com.compsys.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public User save(User user) {
        User created = repository.save(user);
        return created;
    }

    @Override
    public List<User> getList() {
        return repository.findAll();
    }
    
    
    @Override
    public User getUserByNicknameAndPassword(String nickname, String password) {
    	
    	//return first User from list of Users
    	User user = repository.findByNicknameAndPassword(nickname, password);
        return user;
    }
}
