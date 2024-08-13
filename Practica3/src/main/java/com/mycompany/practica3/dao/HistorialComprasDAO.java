package com.mycompany.practica3.dao;
import com.mycompany.practica3.modelo.HistorialCompras;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Melvin Prendas
 */
public class HistorialComprasDAO {

    public List<HistorialCompras> obtenerHistorialCompras() {
        List<HistorialCompras> historialCompras = new ArrayList<>();
        String sql = "SELECT Compra.id_compra, Compra.id_funcionario, Funcionario.nombre AS nombre_funcionario, " +
                     "Compra.total, Compra.fecha, Compra_Producto.id_producto, Producto.nombre AS nombre_producto, " +
                     "Compra_Producto.cantidad, Compra_Producto.cantidad * Producto.precio AS precio_total " +
                     "FROM Compra " +
                     "JOIN Compra_Producto ON Compra.id_compra = Compra_Producto.id_compra " +
                     "JOIN Producto ON Compra_Producto.id_producto = Producto.id_producto " +
                     "JOIN Funcionario ON Compra.id_funcionario = Funcionario.id_funcionario";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                HistorialCompras hc = new HistorialCompras();
                hc.setIdCompra(rs.getInt("id_compra"));
                hc.setIdFuncionario(rs.getInt("id_funcionario"));
                hc.setNombreFuncionario(rs.getString("nombre_funcionario"));
                hc.setTotal(rs.getDouble("total"));
                hc.setFecha(rs.getString("fecha"));
                hc.setIdProducto(rs.getInt("id_producto"));
                hc.setNombreProducto(rs.getString("nombre_producto"));
                hc.setCantidad(rs.getInt("cantidad"));
                hc.setPrecioTotal(rs.getDouble("precio_total"));
                historialCompras.add(hc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return historialCompras;
    }
}