/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3.controlador;
import java.util.List;
import com.mycompany.practica3.modelo.Producto;
import com.mycompany.practica3.dao.ProductoDAO;
/**
 *
 * @author Melvin Prendas
 */
public class ProductoControlador {
    private ProductoDAO productoDAO;

    public ProductoControlador() {
        this.productoDAO = new ProductoDAO();
    }

    public void agregarProducto(String nombre, String descripcion, double precio) {
        Producto producto = new Producto(nombre, descripcion, precio);
        productoDAO.insertarProducto(producto);
        System.out.println("Producto agregado exitosamente.");
    }

    public void mostrarProductos() {
        List<Producto> productos = productoDAO.obtenerProductos();
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("Lista de productos:");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    public void eliminarProducto(int idProducto) {
        productoDAO.eliminarProducto(idProducto);
        System.out.println("Producto eliminado exitosamente.");
    }

    public Producto buscarProductoPorId(int idProducto) {
        return productoDAO.obtenerProductoPorId(idProducto);
    }
}
