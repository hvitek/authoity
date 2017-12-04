package com.compsys.repository;

import com.compsys.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends Repository<User, Long> {

    User save(User sale);

    List<User> findAll();
    
    
    @Query("SELECT nickname FROM User u where u.nickname = :username and u.password = :password")
    List<User>  findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
