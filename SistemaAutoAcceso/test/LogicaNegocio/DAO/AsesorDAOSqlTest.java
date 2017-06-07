package LogicaNegocio.DAO;

import org.junit.Test;
import static org.junit.Assert.*;

public class AsesorDAOSqlTest {
    private AsesorDAOSql asesorDao;
    private String numeroPersonal;
    private int idUsuarioSistema;
    
    public AsesorDAOSqlTest() {
        this.asesorDao = new AsesorDAOSql();
        this.numeroPersonal = "AS1";
        this.idUsuarioSistema = 2;
    }

    @Test
    public void testGetListaAsesores() {
        int esperado = 0;
        assertNotEquals(this.asesorDao.getListaAsesores().size(), esperado);
    }
    @Test
    public void testGetAsesorNotNull(){
        assertNotNull(this.asesorDao.getAsesor(numeroPersonal));        
    }
    @Test
    public void testGetAsesorNull(){
        assertNull(this.asesorDao.getAsesor("bla"));
    }
    @Test
    public void testGetAsesorEquals(){
        String esperado = this.numeroPersonal;
        assertEquals(this.asesorDao.getAsesor(numeroPersonal).getNumeroPersonal(), esperado);
    }
    @Test
    public void testGetAsesorIdNotNull(){
        assertNotNull(this.asesorDao.getAsesorId(this.idUsuarioSistema));
    }
    @Test
    public void testGetAsesorIdNull(){
        assertNull(this.asesorDao.getAsesorId(0));
    }
}
