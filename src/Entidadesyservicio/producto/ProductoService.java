/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidadesyservicio.producto;

import Persistencia.ProductoDAO;
import java.util.Collection;

/**
 *
 * @author Arai
 */
public class ProductoService {
   private ProductoDAO dao = new ProductoDAO();

  public void imprimirNombre() throws Exception {

        try {
            //CREAMOS UNA LISTA Y LA INICIALIZAMOS CON LA LISTA QUE NOS DEVUELVE LISTARUSUARIO()
            Collection<Producto> producto = listarProducto();

            //LOS IMPRIMIMOS
            if (producto.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : producto) {
                    System.out.println(u.getNombre());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
     public Collection<Producto> listarProducto() throws Exception {

        try {
            Collection<Producto> producto = dao.listar();
            return producto;
        } catch (Exception e) {
            throw e;
        }
    }
   public void imprimirNombreyprecio() throws Exception {

        try {
            //CREAMOS UNA LISTA Y LA INICIALIZAMOS CON LA LISTA QUE NOS DEVUELVE LISTARUSUARIO()
            Collection<Producto> producto = listarProducto();

            //LOS IMPRIMIMOS
            if (producto.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : producto) {
                    System.out.println(" nombre: "+u.getNombre()+ " precio: " +u.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
     public void Listarproductos() throws Exception {

        try {
            //CREAMOS UNA LISTA Y LA INICIALIZAMOS CON LA LISTA QUE NOS DEVUELVE LISTARUSUARIO()
            Collection<Producto> producto = listarProducto();

            //LOS IMPRIMIMOS
            if (producto.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : producto) {
                    if (u.getPrecio()>120&& u.getPrecio()<202) {
                     System.out.println(" nombre: "+u.getNombre()+ " precio: " +u.getPrecio());   
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
        public void Buscarylistar() throws Exception {

        try {
            //CREAMOS UNA LISTA Y LA INICIALIZAMOS CON LA LISTA QUE NOS DEVUELVE LISTARUSUARIO()
            Collection<Producto> producto = listarProducto();

            //LOS IMPRIMIMOS
            if (producto.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : producto) {
                    if (u.getNombre().contains( "Portátil")) {
                     System.out.println(" nombre: "+u.getNombre()+ " precio: " +u.getPrecio());   
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
