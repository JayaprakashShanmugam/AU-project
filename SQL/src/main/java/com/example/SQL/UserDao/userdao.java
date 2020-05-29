package com.example.SQL.UserDao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.SQL.model.User;

@Repository
public interface userdao extends CrudRepository<User,Integer> {

}
