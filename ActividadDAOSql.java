package LogicaNegocio.DAO;

import AccesoDatos.ConexionSQL;
import LogicaNegocio.Entidades.Actividad;
import LogicaNegocio.Entidades.ActividadRegistrada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActividadDAOSql implements ActividadDAO{
    @Override
    public ArrayList<ActividadRegistrada> getListaActividadesRegistradas(int idInscripcion) {
        ArrayList<ActividadRegistrada> actividadesRegistradas = new ArrayList<>();
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("select * from registroActividad where idInscripcion = ?");
            orden.setInt(1, idInscripcion);
            ResultSet resultadoConsulta = orden.executeQuery();
            while (resultadoConsulta.next()){
                int porcentaje = resultadoConsulta.getInt(1);
                Date fecha = resultadoConsulta.getDate(2);
                String observacion = resultadoConsulta.getString(3);
                int idActividad = resultadoConsulta.getInt(5);
                actividadesRegistradas.add(new ActividadRegistrada(porcentaje, fecha, observacion, idActividad));
            }
        }catch(SQLException | NullPointerException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
        }finally{
            conexionSql.cerrarConexion();
        }
        return actividadesRegistradas;
    }
    @Override
    public Actividad getActividad(int idActividad) {
        Actividad actividad = null;
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("select * from actividad where idActividad = ?");
            orden.setInt(1, idActividad);
            ResultSet resultadoConsulta = orden.executeQuery();
            if (resultadoConsulta.first()){
                Date fecha = resultadoConsulta.getDate(2);
                String nombre = resultadoConsulta.getString(3);
                actividad = new Actividad(idActividad, fecha, nombre);
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
        return actividad;
    }
    @Override
    public ArrayList<Actividad> getListaActividades(int nrc, int modulo, int seccion) {
        ArrayList<Actividad> actividades = new ArrayList<>();
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("select * from actividad where nrc = ? and modulo = ? and seccion = ?");
            orden.setInt(1, nrc);
            orden.setInt(2, modulo);
            orden.setInt(3, seccion);
            ResultSet resultadoConsulta = orden.executeQuery();
            while (resultadoConsulta.next()){
                int idActividad = resultadoConsulta.getInt(1);
                Date fecha = resultadoConsulta.getDate(2);
                String nombre = resultadoConsulta.getString(3);
                actividades.add(new Actividad(idActividad,  fecha, nombre));
            }
        }catch(SQLException | NullPointerException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
        }finally{
            conexionSql.cerrarConexion();
        }
        return actividades;
    }
    @Override
    public boolean registrarActividad(ActividadRegistrada actividad, int idInscripcion, String numeroPersonal) {
        boolean registroExitoso = false;
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("insert into registroActividad (porcentaje, fecha, observacion, numeroPersonal, "
                    + "idActividad, idInscripcion) values (?, ?, ?, ?, ?, ?)");
            orden.setInt(1, actividad.getPorcentaje());
            orden.setDate(2, java.sql.Date.valueOf(actividad.getFecha().toString()));
            orden.setString(3, actividad.getObservacion());
            orden.setString(4, numeroPersonal);
            orden.setInt(5, actividad.getIdActividad());
            orden.setInt(6, idInscripcion);
            orden.execute();
            registroExitoso = true;
        }catch(SQLException | NullPointerException excepcion){
            System.out.println(excepcion.getMessage());
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
        }finally{
            conexionSql.cerrarConexion();
        }
        return registroExitoso;
    }
}
