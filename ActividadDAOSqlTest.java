package LogicaNegocio.DAO;

import LogicaNegocio.Entidades.ActividadRegistrada;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActividadDAOSqlTest {
    private ActividadRegistrada actividad;
    private int idInscripcion;
    private String numeroPersonal;
    
    public ActividadDAOSqlTest() {
        Date fecha = java.sql.Date.valueOf("2017-03-05");
        actividad = new ActividadRegistrada(25, fecha, "Faltan horas de estudio", 1);
        idInscripcion = 1;
        numeroPersonal = "SH67GV";
    }

    @Test
    public void testRegistrarActividad() {
        boolean esperado = true;
        ActividadDAOSql actividadDao = new ActividadDAOSql();
        assertEquals(actividadDao.registrarActividad(actividad, idInscripcion, numeroPersonal), esperado);
    }
    
    @Test
    public void testGetActividadNull(){
        ActividadDAOSql actividadDao = new ActividadDAOSql();
        int idActividad = 1;
        assertNotNull(actividadDao.getActividad(idActividad));
    }
    
    @Test
    public void testGetActividadEquals(){
        ActividadDAOSql actividadDao = new ActividadDAOSql();
        int idActividad = 1;
        assertEquals(actividadDao.getActividad(idActividad).getDatosActividad().getIdActividad(), idActividad);
    }
    
    @Test
    public void testListaActividadesRegistradasEquals(){
        ActividadDAOSql actividadDao = new ActividadDAOSql();
        int longitud = 0;
        assertNotEquals(actividadDao.getListaActividadesRegistradas(1).size(), longitud);
    }
    
    @Test
    public void testListaActividadesEquals(){
        ActividadDAOSql actividadDao = new ActividadDAOSql();
        int longitud = 0;
        assertNotEquals(actividadDao.getListaActividades(1000, 1, 1), longitud);
    }
}
