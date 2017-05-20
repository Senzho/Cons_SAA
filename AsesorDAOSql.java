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
            Asesor asesor;
            while(resultadoConsulta.next()){
                numeroPersonal = resultadoConsulta.getString(1);
                nombre = resultadoConsulta.getString(4) +" "+ resultadoConsulta.getString(6) +" "+ resultadoConsulta.getString(5);
                idioma = resultadoConsulta.getString(2);
                asesor = new Asesor(numeroPersonal, nombre, idioma);
                listaAsesores.add(asesor);
            }
        }catch(SQLException | NullPointerException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
        }
        return listaAsesores;
    }
}
