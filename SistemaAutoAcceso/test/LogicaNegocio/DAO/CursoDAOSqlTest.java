package LogicaNegocio.DAO;

import LogicaNegocio.Entidades.Curso;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CursoDAOSqlTest {
    private int nrc;
    private CursoDAOSql cursoDao;
    
    public CursoDAOSqlTest() {
        this.cursoDao = new CursoDAOSql();
        nrc = 1;
    }
    
    @Test
    public void testGetCursoNotNull() {
        assertNotNull(this.cursoDao.getCurso(nrc));
    }
    @Test
    public void testGetCursoNull(){
        assertNull(this.cursoDao.getCurso(0));
    }
    @Test
    public void testGetCursoEquals(){
        int esperado = this.nrc;
        assertEquals(this.cursoDao.getCurso(nrc).getNrc(), esperado);
    }
}
