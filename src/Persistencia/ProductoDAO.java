/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidadesyservicio.producto.Producto;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Arai
 *
    /**
     *
     */
//
    public final class ProductoDAO extends DAO {
       
     public Collection<Producto> listar() throws Exception {
        try {
            String sql = "SELECT codigo,nombre,precio,codigo_fabricante FROM Producto";
            //LLAMAMOS A LA FUNCION DEL DAO CONSULTARBASE Y LE PASAMOS LA QUERY
            consultarBase(sql);
            //CREAMOS UN USUARIO Y LO INICIALIZAMOS EN NULL
            Producto producto = null; //porque si despues mi resultado no trae nada me queda un usuario vacio
            //CREAMOS UN LISTADO
            Collection<Producto> productos = new ArrayList();
            //VAMOS AGREGANDO A UN LISTADO A LOS USUARIOS EXISTENTES
            while (resultado.next()) { //ESTO ES PARECIDO A EL DEL ITERATOR, ME DEVUELVE UN BOOLEAN, SI EL LISTADO TIENE MAS ATRIBUTOS:
                //INICIALIZAMOS EL USUARIO CREADO
                producto = new Producto();
                //LE DEFINIMOS LOS ATRIBUTOS
                //ESTE STRING ME DEVUELVE EN LA FILA EN LA QUE ESTOY EL VALOR DE LA FILA 1 EN ESTE CASO
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                //EN ESTE CASO ME DEVOLVERIA LA COLUMNA 2 DE LA FILA EN LA ESTOY, QUE CORRESPONDE A LA CLAVE
                //LO VAMOS AGREGAMOS A LA LISTA
                producto.setPrecio(resultado.getInt(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            //COMO EN EL DAO NO PODIAMOS DESCONECTAR PORQUE SE PERDIAN LOS DATOS, LA TAREA RECAE SOBRE ESTE METODO
            desconectarBase();
            //RETORNAMOS EL ARRAYLIST
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
 }
////        
//
//    public void modificarProducto(Producto producto) throws Exception {
//        try {
//            if (producto == null) {
//                throw new Exception("Debe indicar el producto que desea modificar");
//            }
//
//            String sql = "UPDATE Producto SET "
//                   + " nombre = '" + producto.getNombre() + "' , precio = '" + producto.getPrecio() + "' , codigo = '" + producto.getCodigo()
//                     + "'";
//
//            insertarModificarEliminar(sql);
//        } catch (Exception e) {
//            throw e;
//        }  finally {
//            desconectarBase();
//        }
//    }
//
//    public void eliminarProducto(int precio) throws Exception {
//        try {
//
//            String sql = "DELETE FROM Producto WHERE  = '" + correEletronico + "'";
//
//            insertarModificarEliminar(sql);
//        } catch (Exception e) {
//            throw e;
//        }  finally {
//            desconectarBase();
//        }
//    }
//
//    public Usuario buscarUsuarioPorCorreoElectronico(String correoElectronico) throws Exception {
//        try {
//
//            String sql = "SELECT * FROM Usuario "
//                    + " WHERE correoElectronico = '" + correoElectronico + "'";
//
//            consultarBase(sql);
//            Usuario usuario = null;
//            while (resultado.next()) {
//                usuario = new Usuario();
//                usuario.setId(resultado.getInt(1));
//                usuario.setCorreoElectronico(resultado.getString(2));
//                usuario.setClave(resultado.getString(3));
//            }
//            desconectarBase();
//            return usuario;
//        } catch (Exception e) {
//            desconectarBase();
//            throw e;
//        }
//    }
//    
//    public Usuario buscarUsuarioPorId(Integer id) throws Exception {
//        try {
//
//            String sql = "SELECT * FROM Usuario "
//                    + " WHERE id = '" + id + "'";
//
//            consultarBase(sql);
//
//            Usuario usuario = null;
//            while (resultado.next()) {
//                usuario = new Usuario();
//                usuario.setId(resultado.getInt(1));
//                usuario.setCorreoElectronico(resultado.getString(2));
//                usuario.setClave(resultado.getString(3));
//            }
//            desconectarBase();
//            return usuario;
//        } catch (Exception e) {
//            desconectarBase();
//            throw e;
//        }
//    }
//
 
//
