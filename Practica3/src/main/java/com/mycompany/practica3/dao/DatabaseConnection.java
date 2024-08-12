/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3.dao;
import java.sql.*;

/**
 *
 * @author Melvin Prendas
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/Panaderia"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "03042427"; 

    private static Connection connection;

    public static Connection getConnection() {
    try {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Conexión exitosa a la base de datos");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return connection;
}
    
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}