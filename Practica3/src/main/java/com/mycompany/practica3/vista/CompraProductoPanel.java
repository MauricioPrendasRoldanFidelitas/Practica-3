/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3.vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.practica3.controlador.CompraProductoControlador;
import com.mycompany.practica3.modelo.CompraProducto;
/**
 *
 * @author Melvin Prendas
 */
public class CompraProductoPanel extends JPanel {
    private CompraProductoControlador compraProductoControlador;
    private JTextField idCompraField, idProductoField, cantidadField;
    private JTextArea compraProductoListArea;

    public CompraProductoPanel() {
        compraProductoControlador = new CompraProductoControlador();
        setLayout(new BorderLayout());

        // Panel de entrada de datos
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        
        inputPanel.add(new JLabel("ID Compra:"));
        idCompraField = new JTextField();
        inputPanel.add(idCompraField);
        
        inputPanel.add(new JLabel("ID Producto:"));
        idProductoField = new JTextField();
        inputPanel.add(idProductoField);
        
        inputPanel.add(new JLabel("Cantidad:"));
        cantidadField = new JTextField();
        inputPanel.add(cantidadField);
        
        JButton addButton = new JButton("Agregar Producto a Compra");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idCompra = Integer.parseInt(idCompraField.getText());
                int idProducto = Integer.parseInt(idProductoField.getText());
                int cantidad = Integer.parseInt(cantidadField.getText());
                compraProductoControlador.agregarCompraProducto(idCompra, idProducto, cantidad);
                actualizarListaCompraProductos();
            }
        });
        inputPanel.add(addButton);
        
        add(inputPanel, BorderLayout.NORTH);

        // Área de visualización de compra-producto
        compraProductoListArea = new JTextArea();
        compraProductoListArea.setEditable(false);
        actualizarListaCompraProductos();
        add(new JScrollPane(compraProductoListArea), BorderLayout.CENTER);
    }

    private void actualizarListaCompraProductos() {
        compraProductoListArea.setText("");
        compraProductoControlador.mostrarCompraProductos();
    }
}
