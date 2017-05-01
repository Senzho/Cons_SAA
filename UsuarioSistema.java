package LogicaNegocio;

public class UsuarioSistema {
    private int id;
    private String usuario;
    private String contrasena;

    public UsuarioSistema(int id, String usuario, String contrasena) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }
    public String getUsuario() {
        return usuario;
    }
    public String getContrasena() {
        return contrasena;
    }
}
