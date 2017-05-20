package LogicaNegocio.DAO;

import AccesoDatos.ConexionSQL;
import LogicaNegocio.Entidades.ExperienciaEducativa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExperienciaEducativaDAOSql implements ExperienciaEducativaDAO{
    @Override
    public ArrayList<ExperienciaEducativa> getListaExperiencias() {
        ArrayList<ExperienciaEducativa> listaExperiencias = new ArrayList();
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("select * from experienciaEducativa");
            ResultSet resultadoConsulta = orden.executeQuery();
            int idExperiencia;
            String nombreExperiencia;
            ExperienciaEducativa experiencia;
            while(resultadoConsulta.next()){
                idExperiencia = resultadoConsulta.getInt(1);
                nombreExperiencia = resultadoConsulta.getString(2);
                experiencia = new ExperienciaEducativa(idExperiencia, nombreExperiencia);
                listaExperiencias.add(experiencia);
            }
        }catch(SQLException | NullPointerException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
        }
        return listaExperiencias;
    }
}
