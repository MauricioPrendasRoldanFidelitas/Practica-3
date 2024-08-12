/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3.vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.practica3.controlador.CompraControlador;
import com.mycompany.practica3.modelo.Compra;
/**
 *
 * @author Melvin Prendas
 */
public class CompraPanel extends JPanel {
    private CompraControlador compraControlador;
    private JTextField idFuncionarioField, idCompraField, totalField;
    private JTextArea compraListArea;

    public CompraPanel() {
        compraControlador = new CompraControlador();
        setLayout(new BorderLayout());

        // Panel de entrada de datos
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        
        inputPanel.add(new JLabel("ID Funcionario:"));
        idFuncionarioField = new JTextField();
        inputPanel.add(idFuncionarioField);
        
        inputPanel.add(new JLabel("ID Funcionario:"));
        idFuncionarioField = new JTextField();
        inputPanel.add(idFuncionarioField);
        
        inputPanel.add(new JLabel("Total:"));
        totalField = new JTextField();
        inputPanel.add(totalField);
        
        JButton addButton = new JButton("Agregar Compra");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idCompra = Integer.parseInt(idCompraField.getText());
                int idFuncionario = Integer.parseInt(idFuncionarioField.getText());
                double total = Double.parseDouble(totalField.getText());
                compraControlador.agregarCompra(idCompra, idFuncionario, total);
                actualizarListaCompras();
            }
        });
        inputPanel.add(addButton);
        
        add(inputPanel, BorderLayout.NORTH);

        // Área de visualización de compras
        compraListArea = new JTextArea();
        compraListArea.setEditable(false);
        actualizarListaCompras();
        add(new JScrollPane(compraListArea), BorderLayout.CENTER);
    }

    private void actualizarListaCompras() {
        compraListArea.setText("");
        compraControlador.mostrarCompras();
    }
}
