package AccesoDatos;

import LogicaNegocio.Logica.ArchivoIp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionSQL {
    private Connection conexion;
    
    public ConexionSQL(){
        crearConexion();
    }
    public void crearConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            ArchivoIp archivoIp = new ArchivoIp();
            String ip = archivoIp.getDireccionIp();
            conexion=DriverManager.getConnection("jdbc:mysql://"+ip+"/SistemaAA?user=nemesis&password=sisemen");
        }catch(ClassNotFoundException | SQLException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.SEVERE, "No se encuentra la clase | no se puedo acceder a la base "
                    + "(ruta, contraseña o usuario)");
        }
    }
    public void cerrarConexion(){
        try{
            if (conexion!=null){
                conexion.close();
            }
        }catch(NullPointerException | SQLException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "No se pudo cerrar la conexión a la base");
        }
    }
    
    public Connection getConexion(){
        return conexion;
    }
}
