package LogicaNegocio.DAO;

import AccesoDatos.ConexionSQL;
import LogicaNegocio.Entidades.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CursoDAOSql implements CursoDAO{
    /**
     * Metodo del tipo curso, el metodo getCurso() retorna un objeto del tipo Curso buscado mediante su identificador 
     * de tipo entero
     * @param nrc parametro de tipo entero que funciona como identificador de un curso
     * @return curso parametro del tipo Curso que coincide con el identificador (nrc) en el sistema
     */
    @Override
    public Curso getCurso(int nrc){
        Curso curso = null;
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("select * from curso where nrc = ?");
            orden.setInt(1, nrc);
            ResultSet resultadoConsulta = orden.executeQuery();
            if (resultadoConsulta.first()){
                int capacidadCupo = resultadoConsulta.getInt(1);
                String nombreCurso= resultadoConsulta.getString(2);
                String idioma = resultadoConsulta.getString(5);
                int idExperiencia = resultadoConsulta.getInt(6);
                curso = new Curso(capacidadCupo, nombreCurso, nrc, null,idioma, idExperiencia);
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
        return curso;
    }
}
