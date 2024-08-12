/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3.vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.practica3.controlador.FuncionarioControlador;
import com.mycompany.practica3.modelo.Funcionario;
/**
 *
 * @author Melvin Prendas
 */
public class FuncionarioPanel extends JPanel {
    private FuncionarioControlador funcionarioControlador;
    private JTextField contrasenaField, nombreField, usuarioField;
    private JTextArea funcionarioListArea;

    public FuncionarioPanel() {
        funcionarioControlador = new FuncionarioControlador();
        setLayout(new BorderLayout());

        // Panel de entrada de datos
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        
        inputPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        inputPanel.add(nombreField);
        
        inputPanel.add(new JLabel("Usuario:"));
        usuarioField = new JTextField();
        inputPanel.add(usuarioField);
        
        inputPanel.add(new JLabel("Contrasena:"));
        contrasenaField = new JTextField();
        inputPanel.add(contrasenaField);
        
        JButton addButton = new JButton("Agregar Funcionario");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String usuario = usuarioField.getText();
                String contrasena = contrasenaField.getText();
                funcionarioControlador.crearFuncionario(nombre, usuario, contrasena);
                actualizarListaFuncionarios();
            }
        });
        inputPanel.add(addButton);
        
        add(inputPanel, BorderLayout.NORTH);

        // Área de visualización de funcionarios
        funcionarioListArea = new JTextArea();
        funcionarioListArea.setEditable(false);
        actualizarListaFuncionarios();
        add(new JScrollPane(funcionarioListArea), BorderLayout.CENTER);
    }

    private void actualizarListaFuncionarios() {
        funcionarioListArea.setText("");
        funcionarioControlador.mostrarFuncionarios();
    }
}