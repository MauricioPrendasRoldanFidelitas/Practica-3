/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3.vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.practica3.controlador.ProductoControlador;
/**
 *
 * @author Melvin Prendas
 */
public class ProductoPanel extends JPanel {
    private ProductoControlador productoControlador;
    private JTextField nombreField, descripcionField, precioField;
    private JTextArea productoListArea;

    public ProductoPanel() {
        productoControlador = new ProductoControlador();
        setLayout(new BorderLayout());

        // Panel de entrada de datos
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        
        inputPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        inputPanel.add(nombreField);
        
        inputPanel.add(new JLabel("Descripción:"));
        descripcionField = new JTextField();
        inputPanel.add(descripcionField);
        
        inputPanel.add(new JLabel("Precio:"));
        precioField = new JTextField();
        inputPanel.add(precioField);
        
        JButton addButton = new JButton("Agregar Producto");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String descripcion = descripcionField.getText();
                double precio = Double.parseDouble(precioField.getText());
                productoControlador.agregarProducto(nombre, descripcion, precio);
                actualizarListaProductos();
            }
        });
        inputPanel.add(addButton);
        
        add(inputPanel, BorderLayout.NORTH);

        // Área de visualización de productos
        productoListArea = new JTextArea();
        productoListArea.setEditable(false);
        actualizarListaProductos();
        add(new JScrollPane(productoListArea), BorderLayout.CENTER);
    }

    private void actualizarListaProductos() {
        productoListArea.setText("");
        productoControlador.mostrarProductos();
    }
}