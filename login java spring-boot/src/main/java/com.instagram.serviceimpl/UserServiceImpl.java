package com.instagram.serviceimpl;

import com.instagram.dbutil.DBUtil;
import com.instagram.service.UserService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {
    Connection connection;
    int flag;
    public  UserServiceImpl() throws SQLException {
        connection= DBUtil.getConnection();
    }
    @Override
    public int LoginValidation(String username, String password) throws SQLException {
        PreparedStatement statement=connection.prepareStatement("select * from users where username ='"+username+"'");
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            if(rs.getString(6).equals(username) && rs.getString(7).equals(password)){
                flag=1;
                System.out.println("Valid Username or Password");
            }else{
                flag=0;
                System.out.println("Invalid Username or Password");
            }
        }
        return flag;
    }

    @Override
    public String getName(String uname) throws SQLException {
        PreparedStatement statement=connection.prepareStatement("select * from users where username ='"+uname+"'");
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            if(rs.getString(6).equals(uname)){
                System.out.println(rs.getString(6));
                return "Matching  "+uname;
            }
        }
        return "Don't Matching  "+uname;
    }
}
