package com.instagram.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static Connection connection = null;

    public  static Connection getConnection()throws SQLException{
        if(connection!=null){
            return connection;
        }
        else {
            String driver="com.mysql.cj.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/instagram?useSSl=false";
            String username="root";
            String password="pass123";
            try{
                Class.forName(driver);
                connection= DriverManager.getConnection(url,username,password);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

}
