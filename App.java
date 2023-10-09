package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class App {
    public static void main(String[] args) {
        connection();
    }
    public static void connection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("Driver Found"); just to check driver availability
            
            String url = "jdbc:mysql://localhost:3306/mybase";
            String user = "root";
            String pass = "";
            Connection conn = DriverManager.getConnection(url, user, pass);
            String creatDb = "Create database firstDB";
            PreparedStatement stmat = conn.prepareStatement(creatDb);
            ResultSet rs = stmat.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID"));
                System.out.println("name: " + rs.getString("name"));
                System.out.println("Contact: " + rs.getString("cont"));
                System.out.println("Address: " + rs.getString("Address"));
            }
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Driver Not Found");
        }
    }
}
