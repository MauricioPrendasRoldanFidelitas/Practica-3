/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3.modelo;

/**
 *
 * @author Melvin Prendas
 */
public class Funcionario {
    private int idFuncionario;
    private String nombre;
    private String usuario;
    private String contrasena;

    public Funcionario() {
    }
    
    public Funcionario(int idFuncionario, String nombre, String usuario, String contrasena) {
        this.idFuncionario = idFuncionario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "idFuncionario=" + idFuncionario +
                ", nombre='" + nombre + '\'' +
                ", usuario='" + usuario + '\'' +
                '}';
    }
}
