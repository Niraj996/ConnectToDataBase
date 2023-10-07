package practice.DataBase.prac.src.main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public  class Connect {
    public static void main(String[] args) throws SQLException {
        try {
            // Create Connection with DataBase with th help of Driver:
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/base";
            String user = "root";
            String pass = "";
            Connection conn = DriverManager.getConnection(url, user, pass);

                // need sql statement to perform a query on database.
            String sql ="select*from tbl_base";

                // create a statement and connect(sends) to the database. thus conn.create statement
            Statement stmt = conn.createStatement();
            
                ResultSet rs = stmt.executeQuery(sql);

                while(rs.next()){
                    int id = rs.getInt("id");
                    String name =rs.getString("name");

                    System.out.printf("%s \n%s " , id, name);
                }
           // System.out.println("Driver Found");
        } catch (ClassNotFoundException ce) {
            System.out.println("Driver not Found");
            System.out.println(ce.getMessage());     

        }
}
}
             
