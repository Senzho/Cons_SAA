package LogicaNegocio.DAO;

import AccesoDatos.ConexionSQL;
import LogicaNegocio.Entidades.Coordinador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CoordinadorDAOSql implements CoordinadorDAO{
    /**
     * Metodo de tipo Coordinador que recibe como parametro un  tipo entero que funciona como identificador 
     * de un objeto tipo Coordiandor.
     * @param idUsuarioSistema identifiador de tipo entero que funciona para la busqueda de un objeto tipo Coordinador
     * @return coordinador objeto tipo coordinador buscado a partir del parametro de tipo entero idUsuarioSistema
     */
    @Override
    public Coordinador getCoordinador(int idUsuarioSistema) {
        Coordinador coordinador = null;
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("select * from coordinador where idUsuarioSistema = ?");
            orden.setInt(1, idUsuarioSistema);
            ResultSet resultadoConsulta = orden.executeQuery();
            if (resultadoConsulta.first()){
                String numeroPersonal = resultadoConsulta.getString(1);
                String nombre = resultadoConsulta.getString(2)+" "+resultadoConsulta.getString(3)+" "+resultadoConsulta.getString(4);
                String correo = resultadoConsulta.getString(5);
                String telefono = resultadoConsulta.getString(6);
                coordinador = new Coordinador(numeroPersonal, nombre, correo, telefono);
            }else{
                Logger logger = Logger.getLogger("Logger");
                logger.log(Level.WARNING, "No se encuentra el coordinador en la base de datos");
            }
        }catch(SQLException | NullPointerException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
        }
        return coordinador;
    }
}
