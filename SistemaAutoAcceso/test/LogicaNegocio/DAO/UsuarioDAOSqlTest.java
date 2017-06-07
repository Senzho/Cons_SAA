package LogicaNegocio.DAO;

import LogicaNegocio.Entidades.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nemesis
 */
public class UsuarioDAOSqlTest {
    private int idUsuarioSistema;
    private String matricula;
    private UsuarioDAOSql usuarioDao;
    
    public UsuarioDAOSqlTest() {
        idUsuarioSistema = 3;
        this.matricula = "S15011641";
        this.usuarioDao = new UsuarioDAOSql();
    }
    
    @Test
    public void testGetUsuarioNotNullId() {
        assertNotNull(this.usuarioDao.getUsuario(idUsuarioSistema));
    }
    @Test
    public void testGetUsuarioNullId(){
        assertNull(this.usuarioDao.getUsuario(0));
    }
    @Test
    public void testGetUsuarioEquals(){
        String esperado = this.matricula;
        assertEquals(this.usuarioDao.getUsuario(idUsuarioSistema).getMatricula(), esperado);
    }
    @Test
    public void testGetUsuarioNotNullMatricula(){
        assertNotNull(this.usuarioDao.getUsuario(this.matricula));
    }
    @Test
    public void testGetUsuarioNullMatricula(){
        assertNull(this.usuarioDao.getUsuario("bla"));
    }
}
