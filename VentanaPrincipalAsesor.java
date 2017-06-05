package InterfazGrafica;

import LogicaNegocio.Entidades.Asesor;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaPrincipalAsesor extends JFrame implements CursorListener, WindowListener {
    private Button btnPerfil;
    private Button btnCerrarSesion;
    private Button btnReportes;
    private Button btnActividades;
    private Button btnRegistrarActividades;
    private Button btnseguimientoAlumno;
    private JLabel lblNombreAsesor;
    private JPanel panelVentana;
    private JPanel panelPerfil;
    private JPanel panelBotonesInferior;
    private JPanel panelBotonesSuperior;
    private JPanel panelDerecho;
    private JPanel panelBotonesDerecho;
    private JPanel panelCentral;
    private Asesor asesor;
    
    public VentanaPrincipalAsesor(Asesor asesor){
        this.asesor = asesor;
        if (this.asesor == null){
            JOptionPane.showMessageDialog(null, "El usuario esta vacío");
            regresarInicioSesion();
        }else{
            inicializarComponentes();
            configurarVentana();
            agregarComponentes();
        }
    }
    public void inicializarComponentes(){
        btnPerfil = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/IconoEditarOscuro.png")), "Perfil");
        btnCerrarSesion = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/IconoEliminarOscuro.png")), "Cerrar sesión");
        btnReportes = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/IconoEditarOscuro.png")), "Reportes");
        btnActividades = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/IconoEditarOscuro.png")), "Perfil");
        btnRegistrarActividades = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/IconoMasOscuro.png")), "Registrar actividad");
        btnseguimientoAlumno = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/IconoEditarOscuro.png")), "Seguimiento");
        panelVentana = new JPanel();
        panelPerfil = new JPanel();
        panelBotonesInferior = new JPanel();
        panelBotonesSuperior = new JPanel();
        panelDerecho = new JPanel();
        panelBotonesDerecho = new JPanel();
        panelCentral = new JPanel();
        btnRegistrarActividades.addCursorListener(this);
        btnCerrarSesion.addCursorListener(this);
    }
    public void configurarVentana(){
        setTitle("Sistema Autoacceso-UV");
        setSize(840,480);
        setLocationRelativeTo(null);
        setVisible(true);
        this.addWindowListener(this);
    }
    public void agregarComponentes(){
        panelVentana.setLayout(new BorderLayout());
        add(panelVentana);
        panelBotonesInferior.setLayout(new FlowLayout());
        panelBotonesInferior.add(this.btnRegistrarActividades.getButton());
        panelBotonesInferior.add(this.btnseguimientoAlumno.getButton());
        panelBotonesInferior.setBackground(new Colores().getColorBase());
        /**
         * 
         */
        panelBotonesSuperior.setLayout(new BorderLayout());
        panelBotonesSuperior.add(this.lblNombreAsesor = new JLabel("   "+asesor.getNombre()+"   "), BorderLayout.LINE_START);
        panelBotonesSuperior.add(this.btnCerrarSesion.getButton(), BorderLayout.LINE_END);
        panelPerfil.setLayout(new BorderLayout());
        panelPerfil.setBackground(new Colores().getColorBase());
        panelBotonesSuperior.setBackground(new Colores().getColorBase());
        panelPerfil.add(this.btnPerfil.getButton(), BorderLayout.LINE_START);
        panelBotonesSuperior.add(panelPerfil, BorderLayout.CENTER);
        panelCentral.add(new JLabel("Avisos:"), BorderLayout.NORTH);
        /**
         * 
         */
        panelDerecho.setLayout(new BorderLayout());
        panelBotonesDerecho.setLayout(new GridLayout(2,1));
        panelBotonesDerecho.add(this.btnReportes.getButton());
        panelBotonesDerecho.add(this.btnActividades.getButton());
        panelDerecho.setBackground(new Colores().getColorBase());
        panelDerecho.add(panelBotonesDerecho,BorderLayout.NORTH);
        panelVentana.add(panelCentral, BorderLayout.CENTER);
        panelVentana.add(panelDerecho, BorderLayout.LINE_START);
        panelVentana.add(panelBotonesSuperior, BorderLayout.NORTH);
        panelVentana.add(panelBotonesInferior, BorderLayout.SOUTH);
    }
    public void regresarInicioSesion(){
        new VentanaInicioSesion();
        dispose();
    }

    @Override
    public void cursorClicked(Button boton) {
       if (boton.equals(this.btnCerrarSesion)){
            regresarInicioSesion();
        }else if(boton.equals(this.btnRegistrarActividades)){
            new VentanaBuscarAlumno(asesor);
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
        
    }
    @Override
    public void windowClosing(WindowEvent we) {
        regresarInicioSesion();
    }
    @Override
    public void windowClosed(WindowEvent we) {
        
    }
    @Override
    public void windowIconified(WindowEvent we) {
        
    }
    @Override
    public void windowDeiconified(WindowEvent we) {
        
    }
    @Override
    public void windowActivated(WindowEvent we) {
        
    }
    @Override
    public void windowDeactivated(WindowEvent we) {
        
    }
}
