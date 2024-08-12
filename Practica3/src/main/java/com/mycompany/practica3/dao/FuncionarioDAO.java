/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.practica3.modelo.Funcionario;
/**
 *
 * @author Melvin Prendas
 */
public class FuncionarioDAO {

    public void insertarFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO Funcionario (nombre, usuario, contrasena) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getNombre());
            stmt.setString(2, funcionario.getUsuario());
            stmt.setString(3, funcionario.getContrasena());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Funcionario> obtenerFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM Funcionario";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("id_Funcionario"));
                funcionario.setNombre(rs.getString("nombre"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setContrasena(rs.getString("contrasena"));
                funcionarios.add(funcionario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionarios;
    }

    public Funcionario obtenerFuncionarioPorId(int idFuncionario) {
        Funcionario funcionario = null;
        String sql = "SELECT * FROM Funcionario WHERE idFuncionario = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFuncionario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    funcionario = new Funcionario();
                    funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                    funcionario.setNombre(rs.getString("nombre"));
                    funcionario.setUsuario(rs.getString("usuario"));
                    funcionario.setContrasena(rs.getString("contrasena"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionario;
    }

    public void eliminarFuncionario(int idFuncionario) {
        String sql = "DELETE FROM Funcionario WHERE idFuncionario = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFuncionario);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}