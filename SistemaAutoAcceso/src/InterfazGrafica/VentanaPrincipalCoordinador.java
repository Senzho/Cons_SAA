package InterfazGrafica;

import LogicaNegocio.Entidades.Coordinador;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaPrincipalCoordinador extends JFrame implements CursorListener, WindowListener{
    private Container contenedor;
    private JLabel labelNombre;
    private Button botonPerfil;
    private Button botonCerrarSesion;
    private Button botonCursos;
    private Button botonUsuarios;
    private Button botonReportes;
    private Button botonAvisos;
    private Button botonExperiencias;
    private Button botonCalendario;
    private Button botonAgregar;
    private Button botonSeguimiento;
    private final Colores COLORES;
    private final Coordinador COORDINADOR;
    
    public VentanaPrincipalCoordinador(Coordinador coordinador){
        this.COORDINADOR = coordinador;
        this.COLORES = new Colores();
        if (coordinador == null){
            JOptionPane.showMessageDialog(null, "El usuario esta vacío");
            regresarInicioSesion();
        }else{
            inicializarComponentes();
            establecerPropiedades();
            setSize(840,480);
            setLocationRelativeTo(null);
            setTitle("Auto Acceso");
            setVisible(true);
        }
    }
    
    public void inicializarComponentes(){
        this.contenedor = getContentPane();
        BorderLayout borderContenedor = new BorderLayout();
        borderContenedor.setVgap(1);
        this.contenedor.setLayout(borderContenedor);
        /**
         * Panel superior.
         */
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(this.COLORES.getColorBase());
        JPanel panelPerfil = new JPanel(new BorderLayout());
        panelPerfil.setBackground(this.COLORES.getColorBase());
        this.botonPerfil = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/IconoEditarOscuro.png")), "Perfil");
        panelSuperior.add(panelPerfil, BorderLayout.LINE_START);
        this.botonCerrarSesion = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/IconoEliminarOscuro.png")), "Cerrar sesión");
        panelSuperior.add(this.botonCerrarSesion.getButton(), BorderLayout.LINE_END);
        panelPerfil.add(this.labelNombre = new JLabel(), BorderLayout.LINE_START);
        panelPerfil.add(this.botonPerfil.getButton(), BorderLayout.LINE_END);
        this.contenedor.add(panelSuperior, BorderLayout.PAGE_START);
        /**
         * Panel central.
         */
        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.setBackground(this.COLORES.getColorBase());
        JPanel panelAcomodoBotones = new JPanel(new BorderLayout());
        panelAcomodoBotones.setBackground(this.COLORES.getColorBase());
        GridLayout gridBotones = new GridLayout(3,1);
        gridBotones.setVgap(1);
        JPanel panelBotones = new JPanel(gridBotones);
        JPanel panelAvisos = new JPanel(new BorderLayout());
        panelAvisos.setBackground(this.COLORES.getColorBase());
        panelAcomodoBotones.add(panelBotones, BorderLayout.PAGE_START);
        panelCentral.add(panelAcomodoBotones, BorderLayout.WEST);
        panelCentral.add(panelAvisos, BorderLayout.CENTER);
        GridLayout gridFil1 = new GridLayout(1,2);
        gridFil1.setHgap(1);
        JPanel panelFil1 = new JPanel(gridFil1);
        this.botonCursos = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/IconoEditarOscuro.png")), " Cursos ");
        this.botonUsuarios = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/IconoEditarOscuro.png")), "Usuarios");
        panelFil1.add(this.botonCursos.getButton());
        panelFil1.add(this.botonUsuarios.getButton());
        panelBotones.add(panelFil1);
        GridLayout gridFil2 = new GridLayout(1,2);
        gridFil2.setHgap(1);
        JPanel panelFil2 = new JPanel(gridFil2);
        this.botonReportes = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/IconoEditarOscuro.png")), "Reportes");
        this.botonAvisos = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/IconoEditarOscuro.png")), " Avisos ");
        panelFil2.add(this.botonReportes.getButton());
        panelFil2.add(this.botonAvisos.getButton());
        panelBotones.add(panelFil2);
        this.botonExperiencias = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/IconoEditarOscuro.png")), "Experiencias educativas");
        panelBotones.add(this.botonExperiencias.getButton());
        panelAvisos.add(new JLabel("   Avisos"), BorderLayout.PAGE_START);
        this.contenedor.add(panelCentral, BorderLayout.CENTER);
        /**
         * Panel inferior.
         */
        FlowLayout flowInferior = new FlowLayout();
        flowInferior.setVgap(0);
        flowInferior.setHgap(0);
        JPanel panelInferior = new JPanel(flowInferior);
        panelInferior.setBackground(this.COLORES.getColorBase());
        this.botonCalendario = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/IconoEditarOscuro.png")), " Calendario de actividades ");
        this.botonAgregar = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/IconoMasOscuro.png")), " Agregar actividad ");
        this.botonSeguimiento = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/IconoEditarOscuro.png")), " Seguimiento de alumno ");
        panelInferior.add(this.botonCalendario.getButton());
        panelInferior.add(this.botonAgregar.getButton());
        panelInferior.add(this.botonSeguimiento.getButton());
        this.contenedor.add(panelInferior, BorderLayout.PAGE_END);
    }
    public void establecerPropiedades(){
        this.addWindowListener(this);
        this.labelNombre.setText("   "+this.COORDINADOR.getNombre()+"   ");
        this.botonCerrarSesion.addCursorListener(this);
        this.botonAgregar.addCursorListener(this);
        this.botonCalendario.addCursorListener(this);
    }
    public void regresarInicioSesion(){
        new VentanaInicioSesion();
        dispose();
    }

    /**
     * Eventos.
     */
    
    @Override
    public void cursorClicked(Button boton) {
        if (boton.equals(this.botonCalendario)){
            new VentanaMostrarActividad();
        }else if(boton.equals(this.botonAgregar)){
            new VentanaEditarAgregarActividad(true, 0);
        }else if(boton.equals(this.botonCerrarSesion)){
            regresarInicioSesion();
        }
    }
    
    @Override
    public void windowOpened(WindowEvent evento) {
        
    }
    @Override
    public void windowClosing(WindowEvent evento) {
        regresarInicioSesion();
    }
    @Override
    public void windowClosed(WindowEvent evento) {
        
    }
    @Override
    public void windowIconified(WindowEvent evento) {
        
    }
    @Override
    public void windowDeiconified(WindowEvent evento) {
        
    }
    @Override
    public void windowActivated(WindowEvent evento) {
        
    }
    @Override
    public void windowDeactivated(WindowEvent evento) {
        
    }
}
