/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3.vista;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Melvin Prendas
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Gestión de Panadería");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        
        tabbedPane.addTab("Funcionarios", new FuncionarioPanel());
        tabbedPane.addTab("Productos", new ProductoPanel());
        tabbedPane.addTab("Compras", new CompraPanel());
        tabbedPane.addTab("CompraProducto", new CompraProductoPanel());
        tabbedPane.addTab("Lista Productos", new ProductoVista());
        tabbedPane.addTab("Historial de Compras", new HistorialComprasVista());
        tabbedPane.revalidate();
        tabbedPane.repaint();
        
        add(tabbedPane);
    }
}
