/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.practica3.modelo.Compra;
/**
 *
 * @author Melvin Prendas
 */
public class CompraDAO {

    public void insertarCompra(Compra compra) {
        String sql = "INSERT INTO Compra (id_Funcionario, total, fecha) VALUES (?, ?, sysdate())";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, compra.getIdFuncionario());
            stmt.setDouble(2, compra.getTotal());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Compra> obtenerCompras() {
        List<Compra> compras = new ArrayList<>();
        String sql = "SELECT * FROM Compra";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Compra compra = new Compra();
//                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setIdFuncionario(rs.getInt("id_funcionario"));
                compra.setTotal(rs.getDouble("total"));
                compras.add(compra);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return compras;
    }

    public Compra obtenerCompraPorId(int idCompra) {
        Compra compra = null;
        String sql = "SELECT * FROM Compra WHERE idCompra = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCompra);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    compra = new Compra();
                    compra.setIdCompra(rs.getInt("idCompra"));
                    compra.setIdFuncionario(rs.getInt("idFuncionario"));
                    compra.setTotal(rs.getDouble("total"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return compra;
    }

    public void eliminarCompra(int idCompra) {
        String sql = "DELETE FROM Compra WHERE idCompra = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCompra);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}