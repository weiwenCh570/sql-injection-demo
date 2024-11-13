package com.example.final_project.databaseaccesslayer;

import com.example.final_project.services.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoleDaoImpl {
    public String returnRoleName(int roleId){
        try{
            Connection con = DataSource.getConnection();
            String sql = "select role_name from roles where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,roleId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("role_name");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
