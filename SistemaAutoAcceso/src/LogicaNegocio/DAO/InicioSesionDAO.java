package LogicaNegocio.DAO;

import LogicaNegocio.Logica.UsuarioEncontrado;

public interface InicioSesionDAO {
    public UsuarioEncontrado buscarUsuario(String usuario, String contrasena);
}
