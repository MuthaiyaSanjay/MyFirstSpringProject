package com.instagram.service;

import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public interface UserService {
    public int LoginValidation(String username,String password) throws SQLException;

    String getName(String uname) throws SQLException;
}
