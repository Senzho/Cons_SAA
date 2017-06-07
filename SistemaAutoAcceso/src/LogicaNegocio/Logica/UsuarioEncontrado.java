package LogicaNegocio.Logica;

import LogicaNegocio.Entidades.UsuarioSistema;

public class UsuarioEncontrado {
    private CodigoUsuario codigo;
    private UsuarioSistema usuarioSistema;
    private int tipo;

    public UsuarioEncontrado(CodigoUsuario codigo, UsuarioSistema usuarioSistema, int tipo) {
        this.codigo = codigo;
        this.usuarioSistema = usuarioSistema;
        this.tipo = tipo;
    }

    public CodigoUsuario getCodigo() {
        return codigo;
    }
    public UsuarioSistema getUsuarioSistema() {
        return usuarioSistema;
    }
    public int getTipo(){
        return tipo;
    }
}
