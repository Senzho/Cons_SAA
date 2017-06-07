package LogicaNegocio.DAO;

import AccesoDatos.ConexionSQL;
import LogicaNegocio.Entidades.UsuarioSistema;
import LogicaNegocio.Logica.CodigoUsuario;
import LogicaNegocio.Logica.Hash;
import LogicaNegocio.Logica.UsuarioEncontrado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InicioSesionDAOSql implements InicioSesionDAO{
    /**
     * El método busca el usuario solicitado.
     * @param usuario, el usuario ingresado.
     * @param contrasena, la contraseña ingresada.
     * @return usuarioEncontrado, regresa un objeto del tipo UsuarioEncontrado, que contiene un código de autenticación
     * del usuario, un objeto del tipo UsuarioSistema y el tipo de usuario. En caso de no encontrar una coincidencia, 
     * regresará un código de usuarioInexistente.
     */
    @Override
    public UsuarioEncontrado buscarUsuario(String usuario, String contrasena) {
        UsuarioEncontrado usuarioEncontrado = null;
        CodigoUsuario codigo = CodigoUsuario.usuarioValido;
        ConexionSQL conexionSql = new ConexionSQL();
        Connection conexion = conexionSql.getConexion();
        try{
            PreparedStatement orden = conexion.prepareStatement("select * from usuarioSistema where usuario = ? or contrasena = ?");
            orden.setString(1, usuario);
            orden.setString(2, contrasena);
            ResultSet resultadoConsulta = orden.executeQuery();
            UsuarioSistema usuarioSistema;
            if (resultadoConsulta.first()){
                int idUsuario;
                int tipo;
                Hash hash = new Hash();
                String hashContrasena = hash.hash(contrasena);
                if (resultadoConsulta.getString(2).equals(usuario) && resultadoConsulta.getString(3).equals(hashContrasena)){
                    idUsuario = resultadoConsulta.getInt(1);
                    usuarioSistema = new UsuarioSistema(idUsuario, usuario, contrasena);
                    tipo = resultadoConsulta.getInt(4);
                    usuarioEncontrado = new UsuarioEncontrado(codigo, usuarioSistema, tipo);
                }else{
                    codigo = CodigoUsuario.usuarioInvalido;
                    idUsuario = resultadoConsulta.getInt(1);
                    usuarioSistema = new UsuarioSistema(idUsuario, usuario, contrasena);
                    tipo = resultadoConsulta.getInt(4);
                    usuarioEncontrado = new UsuarioEncontrado(codigo, usuarioSistema, tipo);
                }
                idUsuario = resultadoConsulta.getInt(1);
                usuarioSistema = new UsuarioSistema(idUsuario, usuario, contrasena);
                tipo = resultadoConsulta.getInt(4);
                usuarioEncontrado = new UsuarioEncontrado(codigo, usuarioSistema, tipo);
            }else{
                codigo = CodigoUsuario.usuarioInexistente;
                usuarioSistema = new UsuarioSistema(0, usuario, contrasena);
                usuarioEncontrado = new UsuarioEncontrado(codigo, usuarioSistema, -1);
            }
        }catch(SQLException | NullPointerException excepcion){
            Logger logger = Logger.getLogger("Logger");
            logger.log(Level.WARNING, "La conexión podría ser nula | la sentencia SQL esta mal");
        }
        return usuarioEncontrado;
    }
}
