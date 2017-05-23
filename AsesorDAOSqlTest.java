package LogicaNegocio.DAO;

import org.junit.Test;
import static org.junit.Assert.*;

public class AsesorDAOSqlTest {
    private AsesorDAOSql asesorDao;
    private String numeroPersonal;
    public AsesorDAOSqlTest() {
        this.asesorDao = new AsesorDAOSql();
        this.numeroPersonal = "SH67GV";
    }

    @Test
    public void testGetListaAsesores() {
        int esperado = 0;
        assertNotEquals(this.asesorDao.getListaAsesores().size(), esperado);
    }
    @Test
    public void testGetAsesor(){
        assertNotNull(this.asesorDao.getAsesor(numeroPersonal));        
    }
}
