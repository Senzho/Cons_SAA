package LogicaNegocio.DAO;

import LogicaNegocio.Entidades.Usuario;

public interface UsuarioDAO {
     public Usuario getUsuario(String matricula);
    public Usuario getUsuario(int idUsuarioSistema);
}
