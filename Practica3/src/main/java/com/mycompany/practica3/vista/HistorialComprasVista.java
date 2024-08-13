/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3.vista;
import com.mycompany.practica3.dao.HistorialComprasDAO;
import com.mycompany.practica3.modelo.HistorialCompras;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Melvin Prendas
 */
public class HistorialComprasVista extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;

    public HistorialComprasVista() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{
            "ID Compra", "ID Funcionario", "Nombre Funcionario", 
            "Total", "Fecha", "ID Producto", "Nombre Producto", 
            "Cantidad", "Precio Total"
        });

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        cargarHistorialCompras();
    }

    private void cargarHistorialCompras() {
        HistorialComprasDAO dao = new HistorialComprasDAO();
        List<HistorialCompras> historialCompras = dao.obtenerHistorialCompras();

        for (HistorialCompras hc : historialCompras) {
            tableModel.addRow(new Object[]{
                hc.getIdCompra(), hc.getIdFuncionario(), hc.getNombreFuncionario(),
                hc.getTotal(), hc.getFecha(), hc.getIdProducto(), 
                hc.getNombreProducto(), hc.getCantidad(), hc.getPrecioTotal()
            });
        }
    }
}