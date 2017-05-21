package LogicaNegocio.DAO;

import LogicaNegocio.Entidades.Actividad;
import LogicaNegocio.Entidades.ActividadRegistrada;
import LogicaNegocio.Entidades.DatosActividad;
import LogicaNegocio.Entidades.DatosExperiencia;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActividadDAOSqlEliminarTest {
    private ActividadRegistrada actividad;
    private int idInscripcion;
    private String numeroPersonal;
    private ActividadDAOSql actividadDao;
    private int idActividad;
    private String nombreActividad;
    
    public ActividadDAOSqlEliminarTest() {
        Date fecha = java.sql.Date.valueOf("2017-03-05");
        actividad = new ActividadRegistrada(25, fecha, "Faltan horas de estudio", 1);
        idInscripcion = 1;
        idActividad = 1;
        numeroPersonal = "SH67GV";
        nombreActividad = "Conversacion obligatoria 1";
        actividadDao = new ActividadDAOSql();
    }
    @Test 
    public void getIdActividad(){
        assertEquals(actividadDao.getIdActividad(nombreActividad), idActividad);
    }
    @Test
    public void testGetActividadNull(){
        assertNotNull(actividadDao.getActividad(idActividad));
    }
    @Test
    public void testEliminarActividad(){
        boolean esperado = true;
        assertEquals(actividadDao.eliminarActividad(1), esperado);
    }
}
