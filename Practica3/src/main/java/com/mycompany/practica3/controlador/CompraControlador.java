/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3.controlador;
import java.util.List;
import com.mycompany.practica3.dao.CompraDAO;
import com.mycompany.practica3.modelo.Compra;
/**
 *
 * @author Melvin Prendas
 */
public class CompraControlador {
    private CompraDAO compraDAO;

    public CompraControlador() {
        this.compraDAO = new CompraDAO();
    }

    public void agregarCompra(int idCompra, int idFuncionario, double total) {
        Compra compra = new Compra(idCompra, idFuncionario, total);
        compraDAO.insertarCompra(compra);
        System.out.println("Compra registrada exitosamente.");
    }

    public void mostrarCompras() {
        List<Compra> compras = compraDAO.obtenerCompras();
        if (compras.isEmpty()) {
            System.out.println("No hay compras registradas.");
        } else {
            System.out.println("Lista de compras:");
            for (Compra compra : compras) {
                System.out.println(compra);
            }
        }
    }

    public void eliminarCompra(int idCompra) {
        compraDAO.eliminarCompra(idCompra);
        System.out.println("Compra eliminada exitosamente.");
    }

    public Compra buscarCompraPorId(int idCompra) {
        return compraDAO.obtenerCompraPorId(idCompra);
    }
}