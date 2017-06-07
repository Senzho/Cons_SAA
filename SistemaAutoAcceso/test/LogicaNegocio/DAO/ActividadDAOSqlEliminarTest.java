package LogicaNegocio.DAO;

import LogicaNegocio.Entidades.ActividadRegistrada;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActividadDAOSqlEliminarTest {
    private ActividadDAOSql actividadDao;
    private int idActividad;
    
    public ActividadDAOSqlEliminarTest() {
        idActividad = 1;
        actividadDao = new ActividadDAOSql();
    }
    
    @Test
    public void testEliminarActividad(){
        boolean esperado = true;
        int id = this.actividadDao.getUltimoId();
        assertEquals(actividadDao.eliminarActividad(id), esperado);
    }
}
