package LogicaNegocio.DAO;

import AccesoDatos.ConexionSQL;
import LogicaNegocio.Entidades.Inscripcion;
import LogicaNegocio.Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAOSql implements UsuarioDAO{
    @Override
    public Usuario getUsuario(int idUsuarioSistema){
        Usuario usuario = null;
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("select * from usuario where idUsuarioSistema = ?");
            orden.setInt(1, idUsuarioSistema);
            ResultSet resultadoConsulta = orden.executeQuery();
            if (resultadoConsulta.first()){
                String matricula = resultadoConsulta.getString(1);
                String nombre = resultadoConsulta.getString(2)+ resultadoConsulta.getString(3) + resultadoConsulta.getString(4);
                InscripcionDAOSql inscripcion = new InscripcionDAOSql();
                usuario = new Usuario(matricula, nombre, inscripcion.getListaInscripciones(matricula));
            }else{
                Logger logger = Logger.getLogger("Logger");
                logger.log(Level.WARNING, "No se encuentra la actividad en la base de datos");
            }
        }catch(SQLException | NullPointerException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
        }finally{
            conexionSql.cerrarConexion();
        }
        return usuario;
    }
}
