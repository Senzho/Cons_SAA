package InterfazGrafica;

import LogicaNegocio.DAO.CoordinadorDAOSql;
import LogicaNegocio.DAO.InicioSesionDAOSql;
import LogicaNegocio.DAO.AsesorDAOSql;
import LogicaNegocio.Entidades.Asesor;
import LogicaNegocio.Entidades.Coordinador;
import LogicaNegocio.Logica.CodigoUsuario;
import LogicaNegocio.Logica.UsuarioEncontrado;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaInicioSesion extends JFrame implements CursorListener{
    private Container contenedor;
    private JTextField textoUsuario;
    private JPasswordField textoContrasena;
    private Button botonIniciar;
    private Button botonCancelar;
    private Button botonIp;
    private JLabel imagenUv;
    private Colores colores;
    
    public VentanaInicioSesion(){
        this.colores = new Colores();
        inicializarComponentes();
        establecerPropiedades();
        setSize(280,420);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Auto Acceso - Iniciar sesión");
        setVisible(true);
    }
    
    public void inicializarComponentes(){
        this.contenedor = getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.contenedor.setBackground(this.colores.getColorBase());
        this.imagenUv = new JLabel();
        this.imagenUv.setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos/iconoUV.png")));
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(this.colores.getColorBase());
        panelSuperior.add(this.imagenUv, BorderLayout.CENTER);
        this.botonIp = new Button(this.colores, new ImageIcon(getClass().getResource("/RecursosGraficos/iconoEditarOscuro.png")), "Configurar IP");
        panelSuperior.add(this.botonIp.getButton(), BorderLayout.PAGE_START);
        this.contenedor.add(panelSuperior, BorderLayout.PAGE_START);
        /**
         * Panel central.
         */
        JPanel panelCentral = new JPanel(new GridBagLayout());
        panelCentral.setBackground(this.colores.getColorBase());
        GridBagConstraints constantes = new GridBagConstraints();
        constantes.insets = new Insets(10,10,10,10);
        constantes.gridx = 0;
        constantes.gridy = 0;
        constantes.gridheight = 1;
        constantes.gridwidth = 1;
        constantes.anchor = GridBagConstraints.NORTHWEST;
        constantes.fill = GridBagConstraints.NONE;
        panelCentral.add(new JLabel("Usuario: "), constantes);
        constantes.gridx = 1;
        constantes.gridwidth = 2;
        constantes.fill = GridBagConstraints.BOTH;
        constantes.weightx = 1;
        this.textoUsuario = new JTextField();
        panelCentral.add(this.textoUsuario, constantes);
        constantes.gridx = 0;
        constantes.gridy = 1;
        constantes.gridwidth = 1;
        constantes.weightx = 0;
        constantes.fill = GridBagConstraints.NONE;
        panelCentral.add(new JLabel("Contraseña: "), constantes);
        constantes.gridx = 1;
        constantes.gridy = 1;
        constantes.gridwidth = 2;
        constantes.fill = GridBagConstraints.BOTH;
        constantes.weightx = 1;
        this.textoContrasena = new JPasswordField();
        panelCentral.add(this.textoContrasena, constantes);
        this.contenedor.add(panelCentral, BorderLayout.CENTER);
        /**
         * Panel inferior.
         */
        FlowLayout flowBotones = new FlowLayout();
        flowBotones.setVgap(0);
        flowBotones.setHgap(0);
        JPanel panelBotones = new JPanel(flowBotones);
        panelBotones.setBackground(this.colores.getColorBase());
        this.botonIniciar = new Button(this.colores, new ImageIcon(getClass().getResource("/RecursosGraficos/iconoMasOscuro.png")), "Entrar");
        this.botonCancelar = new Button(this.colores, new ImageIcon(getClass().getResource("/RecursosGraficos/iconoEliminarOscuro.png")), "Cancelar");
        panelBotones.add(this.botonIniciar.getButton());
        panelBotones.add(this.botonCancelar.getButton());
        this.contenedor.add(panelBotones, BorderLayout.PAGE_END);
    }
    public void establecerPropiedades(){
        this.botonCancelar.addCursorListener(this);
        this.botonIniciar.addCursorListener(this);
        this.botonIp.addCursorListener(this);
    }
    public void validarUsuario(String usuario, String contrasena){
        InicioSesionDAOSql inicioSesionDao = new InicioSesionDAOSql();
        UsuarioEncontrado usuarioEncontrado = inicioSesionDao.buscarUsuario(usuario, contrasena);
        if (usuarioEncontrado != null){
            CodigoUsuario codigo = usuarioEncontrado.getCodigo();
            if (codigo.equals(CodigoUsuario.usuarioValido)){
                ingresarSistema(usuarioEncontrado);
            }else{
                mostrarMensajeError(codigo);
                borrarCampos();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Lo sentimos no se puede conectar con la base de datos :(");
        }
    }
    public void mostrarMensajeError(CodigoUsuario codigo){
        String mensaje = "";
        switch(codigo){
            case usuarioInvalido:
                mensaje = "Usuario y/o contraseña inválidos";
                break;
            case usuarioInexistente:
                mensaje = "El usuario no existe";
                break;
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
    private void ingresarSistema(UsuarioEncontrado usuario){
        switch(usuario.getTipo()){
            case 0:
                CoordinadorDAOSql coordinadorDao = new CoordinadorDAOSql();
                Coordinador coordinador = coordinadorDao.getCoordinador(usuario.getUsuarioSistema().getId());
                if (coordinador != null){
                    new VentanaPrincipalCoordinador(coordinador);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo recuperar el usuario");
                }
                break;
            case 1:
                AsesorDAOSql asesorDao = new AsesorDAOSql();
                Asesor asesor = asesorDao.getAsesorId(usuario.getUsuarioSistema().getId());
                if (asesor != null){
                    new VentanaPrincipalAsesor(asesor);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo recuperar el usuario");
                }
                break;
        }
    }
    private void borrarCampos(){
        this.textoUsuario.setText("");
        this.textoContrasena.setText("");
    }
    /**
     * Eventos. 
     */
    @Override
    public void cursorClicked(Button boton) {
        if (boton.equals(this.botonCancelar)){
            System.exit(0);
        }else if(boton.equals(this.botonIniciar)){
            String usuario = this.textoUsuario.getText();
            String contrasena = this.textoContrasena.getText();
            if (!usuario.trim().equals("") && !contrasena.trim().equals("")){
                validarUsuario(usuario, contrasena);
            }else{
                JOptionPane.showMessageDialog(null, "Ingresa tu usuario y contraseña");
            }
        }else if(boton.equals(this.botonIp)){
            new VentanaConfiguracionIp();
        }
    }
}
