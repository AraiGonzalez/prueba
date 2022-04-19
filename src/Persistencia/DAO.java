package Persistencia;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//DAO --> DATA ACCESS OBJECT
//LA CLASE DONDE VAMOS A DECLARAR LOS OBJETOS QUE VAN A CONECTAR, DESCONECTAR Y HACER LAS CONSULTAS DE LA BASE DE DATOS
public abstract class DAO { // Superclase - 
    
    //USAMOS LOS OBJETOS PROTEGIDOS PORQUE VAMOS A USAR HERENCIA
    
    //ESTE OBJETO ES EL ENCARGADO DE INICIAR/TENER/MANTENER LA CONEXION
    protected Connection conexion = null; //se declara nulo para estar seguros de que no va a haber una conexion abierta salvo decision nuestra
    // GUARDAR TODOS LOS DATOS QUE LLEGAN DE LA BASE DE DATOS (LAS FILAS DE LAS CONSULTAS)
    protected ResultSet resultado = null;
    // "TIENE" LAS CONSULTAS... ES DONDE GENERAMOS LAS SENTENCIAS (QUERYS) A EJECUTAR
    protected Statement sentencia = null; 
    
    //DECLARAMOS PARA AHORRAR CODIGO, SON DATOS QUE SE VAN A REPETIR
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    protected void conectarBase() throws Exception {
        try {
            //LO PRIMERO QUE HAY QUE HACER ES REGISTRAR EL DRIVER
            Class.forName(DRIVER); //LO SACO DE SERVICES -> MI CONEXION -> CLICK DER -> PROPERTIES -> DRIVER CLASS
            
            //TENEMOS QUE INDICAR LA URL DE LA BASE DE DATOS DE LA CUAL NOS VAMOS A CONECTAR
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            
            //ESTABLECEMOS LA CONEXION
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al conectar a la base de datos");
            throw ex;
        }
    }
    
    protected void consultarBase(String sql) throws Exception {
        try {
            //NOS CONECTAMOS A LA BASE LLAMANDO AL METODO PARA CONECTAR
            conectarBase();
            //CREAMOS UNA SENTENCIA (SENTENCIA ES EL OBJETO DE TIPO STATEMENT QUE CREE)
            sentencia = conexion.createStatement();  //(CONEXION ES EL OBJETO DE TIPO CONNECTION)
            //EJECUTAMOS LA SENTENCIA Y LA GUARDAMOS EN EL RESULTADO(OBJETO DE TIPO RESULTSET)
            resultado = sentencia.executeQuery(sql);
            
            //1 - SQL LO RECIBE POR PARAMENTRO LA FUNCION CONSULTARBASE()
            //2 - SE LO PASAMOS POR PARAMETRO A EXECUTEQUERY() -> EJECUTA ESA QUERY
            //3 - EL RESULTADO DE EJECUTAR ESA QUERY LO GUARDAMOS EN NUESTRO OBEJTO DE TIPO RESULTSET
            
        } catch (Exception ex) {
            System.out.println("Error al realizar consulta");
            throw ex;
        }
        //ACA NO CERRAMOS LA BASE DE DATOS PORQUE EL RESULTADO QUE TRAE EXECUTEQUERY SE PERDERIA 
    }

    protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            // LO PRIMERO QUE TENGO QUE HACER ES CONECTARME A LA DB
            conectarBase();
            //CREO LA SENTENCIA
            sentencia = conexion.createStatement();
            //Y LA EJECUTO PASANDO COMO PARAMETRO LA QUERY(SQL)
            sentencia.executeUpdate(sql);
            
//El método executeQuery esta diseñado para sentencias que producen como resultado un único result set tal como las sentencias SELECT.
//El método executeUpdate se usa para ejecutar sentencias INSERT, UPDATE ó DELETE así como CREATE TABLE o DROP TABLE.
        } catch (SQLException ex) {
//            try{ 
//            conexion.rollback(); //PARA QUE NO SE EJECUTEN CAMBIOS PARCIALES
//            } catch (SQLException e){
//                throw new Exception("Error al hacer el rollback");
//            }
            throw ex;
        } finally {
            desconectarBase(); //DESCONECTAMOS LA BASE DE DATOS PARA QUE NO QUEDE CONSUMIENDO RECURSOS
        }
    }
    
    protected void desconectarBase() throws Exception {
        try {
            if (resultado != null) { //SI EXISTE LO TENEMOS QUE CERRAR
                resultado.close();
            }
            if (sentencia != null) { //SI EXISTE LA TENEMOS QUE CERRAR
                sentencia.close();
            }
            if (conexion != null) { //SI EXISTE O ESTA VIGENTE LA TENEMOS QUE CERRAR
                conexion.close();
            }
        } catch (Exception ex) {
            System.out.println("Error en desconectar base!");
            throw ex;
        }
    }
}
