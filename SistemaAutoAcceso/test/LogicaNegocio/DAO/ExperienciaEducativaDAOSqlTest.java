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
    @Test
    public void testGetExperienciaEducativaNotNull(){
        assertNotNull(experienciaEducativaDao.getExperienciaEducativa(idExperienciaEducativa));
    }
    @Test
    public void testGetExperienciaEducativaNull(){
        assertNull(this.experienciaEducativaDao.getExperienciaEducativa(0));
    }
    @Test
    public void testGetExperienciaEducativaEquals(){
        int esperado = this.idExperienciaEducativa;
        assertEquals(this.experienciaEducativaDao.getExperienciaEducativa(this.idExperienciaEducativa).getIdExperiencia(), esperado);
    }
}
