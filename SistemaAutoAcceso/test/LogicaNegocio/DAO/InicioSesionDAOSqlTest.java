package LogicaNegocio.DAO;

import LogicaNegocio.Logica.CodigoUsuario;
import org.junit.Test;
import static org.junit.Assert.*;

public class InicioSesionDAOSqlTest {
    private InicioSesionDAOSql inicioSesionDAO;
    private String usuario;
    private String contrasena;
    private CodigoUsuario codigo;
    
    public InicioSesionDAOSqlTest() {
        this.inicioSesionDAO = new InicioSesionDAOSql();
    }

    @Test
    public void testUsuarioNotNull() {
        this.usuario = "Coor1";
        this.contrasena = this.usuario;
        assertNotNull(this.inicioSesionDAO.buscarUsuario(usuario, contrasena).getCodigo());
    }
    @Test
    public void testUsuarioEquals(){
        this.usuario = "Coor1";
        this.contrasena = this.usuario;
        assertEquals(this.inicioSesionDAO.buscarUsuario(usuario, contrasena).getUsuarioSistema().getUsuario(), this.usuario);
    }
    @Test
    public void testUsuarioValido(){
        this.usuario = "Coor1";
        this.contrasena = this.usuario;
        this.codigo = CodigoUsuario.usuarioValido;
        assertEquals(this.inicioSesionDAO.buscarUsuario(usuario, contrasena).getCodigo(), this.codigo);
    }
    @Test
    public void testUsuarioInvalido(){
        this.usuario = "Coor1";
        this.contrasena = "Coor";
        this.codigo = CodigoUsuario.usuarioInvalido;
        assertEquals(this.inicioSesionDAO.buscarUsuario(usuario, contrasena).getCodigo(), this.codigo);
    }
    @Test
    public void testusuarioInexistente(){
        this.usuario = "sopa";
        this.contrasena = "fideos";
        this.codigo = CodigoUsuario.usuarioInexistente;
        assertEquals(this.inicioSesionDAO.buscarUsuario(usuario, contrasena).getCodigo(), this.codigo);
    }
}
