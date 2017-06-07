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
    /**
     * El metodo getIdActividad() recibe el nombre de una actividad, este es de tipo String y regresa
     * el identificador de la actividad de tipo entero que coincida con el nombre de la actividad 
     * @param nombreActividad parametro requerido de tipo String recibido por el metodo getIdActividad 
     * con el cual se inicia la busqueda de la actividad en la base de datos
     * @return idActividad Identificador de la actividad que coincide con los valores recibidos (nombreActividad)
     */
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
    /**
     * El metodo agregarActividad() tiene la funcionalidad de agregar un nuevo registro del tipo Actividad 
     * a la base de datos en el sistema
     * @param actividad Parametro de tipo Actividad perteneciente a la actividad que se desea agregar a la base de datos 
     * @return registroExitoso este es un valor booleano, con el se identifica si el registro fue almacenado con exito 
     * o existe algun impedimento al guardar los datos 
     */
    @Override
    public boolean agregarActividad(Actividad actividad){
        boolean registroExitoso = false;
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("insert into actividad (idActividad, nombreActividad, fechaInicio,fechaFin"
                    + ", cupo, seccion, modulo, numeroPersonal, idExperiencia, salon) values (?, ?, ?, ?, ?, ?,?,?,?,?)");
            orden.setInt(1, actividad.getDatosActividad().getIdActividad());
            orden.setString(2, actividad.getDatosActividad().getNombreActividad());
            orden.setDate(3, java.sql.Date.valueOf(actividad.getDatosActividad().getFechaInicio().toString()));
            orden.setDate(4, java.sql.Date.valueOf(actividad.getDatosActividad().getFechaFin().toString()));
            orden.setString(5, actividad.getDatosActividad().getCupo());
            orden.setInt(6, actividad.getDatosExperiencia().getSeccion());
            orden.setInt(7, actividad.getDatosExperiencia().getModulo());
            orden.setString(8, actividad.getDatosExperiencia().getNumeroPersonal());
            orden.setInt(9, actividad.getDatosExperiencia().getIdExperiencia());
            orden.setString(10, actividad.getDatosActividad().getSalon());
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
    /**
     * Metodo getIdActividad() recibe como parametros un idActividad (valor de tipo entero) con el cual se 
     * buscara en la base de datos una actividad con dicho identificador 
     * @param idActividad Parametro de tipo entero perteneciente a una actividad que se desea buscar en la base
     * de datos
     * @return actividad Parametro de tipo Actividad al que pertenece el identificador idActividad encontrado en
     * la base de datos
     */
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
    /**
     * El metodo getListaActividades retorna una lista de todas las actividades existentes en el sistema
     * @return listaActividades variable del tipo ArrayList de actividades que contiene todas las actividades
     * existentes en el sistema
     */
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
    /**
     * El metodo getListaActividades funciona para mostrar las actividade pertenecientes a una experiencieeducativa
     * el modulo y la seccion a la que pertenecen
     * @param idExperiencia identificador de tipo entero que muestra a que experienciaEducativa pertenece la actividad
     * @param modulo identificador de tipo entero que muestra el modulo al que pertenece una actividad
     * @param seccion identificador de tipo entero que muestra a que seccion pertenece una actividad
     * @return actividades parametro del tipo ArrayList<Actividad> coincidentes a los filtros de busqueda de modulo 
     * y seccion
     */
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
    /**
     * El metodo registrarActividad del tipo booleano funciona para registrar una actividad  perteneciente a un modulo
     * y a una inscripcion
     * @param actividad Parametro del tipo ActividadRegistrada que contiene los datos de una actividad  que se desa guardar
     * @param idInscripcion Parametro de tipo entero que indica a que usuario (o inscripcion de un usario) pertenece la 
     * actividad que se desea guardar
     * @param numeroPersonal parametro del tipo String que indica que clase registra la actividad
     * @return registroExitoso parametro del tipo booleano que muestra si el registro fue exitoso o si existe algun impedimento
     * para almacenar los datos
     */
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
    /**
     * El metodo getListaActividadesRegistradas() recibe un argumento de tipo entero que funciona para poder
     * obtener todas las actividades registradas en un curso pertenecientes a la inscripcion de un usuario
     * @param idInscripcion Parametro de tipo entero perteneciente a una inscripcion que funciona para buscar 
     * todas las actividades pertenecientes a una inscripcion
     * @return actividadesRegistradas parametro del tipo arrayList de ActividadesRegistradas que retorna todas las
     * actividades encontradas en el sistema pertenecientes a una inscripcion
     */
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
    /**
     * El metodo de tipo booleanoactiualizarActividad() recibe un parametro del tipo Actividad 
     * @param actividad Parametro requerido del tipo actividad que funciona para editar los datos de una actividad
     * @return actualizada Parametro del tipo booleano que funciona para indicar si una actividad fue actualizada con
     * exito o si existe algun inconveniente para editar sus datos
     */
    @Override
    public boolean actiualizarActividad(Actividad actividad) {
        boolean actualizada = false;
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("update actividad set nombreActividad = ?, fechaInicio = ?, "
                    + "fechaFin = ?, cupo = ?, seccion = ?, modulo = ?, numeroPersonal = ?, idExperiencia = ?, salon = ? where idActividad = ?");
            orden.setString(1, actividad.getDatosActividad().getNombreActividad());
            orden.setDate(2, java.sql.Date.valueOf(actividad.getDatosActividad().getFechaInicio().toString()));
            orden.setDate(3, java.sql.Date.valueOf(actividad.getDatosActividad().getFechaFin().toString()));
            String cu = actividad.getDatosActividad().getCupo();
            orden.setString(4, cu);
            orden.setInt(5, actividad.getDatosExperiencia().getSeccion());
            orden.setInt(6, actividad.getDatosExperiencia().getModulo());
            orden.setString(7, actividad.getDatosExperiencia().getNumeroPersonal());
            orden.setInt(8, actividad.getDatosExperiencia().getIdExperiencia());
            orden.setString(9, actividad.getDatosActividad().getSalon());
            orden.setInt(10, actividad.getDatosActividad().getIdActividad());
            orden.executeUpdate();
            actualizada = true;
        }catch(SQLException | NullPointerException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
            excepcion.printStackTrace();
        }
        return actualizada;
    }
    /**
     * El metodo eliminarActividad() recibe como parametros un identificador de tipo entero perteneciente a una 
     * actividad y funciona para eliminar una actividad del sistema.
     * @param idActividad Parametro de tipo entero perteneciente a una actividad existente en el sistema que se 
     * quiera eliminar.
     * @return eliminada Parametro de tipo booleano que identifica si una actividad fue eliminada con exito o si
     * existe algun impedimento para eliminarla.
     */
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
    /**
     * El método regresa un identificador entero para una nueva actividad.
     * @return ultimoId, identificador de nueva actividad, si no hay actividades, regresa 1, en el caso contrario regresa
     * el id de la última actividad más 1. En caso de regresar 0, significará que no logró acceder a los registros.
     */
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
