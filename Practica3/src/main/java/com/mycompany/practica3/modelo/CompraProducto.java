/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3.modelo;

/**
 *
 * @author Melvin Prendas
 */
public class CompraProducto {
    private int idCompra;
    private int idProducto;
    private int cantidad;

    public CompraProducto() {
    }

    public CompraProducto(int idCompra, int idProducto, int cantidad) {
        this.idCompra = idCompra;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "CompraProducto{" +
                "idCompra=" + idCompra +
                ", idProducto=" + idProducto +
                ", cantidad=" + cantidad +
                '}';
    }
}

