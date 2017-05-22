package LogicaNegocio.DAO;

import AccesoDatos.ConexionSQL;
import LogicaNegocio.Entidades.Actividad;
import LogicaNegocio.Entidades.ActividadRegistrada;
import LogicaNegocio.Entidades.DatosActividad;
import LogicaNegocio.Entidades.DatosExperiencia;
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
    public int getIdActividad(String nombreActividad){
        int idActividad = -1;
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("select * from actividad where nombreActividad = ?");
            orden.setString(1, nombreActividad);
            ResultSet resultadoConsulta = orden.executeQuery();
            if (resultadoConsulta.first()){
                idActividad = resultadoConsulta.getInt(1);
            }else{
                Logger logger = Logger.getLogger("Logger");
                logger.log(Level.WARNING, "No se encuentra la actividad en la base de datos");
            }
            idActividad = resultadoConsulta.getInt(1);
        }catch(SQLException | NullPointerException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
        }finally{
            conexionSql.cerrarConexion();
        }
        return idActividad;
    }
    @Override
    public boolean agregarActividad(Actividad actividad, String numeroPersonal){
        boolean registroExitoso = false;
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("insert into actividad (idActividad, nombreActividad, fechaInicio,fechaFin"
                    + ", cupo, seccion, modulo, numeroPersonal, idExperiencia) values (?, ?, ?, ?, ?, ?,?,?,?)");
            orden.setInt(1, actividad.getDatosActividad().getIdActividad());
            orden.setString(2, actividad.getDatosActividad().getNombreActividad());
            orden.setDate(3, java.sql.Date.valueOf(actividad.getDatosActividad().getFechaInicio().toString()));
            orden.setDate(4, java.sql.Date.valueOf(actividad.getDatosActividad().getFechaFin().toString()));
            orden.setString(5, actividad.getDatosActividad().getCupo());
            orden.setInt(6, actividad.getDatosExperiencia().getSeccion());
            orden.setInt(7, actividad.getDatosExperiencia().getModulo());
            orden.setString(8, numeroPersonal);
            orden.setInt(9, actividad.getDatosExperiencia().getIdExperiencia());
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
                String nombreActividad = resultadoConsulta.getString(2);
                Date fechaInicio = resultadoConsulta.getDate(3);
                Date fechaFin = resultadoConsulta.getDate(4);
                String cupo = resultadoConsulta.getString(5);
                int seccion = resultadoConsulta.getInt(6);
                int modulo = resultadoConsulta.getInt(7);
                int idExperiencia = resultadoConsulta.getInt(9);
                String salon = resultadoConsulta.getString(10);
                String numeroPersonal = resultadoConsulta.getString(8);
                DatosActividad datosActividad = new DatosActividad(idActividad, nombreActividad, fechaInicio, fechaFin, cupo,salon);
                DatosExperiencia datosExperiencia = new DatosExperiencia(idExperiencia, modulo, seccion, numeroPersonal);
                actividad = new Actividad(datosActividad, datosExperiencia);
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
    public ArrayList<Actividad> getListaActividades(){
        ArrayList<Actividad> listaActividades = new ArrayList<>();
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("select * from actividad");
            ResultSet resultadoConsulta = orden.executeQuery();
            while (resultadoConsulta.next()){
                int idActividad = resultadoConsulta.getInt(1);
                String nombreActividad = resultadoConsulta.getString(2);
                Date fechaInicio = resultadoConsulta.getDate(3);
                Date fechaFin = resultadoConsulta.getDate(4);
                String cupo = resultadoConsulta.getString(5);
                int seccion = resultadoConsulta.getInt(6);
                int modulo = resultadoConsulta.getInt(7);
                int idExperiencia = resultadoConsulta.getInt(9);
                String salon = resultadoConsulta.getString(10);
                String numeroPersonal = resultadoConsulta.getString(8);
                DatosActividad datosActividad = new DatosActividad(idActividad, nombreActividad, fechaInicio, fechaFin, cupo,salon);
                DatosExperiencia datosExperiencia = new DatosExperiencia(idExperiencia, modulo, seccion, numeroPersonal);
                Actividad actividad = new Actividad(datosActividad, datosExperiencia);
                listaActividades.add(actividad);
            }
        }catch(SQLException | NullPointerException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
        }finally{
            conexionSql.cerrarConexion();
        }
        return listaActividades;
    }
    @Override
    public ArrayList<Actividad> getListaActividades(int idExperiencia, int modulo, int seccion) {
        ArrayList<Actividad> actividades = new ArrayList<>();
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("select * from actividad where idExperiencia = ? and modulo = ? and seccion = ?");
            orden.setInt(1, idExperiencia);
            orden.setInt(2, modulo);
            orden.setInt(3, seccion);
            ResultSet resultadoConsulta = orden.executeQuery();
            while (resultadoConsulta.next()){
                int idActividad = resultadoConsulta.getInt(1);
                String nombreActividad = resultadoConsulta.getString(2);
                Date fechaInicio = resultadoConsulta.getDate(3);
                Date fechaFin = resultadoConsulta.getDate(4);
                String cupo = resultadoConsulta.getString(5);
                String salon = resultadoConsulta.getString(10);
                String numeroPersonal = resultadoConsulta.getString(8);
                DatosActividad datosActividad = new DatosActividad(idActividad, nombreActividad, fechaInicio, fechaFin, cupo,salon);
                DatosExperiencia datosExperiencia = new DatosExperiencia(idExperiencia, modulo, seccion,numeroPersonal);
                Actividad actividad = new Actividad(datosActividad, datosExperiencia);
                actividades.add(actividad);
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
    public boolean actiualizarActividad(Actividad actividad, String numeroPersonal) {
        boolean actualizada = false;
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("update actividad set nombreActividad = ?, fechaInicio = ?, "
                    + "fechaFin = ?, cupo = ?, seccion = ?, modulo = ? where idActividad = ?");
            orden.setString(1, actividad.getDatosActividad().getNombreActividad());
            orden.setDate(2, java.sql.Date.valueOf(actividad.getDatosActividad().getFechaInicio().toString()));
            orden.setDate(3, java.sql.Date.valueOf(actividad.getDatosActividad().getFechaFin().toString()));
            String cu = actividad.getDatosActividad().getCupo();
            orden.setString(4, cu);
            orden.setInt(5, actividad.getDatosExperiencia().getSeccion());
            orden.setInt(6, actividad.getDatosExperiencia().getModulo());
            orden.setInt(7, actividad.getDatosActividad().getIdActividad());
            orden.executeUpdate();
            actualizada = true;
        }catch(SQLException | NullPointerException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
            excepcion.printStackTrace();
        }
        return actualizada;
    }
    @Override
    public boolean eliminarActividad(int idActividad) {
        boolean eliminada = false;
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("delete from actividad where idActividad = ?");
            orden.setInt(1, idActividad);
            orden.execute();
            eliminada = true;
        }catch(SQLException | NullPointerException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
        }finally{
            conexionSql.cerrarConexion();
        }
        return eliminada;
    }
    @Override
    public int getUltimoId(){
        int ultimoId = 0;
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("select * from actividad");
            ResultSet resultadoConsulta = orden.executeQuery();
            if (resultadoConsulta.last()){
                ultimoId = resultadoConsulta.getInt(1)+1;
            }else{
                ultimoId = 1;
            }
        }catch(SQLException | NullPointerException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
        }finally{
            conexionSql.cerrarConexion();
        }
        return ultimoId;
    }
}
