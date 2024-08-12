/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3.controlador;
import java.util.List;
import com.mycompany.practica3.modelo.CompraProducto;
import com.mycompany.practica3.dao.CompraProductoDAO;
/**
 *
 * @author Melvin Prendas
 */
public class CompraProductoControlador {
    private CompraProductoDAO compraProductoDAO;

    public CompraProductoControlador() {
        this.compraProductoDAO = new CompraProductoDAO();
    }

    public void agregarCompraProducto(int idCompra, int idProducto, int cantidad) {
        CompraProducto compraProducto = new CompraProducto(idCompra, idProducto, cantidad);
        compraProductoDAO.insertarCompraProducto(compraProducto);
        System.out.println("Producto añadido a la compra exitosamente.");
    }

    public void mostrarCompraProductos() {
        List<CompraProducto> compraProductos = compraProductoDAO.obtenerCompraProductos();
        if (compraProductos.isEmpty()) {
            System.out.println("No hay productos en las compras registradas.");
        } else {
            System.out.println("Lista de productos en las compras:");
            for (CompraProducto compraProducto : compraProductos) {
                System.out.println(compraProducto);
            }
        }
    }

    public void eliminarCompraProducto(int idCompra, int idProducto) {
        compraProductoDAO.eliminarCompraProducto(idCompra, idProducto);
        System.out.println("Producto eliminado de la compra exitosamente.");
    }

    public CompraProducto buscarCompraProductoPorId(int idCompra, int idProducto) {
        return compraProductoDAO.obtenerCompraProductoPorId(idCompra, idProducto);
    }
}
