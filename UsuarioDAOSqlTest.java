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
    public UsuarioDAOSqlTest() {
        idUsuarioSistema = 1;
    }
    @Test
    public void testGetUsuario() {
        UsuarioDAOSql usuarioDao = new UsuarioDAOSql();
        assertNotNull(usuarioDao.getUsuario(idUsuarioSistema));
    }
}
