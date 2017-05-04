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
                //ArrayList<Modulo> modulos;
                curso = new Curso(capacidadCupo, nombreCurso, nrc, null);
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
