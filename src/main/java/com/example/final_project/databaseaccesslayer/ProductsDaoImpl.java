package com.example.final_project.databaseaccesslayer;

import com.example.final_project.models.ProductsDTO;
import com.example.final_project.services.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductsDaoImpl {
    public List<ProductsDTO> getAllProducts() {
        List<ProductsDTO> products = new ArrayList<>();
        try {
            Connection con = DataSource.getConnection();
            String sql = "select * from products";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductsDTO productsDTO = new ProductsDTO();
                productsDTO.setProduct_id(rs.getInt("product_id"));
                productsDTO.setProduct_name(rs.getString("product_name"));
                productsDTO.setUpdated_at(rs.getString("updated_at"));
                productsDTO.setPrice(rs.getDouble("price"));
                products.add(productsDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<ProductsDTO> getAllProducts2() {
        List<ProductsDTO> products = new ArrayList<>();
        try {
            Connection con = DataSource.getConnection();
            String sql = "select * from view_products";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductsDTO productsDTO = new ProductsDTO();
                productsDTO.setProduct_id(rs.getInt("product_id"));
                productsDTO.setProduct_name(rs.getString("product_name"));
                productsDTO.setPrice(rs.getDouble("price"));
                products.add(productsDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}
