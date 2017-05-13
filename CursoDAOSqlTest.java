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
    public CursoDAOSqlTest() {
        nrc = 1;
    }
    @Test
    public void testGetCurso() {
        CursoDAOSql cursoDao = new CursoDAOSql();
        assertNotNull(cursoDao.getCurso(nrc));
    }
}
