package InterfazGrafica;

import LogicaNegocio.Logica.Button;
import LogicaNegocio.Logica.Colores;
import LogicaNegocio.Logica.ComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class VentanaRegistrarActividad extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelBotones;
    private JPanel panelObservaciones;
    private JPanel panelAtributos;
    private Button btnRegistrar;
    private Button btnCancelar;
    private JTextArea txtObservacion;
    private ComboBox comboModulo;
    private ComboBox comboSeccion;
    private ComboBox comboActividad;
    private ComboBox comboPuntaje;
    private JLabel lblFecha;
    private JScrollPane scrollObservacion;
    
    public VentanaRegistrarActividad(){
        this.inicializarComponentes();
        this.configurar();
        setTitle("Registrar actividad");
        setSize(400,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void configurar(){
        this.configurarPanelBotones();
        this.configurarPanelObservaciones();
        this.configurarPanelAtributos();
        this.cargarComboMoulo();
        this.cargarComboSeccion();
        this.cargarComboPuntaje();
    }
    public void inicializarComponentes(){
        panelPrincipal = new JPanel();
        panelBotones = new JPanel();
        panelObservaciones = new JPanel();
        panelAtributos = new JPanel();
        txtObservacion = new JTextArea();
        lblFecha = new JLabel("12-12-12");
        txtObservacion.setWrapStyleWord(true);
        txtObservacion.setLineWrap(true);
        txtObservacion.setBackground(null);
        txtObservacion.setMargin(new Insets(10, 20, 10, 20));
        this.scrollObservacion = new JScrollPane(txtObservacion);
        this.btnRegistrar = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoMasOscuro.png")), "Aceptar");
        this.btnCancelar = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoEliminarOscuro.png")), "Cancelar");
        this.comboModulo = new ComboBox(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")));
        this.comboSeccion = new ComboBox(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")));
        this.comboActividad = new ComboBox(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")));
        this.comboPuntaje = new ComboBox(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")));
        
    }
    public void configurarPanelBotones(){
        panelPrincipal.setLayout(new BorderLayout());
        this.add(panelPrincipal);
        panelBotones.setBackground(new Colores().getColorBase());
        FlowLayout flowBotones = new FlowLayout();
        flowBotones.setVgap(0);
        flowBotones.setHgap(0);
        panelBotones.setLayout(flowBotones);
        panelBotones.add(this.btnRegistrar.getButton());
        panelBotones.add(this.btnCancelar.getButton());
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
    }
    public void configurarPanelObservaciones(){
        panelObservaciones.setLayout(new BorderLayout());
        panelObservaciones.setBackground(new Colores().getColorBase());
        panelObservaciones.add(new JLabel("Observaciones:"), BorderLayout.NORTH);
        panelObservaciones.add(this.scrollObservacion, BorderLayout.CENTER);
        this.panelPrincipal.add(panelObservaciones,BorderLayout.CENTER);
    }
    public void configurarPanelAtributos(){
        BoxLayout boxPanelSuperior = new BoxLayout(panelAtributos, BoxLayout.Y_AXIS);
        panelAtributos.setLayout(boxPanelSuperior);
        FlowLayout flowPrimeraFila = new FlowLayout(FlowLayout.CENTER);
        JPanel panelPrimeraFila = new JPanel(flowPrimeraFila);
        panelPrimeraFila.setBackground(new Colores().getColorBase());
        panelPrimeraFila.add(new JLabel("Modulo"));
        panelPrimeraFila.add(this.comboModulo.getComboBox());
        panelPrimeraFila.add(new JLabel("Sección"));
        panelPrimeraFila.add(this.comboSeccion.getComboBox());
        panelAtributos.add(panelPrimeraFila);
        /**
         * 
         */
        JPanel panelSegundaFila = new JPanel();
        panelSegundaFila.setBackground(new Colores().getColorBase());
        FlowLayout flowSegundaFila = new FlowLayout(FlowLayout.CENTER);
        panelSegundaFila.setLayout(flowSegundaFila);
        panelSegundaFila.add(new JLabel("Actividad:"));
        panelSegundaFila.add(this.comboActividad.getComboBox());
        comboActividad.addString("Conversacion obligatoria #6");
        panelAtributos.add(panelSegundaFila);
        /**
         * 
         */
        JPanel panelTerceraFila = new JPanel();
        panelTerceraFila.setBackground(new Colores().getColorBase());
        FlowLayout flowTerceraFila = new FlowLayout(FlowLayout.CENTER);
        panelTerceraFila.setLayout(flowTerceraFila);
        panelTerceraFila.add(new JLabel("Fecha:"));
        panelTerceraFila.add(this.lblFecha);
        panelTerceraFila.add(new JLabel("Puntaje"));
        panelTerceraFila.add(this.comboPuntaje.getComboBox());
        panelAtributos.add(panelTerceraFila);
        this.panelPrincipal.add(panelAtributos, BorderLayout.NORTH);
    }
    public void cargarComboMoulo(){
        for(int i = 1; i<4; i++){
            this.comboModulo.addString(""+i);
        }
    }
    public void cargarComboSeccion(){
        for(int i = 1; i<5; i++){
            this.comboSeccion.addString(""+i);
        }
    }
    public void cargarComboPuntaje(){
        for(int i = 1; i<100; i++){
            this.comboPuntaje.addString(""+i);
        }
    }
    public void agregarEventos(){
    
    }
}
