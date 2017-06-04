package LogicaNegocio.DAO;

import org.junit.Test;
import static org.junit.Assert.*;

public class CoordinadorDAOSqlTest {
    private CoordinadorDAOSql coordinadorDao;
    private int idUsuarioSistema;
    
    public CoordinadorDAOSqlTest() {
        this.coordinadorDao = new CoordinadorDAOSql();
        this.idUsuarioSistema = 1;
    }

    @Test
    public void testGetCoordinadorEquals() {
        String numeroPersonal = "SEC01";
        assertEquals(this.coordinadorDao.getCoordinador(idUsuarioSistema).getNumeroPersonal(), numeroPersonal);
    }
    @Test
    public void testGetCoordinadorNotNull(){
        assertNotNull(this.coordinadorDao.getCoordinador(idUsuarioSistema));
    }
    @Test
    public void testGetCoordinadorNull(){
        assertNull(this.coordinadorDao.getCoordinador(0));
    }
}
