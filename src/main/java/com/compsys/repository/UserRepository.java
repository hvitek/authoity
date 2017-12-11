package com.compsys.repository;

import com.compsys.model.User;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<User, Long> {

    User save(User sale);

    List<User> findAll();
    
    User findByNicknameAndPassword(String nickname, String password);
    
    
}
