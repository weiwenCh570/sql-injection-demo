package com.example.final_project.databaseaccesslayer;

import com.example.final_project.models.UsersDTO;
import com.example.final_project.services.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDaoImpl {

    public UsersDTO create(ResultSet resultSet) throws SQLException {
        UsersDTO user = new UsersDTO();
        user.setUid(resultSet.getInt("user_id"));
        user.setUser_name(resultSet.getString("user_name"));
        user.setEmail(resultSet.getString("email"));
        user.setRole(resultSet.getInt("role_id"));
        return user;
    }

    public UsersDTO checkAuthenticationByUsernameAndPwd(String username, String pwd) {
        try {
            Connection con = DataSource.getConnection();
            String sql = "select user_name,user_id,email,role_id from users where email=? and password=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pwd);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return this.create(resultSet);
            }
        } catch (Exception e) {
            // Handle exception
        }
        return null;
    }
}
