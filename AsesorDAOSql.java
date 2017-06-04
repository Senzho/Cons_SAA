package LogicaNegocio.DAO;

import AccesoDatos.ConexionSQL;
import LogicaNegocio.Entidades.Asesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AsesorDAOSql implements AsesorDAO{
    @Override
    public ArrayList<Asesor> getListaAsesores() {
        ArrayList<Asesor> listaAsesores = new ArrayList();
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("select * from asesor");
            ResultSet resultadoConsulta = orden.executeQuery();
            String numeroPersonal;
            String nombre;
            String idioma;
            String telefono;
            String correo;
            Asesor asesor;
            while(resultadoConsulta.next()){
                numeroPersonal = resultadoConsulta.getString(1);
                nombre = resultadoConsulta.getString(4) +" "+ resultadoConsulta.getString(6) +" "+ resultadoConsulta.getString(5);
                idioma = resultadoConsulta.getString(2);
                telefono = resultadoConsulta.getString(8);
                correo = resultadoConsulta.getString(7);
                asesor = new Asesor(numeroPersonal, nombre, idioma,telefono,correo);
                listaAsesores.add(asesor);
            }
        }catch(SQLException | NullPointerException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
        }
        return listaAsesores;
    }
    public Asesor getAsesorId(int idUsuarioSistema){
         Asesor asesor = null;
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("select * from asesor where idUsuarioSistema =?");
            orden.setInt(1, idUsuarioSistema);
            ResultSet resultadoConsulta = orden.executeQuery();
            if(resultadoConsulta.first()){
                String nombre;
                String idioma;
                String correo;
                String telefono;
                String numeroPersonal;
                nombre = resultadoConsulta.getString(4) +" "+ resultadoConsulta.getString(6) +" "+ resultadoConsulta.getString(5);
                idioma = resultadoConsulta.getString(2);
                telefono = resultadoConsulta.getString(8);
                correo = resultadoConsulta.getString(7);
                numeroPersonal = resultadoConsulta.getString(1);
                asesor = new Asesor(numeroPersonal, nombre, idioma,telefono,correo);
            }else{
                Logger logger = Logger.getLogger("Logger");
                logger.log(Level.WARNING, "No se encuentra el asesor");
            }
        }catch(SQLException | NullPointerException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
        }
        return asesor;
    }
    @Override
    public Asesor getAsesor(String numeroPersonal) {
        Asesor asesor = null;
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("select * from asesor where numeroPersonal =?");
            orden.setString(1, numeroPersonal);
            ResultSet resultadoConsulta = orden.executeQuery();
            if(resultadoConsulta.first()){
                String nombre;
                String idioma;
                String correo;
                String telefono;
                numeroPersonal = resultadoConsulta.getString(1);
                nombre = resultadoConsulta.getString(4) +" "+ resultadoConsulta.getString(6) +" "+ resultadoConsulta.getString(5);
                idioma = resultadoConsulta.getString(2);
                telefono = resultadoConsulta.getString(8);
                correo = resultadoConsulta.getString(7);
                asesor = new Asesor(numeroPersonal, nombre, idioma,telefono,correo);
            }else{
                Logger logger = Logger.getLogger("Logger");
                logger.log(Level.WARNING, "No se encuentra el asesor");
            }
        }catch(SQLException | NullPointerException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
        }
        return asesor;
    }
}
