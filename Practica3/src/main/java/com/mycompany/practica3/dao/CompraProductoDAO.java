/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.practica3.modelo.CompraProducto;
/**
 *
 * @author Melvin Prendas
 */
public class CompraProductoDAO {

    public void insertarCompraProducto(CompraProducto compraProducto) {
        String sql = "INSERT INTO Compra_Producto (idCompra, idProducto, cantidad) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, compraProducto.getIdCompra());
            stmt.setInt(2, compraProducto.getIdProducto());
            stmt.setInt(3, compraProducto.getCantidad());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CompraProducto> obtenerCompraProductos() {
        List<CompraProducto> compraProductos = new ArrayList<>();
        String sql = "SELECT * FROM Compra_Producto";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CompraProducto compraProducto = new CompraProducto();
                compraProducto.setIdCompra(rs.getInt("id_Compra"));
                compraProducto.setIdProducto(rs.getInt("id_Producto"));
                compraProducto.setCantidad(rs.getInt("cantidad"));
                compraProductos.add(compraProducto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return compraProductos;
    }

    public CompraProducto obtenerCompraProductoPorId(int idCompra, int idProducto) {
        CompraProducto compraProducto = null;
        String sql = "SELECT * FROM Compra_Producto WHERE idCompra = ? AND idProducto = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCompra);
            stmt.setInt(2, idProducto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    compraProducto = new CompraProducto();
                    compraProducto.setIdCompra(rs.getInt("idCompra"));
                    compraProducto.setIdProducto(rs.getInt("idProducto"));
                    compraProducto.setCantidad(rs.getInt("cantidad"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return compraProducto;
    }

    public void eliminarCompraProducto(int idCompra, int idProducto) {
        String sql = "DELETE FROM Compra_Producto WHERE idCompra = ? AND idProducto = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCompra);
            stmt.setInt(2, idProducto);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}