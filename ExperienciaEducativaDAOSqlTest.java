package LogicaNegocio.DAO;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExperienciaEducativaDAOSqlTest {
    private ExperienciaEducativaDAOSql experienciaEducativaDao;
    
    public ExperienciaEducativaDAOSqlTest() {
        this.experienciaEducativaDao = new ExperienciaEducativaDAOSql();
    }

    @Test
    public void testGetListaExperiencias() {
        int esperado = 0;
        assertNotEquals(experienciaEducativaDao.getListaExperiencias().size(), esperado);
    }
    
}
