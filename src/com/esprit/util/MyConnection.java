package com.esprit.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author oumaima
 */
public class MyConnection {
 
    private String url;
    private String login;
    private String password;
    private static Connection instance;

    private MyConnection() {
        try{
            url="jdbc:mysql://localhost:3306/darkom";
               password="";
               login="root";
            
                instance= DriverManager.getConnection(url, login, password);
                System.out.println("Connection established");
            } 
        catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    public static Connection getInstance() {
        if (instance == null) {
            new MyConnection();
        }
        return instance;
    }
    
}