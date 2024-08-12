/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica3.vista;
import com.mycompany.practica3.dao.DatabaseConnection;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Melvin Prendas
 */
public class Practica3  {

    public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
