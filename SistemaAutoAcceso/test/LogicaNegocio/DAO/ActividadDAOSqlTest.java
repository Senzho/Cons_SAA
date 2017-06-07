package LogicaNegocio.DAO;

import LogicaNegocio.Entidades.Actividad;
import LogicaNegocio.Entidades.ActividadRegistrada;
import LogicaNegocio.Entidades.DatosActividad;
import LogicaNegocio.Entidades.DatosExperiencia;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActividadDAOSqlTest {
    private ActividadRegistrada actividad;
    private int idInscripcion;
    private String numeroPersonal;
    private ActividadDAOSql actividadDao;
    private int idActividad;
    private String nombreActividad;
    private String salon;
    
    public ActividadDAOSqlTest() {
        Date fecha = java.sql.Date.valueOf("2017-03-05");
        actividad = new ActividadRegistrada(25, fecha, "Faltan horas de estudio", 1);
        idInscripcion = 1;
        idActividad = 1;
        salon = "105";
        numeroPersonal = "AS1";
        nombreActividad = "Actividad de prueba 1";
        actividadDao = new ActividadDAOSql();
    }
    
    @Test
    public void testGetActividadEquals(){
        assertEquals(actividadDao.getActividad(idActividad).getDatosActividad().getIdActividad(), idActividad);
    }
    @Test
    public void testAgregarActividad() {
        boolean esperado = true;
        Date fechaInicio = java.sql.Date.valueOf("2017-03-05");
        Date fechaFin = java.sql.Date.valueOf("2017-04-07");
        int id = this.actividadDao.getUltimoId();
        DatosActividad datosActividad = new DatosActividad(id, "Actividad de prueba 1", fechaInicio, fechaFin, String.valueOf(20), salon);
        DatosExperiencia datosExperiencia = new DatosExperiencia(1, 1, 1, numeroPersonal);
        Actividad actividad = new Actividad(datosActividad, datosExperiencia);
        assertEquals(actividadDao.agregarActividad(actividad), esperado);
    }
    @Test
    public void testUltimoId(){
        int esperado = 0;
        assertNotEquals(actividadDao.getUltimoId(), esperado);
    }
    @Test
    public void testGetListaActividades(){
        int longitud = 0;
        assertNotEquals(actividadDao.getListaActividades().size(), longitud);
    }
    @Test
    public void testGetListaActividadesEquals(){
        int longitud = 0;
        assertNotEquals(actividadDao.getListaActividades(1000, 1, 1), longitud);
    }
    @Test
    public void testRegistrarActividad() {
        boolean esperado = true;
        assertEquals(actividadDao.registrarActividad(actividad, idInscripcion, numeroPersonal), esperado);
    }
    @Test
    public void testGetListaActividadesRegistradasEquals(){
        int longitud = 0;
        assertNotEquals(actividadDao.getListaActividadesRegistradas(1).size(), longitud);
    }
    @Test
    public void textActualizarActividad(){
        boolean esperado = true;
        Date fechaInicio = java.sql.Date.valueOf("2017-03-05");
        Date fechaFin = java.sql.Date.valueOf("2017-04-07");
        DatosActividad datosActividad = new DatosActividad(1, "Actividad de prueba 1", fechaInicio, fechaFin, String.valueOf(20),salon);
        DatosExperiencia datosExperiencia = new DatosExperiencia(1, 1, 1, numeroPersonal);
        Actividad actividad = new Actividad(datosActividad, datosExperiencia);
        assertEquals(actividadDao.actiualizarActividad(actividad), esperado);
    }   
    @Test 
    public void getIdActividadEquals(){
        assertEquals(actividadDao.getIdActividad(nombreActividad), idActividad);
    }
    @Test
    public void testGetActividadNotNull(){
        assertNotNull(actividadDao.getActividad(idActividad));
    }
    @Test
    public void testGetActividadNull(){
        assertNull(actividadDao.getActividad(0));
    }
}
