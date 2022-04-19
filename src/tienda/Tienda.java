/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import Entidadesyservicio.producto.ProductoService;
import java.util.Scanner;

/**
 *
 * @author
 */
public class Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ProductoService producto=new ProductoService();
        Scanner leer=new Scanner(System.in);
        System.out.println("a)Lista el nombre de todos los productos que hay en la tabla producto. \n" +
"b) Lista los nombres y los precios de todos los productos de la tabla producto. \n" +
"c) Listar aquellos productos que su precio esté entre 120 y 202. \n" +
"d) Buscar y listar todos los Portátiles de la tabla producto. \n" +
"e) Listar el nombre y el precio del producto más barato. \n" +
"f) Ingresar un producto a la base de datos.\n" +
"g) Ingresar un fabricante a la base de datos\n" +
"h) Editar un producto con datos a elección");
        String opcion=(leer.next());
        switch (opcion) {
            case "a":
                try{
                 producto.imprimirNombre();
                }
                catch (Exception e) {
        }
                
                break;
                case"b":
                    try {
                    producto.imprimirNombreyprecio();
                    } catch (Exception e) {
                    }
                 break;
                 case"c":
                 try {
                     producto.Listarproductos();
                    } catch (Exception e) {
                    }
                 break;
                 case "d":
                 try {
                   producto.Buscarylistar();
                } catch (Exception e) {
                }
                break;
            default:
                throw new AssertionError();
        }
    }
    
}
