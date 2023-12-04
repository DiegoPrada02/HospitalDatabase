/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import java.sql.*;
/**
 *
 * @author diego
 */
public class DatabaseConnect {
    
    public Connection database;
    private String url = "jdbc:mysql://localhost:3306/hospital";
    private String username = "root";
    private String password = "qq??2345";
    
    public DatabaseConnect(){
        database = null; 
        connect();
    }
    
    
    
    
    
    
    protected void connect(){
        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the database
            database = DriverManager.getConnection(url, username, password);

            // Check if the connection is successful
            if (database != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to connect to the database!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
    }
        
    
        
    
    
}
