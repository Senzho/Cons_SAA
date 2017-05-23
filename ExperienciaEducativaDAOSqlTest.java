package LogicaNegocio.DAO;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExperienciaEducativaDAOSqlTest {
    private ExperienciaEducativaDAOSql experienciaEducativaDao;
    private int idExperienciaEducativa;
    
    public ExperienciaEducativaDAOSqlTest() {
        this.experienciaEducativaDao = new ExperienciaEducativaDAOSql();
        this.idExperienciaEducativa = 1;
    }

    @Test
    public void testGetListaExperiencias() {
        int esperado = 0;
        assertNotEquals(experienciaEducativaDao.getListaExperiencias().size(), esperado);
    }
    public void testGetExperienciaEducativa(){
        assertNotNull(experienciaEducativaDao.getExperienciaEducativa(idExperienciaEducativa));
    }
    
}
