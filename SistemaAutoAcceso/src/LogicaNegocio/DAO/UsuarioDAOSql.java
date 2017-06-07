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
    /**
     * El metodo getUsuario() de tipo Usuario funciona para retornar un objeto del tipo Usuario que este relacionado con
     * el parametro de tipo string recibido (matricula)
     * @param matricula parametro de tipo String perteneciente a un objeto de tupo Usuario y que funciona como identificador
     * para la busqueda de los datos relacionados con este parametro
     * @return usuario parametro del tipo Usuario que esta relacionado con el parametro de tipo String matricula
     */
    @Override
    public Usuario getUsuario(String matricula){
        Usuario usuario = null;
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("select * from usuario where matricula = ?");
            orden.setString(1, matricula);
            ResultSet resultadoConsulta = orden.executeQuery();
            if (resultadoConsulta.first()){
                String correo = resultadoConsulta.getString(7);
                String telefono = resultadoConsulta.getString(8);
                String nombre = resultadoConsulta.getString(2)+ resultadoConsulta.getString(3) + resultadoConsulta.getString(4);
                InscripcionDAOSql inscripcion = new InscripcionDAOSql();
                usuario = new Usuario(matricula, nombre, inscripcion.getListaInscripciones(matricula), telefono,correo);
            }else{
                Logger logger = Logger.getLogger("Logger");
                logger.log(Level.WARNING, "No se encuentra en usuario en la base de datos");
            }
        }catch(SQLException | NullPointerException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
        }finally{
            conexionSql.cerrarConexion();
        }
        return usuario;
    }
    /**
     * El metodo getUsuario() de tipo Usuario regresa un usuario relacionado con un parametro de tipo entero 
     * recibido (idusuarioSistema)
     * @param idUsuarioSistema parametro de tipo entero que funciona como identificador de un usuario y como identificador
     * de busuqueda para los datos de este parametro
     * @return usuario parametro de tipo Usuario relacionado que esta relacionado con el parametro e tipo entero
     * idUsuarioSistema
     */
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
                String correo = resultadoConsulta.getString(7);
                String telefono = resultadoConsulta.getString(8);
                String nombre = resultadoConsulta.getString(2)+ resultadoConsulta.getString(3) + resultadoConsulta.getString(4);
                InscripcionDAOSql inscripcion = new InscripcionDAOSql();
                usuario = new Usuario(matricula, nombre, inscripcion.getListaInscripciones(matricula), telefono,correo);
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
