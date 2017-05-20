package LogicaNegocio.DAO;

import org.junit.Test;
import static org.junit.Assert.*;

public class AsesorDAOSqlTest {
    private AsesorDAOSql asesorDao;
    
    public AsesorDAOSqlTest() {
        this.asesorDao = new AsesorDAOSql();
    }

    @Test
    public void testGetListaAsesores() {
        int esperado = 0;
        assertNotEquals(this.asesorDao.getListaAsesores().size(), esperado);
    }
    
}
