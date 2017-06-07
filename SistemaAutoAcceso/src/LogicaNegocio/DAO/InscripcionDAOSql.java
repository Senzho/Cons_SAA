package LogicaNegocio.DAO;

import AccesoDatos.ConexionSQL;
import LogicaNegocio.Entidades.Curso;
import LogicaNegocio.Entidades.Inscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InscripcionDAOSql implements InscripcionDAO {
    /**
     * El metodo getListaInscripciones() de tipo ArrayList<Inscripcion> regresa todas las inscripciones de un 
     * usuario mediante su atributo de tipo String matricula
     * @param matricula parametro de tipo String perteneciente un objeto de tipo Usuario que funciona como identificador 
     * para la busqueda de las inscripciones relacionadas con este parametro
     * @return listaInscripciones parametro del tipo ArrayList<Inscripcion> que muestra todas las inscripciones 
     * relacionadas con el parametro de tipo String (matricula) 
     */
    @Override
    public ArrayList<Inscripcion> getListaInscripciones(String matricula){
        ArrayList<Inscripcion> listaInscripciones = new ArrayList<>();
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("select *from inscripcion where matricula = ?");
            orden.setString(1, matricula);
            ResultSet resultadoConsulta = orden.executeQuery();
            while (resultadoConsulta.next()){
                int idInscripcion = resultadoConsulta.getInt(1);
                String estadoInscripcion = resultadoConsulta.getString(2);
                int numeroInscripcion = resultadoConsulta.getInt(4);
                int calificacionFinal = resultadoConsulta.getInt(3);
                int nrc = resultadoConsulta.getInt(6);
                CursoDAOSql cursoDAO = new CursoDAOSql();
                Curso curso = cursoDAO.getCurso(nrc);
                listaInscripciones.add(new Inscripcion(idInscripcion, estadoInscripcion, numeroInscripcion, calificacionFinal, curso));
            }
        }catch(SQLException | NullPointerException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
        }finally{
            conexionSql.cerrarConexion();
        }
        return listaInscripciones;
    }
}