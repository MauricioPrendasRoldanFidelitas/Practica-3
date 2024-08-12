/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3.controlador;
import com.mycompany.practica3.dao.FuncionarioDAO;
import com.mycompany.practica3.modelo.Funcionario;
import java.util.List;
/**
 *
 * @author Melvin Prendas
 */
public class FuncionarioControlador {
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public void crearFuncionario(String nombre, String usuario, String contrasena) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNombre(nombre);
        funcionario.setUsuario(usuario);
        funcionario.setContrasena(contrasena);
        funcionarioDAO.insertarFuncionario(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioDAO.obtenerFuncionarios();
    }

    public Funcionario buscarFuncionarioPorId(int id) {
        return funcionarioDAO.obtenerFuncionarioPorId(id);
    }

    public void eliminarFuncionario(int id) {
        funcionarioDAO.eliminarFuncionario(id);
    }
    public String mostrarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioDAO.obtenerFuncionarios();
        StringBuilder sb = new StringBuilder();
        
        for (Funcionario funcionario : funcionarios) {
            sb.append("ID: ").append(funcionario.getIdFuncionario())
              .append(", Nombre: ").append(funcionario.getNombre())
              .append(", Usuario: ").append(funcionario.getUsuario())
              .append("\n");
        }
        
        return sb.toString();
    }
}
