/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3.vista;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import com.mycompany.practica3.modelo.Producto;
import com.mycompany.practica3.dao.ProductoDAO;
/**
 *
 * @author Melvin Prendas
 */
public class ProductoVista extends JPanel {

    private JTable table;
    private ProductoDAO productoDAO;

    public ProductoVista() {
        productoDAO = new ProductoDAO();
        setLayout(new BorderLayout());

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        cargarDatosEnTabla();
    }

    private void cargarDatosEnTabla() {
        List<Producto> productos = productoDAO.obtenerProductos();

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Nombre", "Precio", "Descripcion"});

        for (Producto producto : productos) {
            model.addRow(new Object[]{
                producto.getIdProducto(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getDescripcion(),
            });
        }

        table.setModel(model);
    }
}
