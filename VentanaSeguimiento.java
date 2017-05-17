package InterfazGrafica;

import LogicaNegocio.Logica.Button;
import LogicaNegocio.Logica.Colores;
import LogicaNegocio.Logica.ComboBox;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaSeguimiento extends JFrame{
    private Container contenedor;
    private ComboBox comboModulo;
    private ComboBox comboSeccion;
    private Button botonRegistrar;
    private Button botonSalir;
    private JPanel panelActividades;
    private JTextArea textAreaObservacion;
    
    public VentanaSeguimiento(){
        this.inicializarComponentes();
        this.establecerPropiedades();
        this.cargarComboMoulo();
        this.cargarComboSeccion();
        setTitle("Seguimiento");
        setSize(730,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos/iconoDrakzo3.png")).getImage());
        setVisible(true);
    }
    
    public void inicializarComponentes(){
        this.contenedor = getContentPane();
        BorderLayout borderPrincipal = new BorderLayout();
        this.contenedor.setLayout(borderPrincipal);
        this.inicializarPanelSuperior();
        this.inicializarPanelCentral();
        this.inicializarPanelInferior();
    }
    public void inicializarPanelSuperior(){
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(new Colores().getColorBase());
        this.contenedor.add(panelSuperior, BorderLayout.NORTH);
        BoxLayout boxPanelSuperior = new BoxLayout(panelSuperior, BoxLayout.Y_AXIS);
        panelSuperior.setLayout(boxPanelSuperior);
        /**
         * Primera fila.
         */
        JLabel labelNombre = new JLabel(/*Nombre del alumno*/"Primitivo Cruz Hernández");
        JLabel labelInscripcion = new JLabel(/*Numero de inscripción del alumno*/"Inscripción: "+"1°a");
        JLabel labelEstado = new JLabel(/*Estado del alumno*/"Estado: "+"Regular");
        FlowLayout flowPrimeraFila = new FlowLayout(FlowLayout.LEFT);
        flowPrimeraFila.setHgap(10);
        JPanel panelPrimeraFila = new JPanel(flowPrimeraFila);
        panelPrimeraFila.setBackground(new Colores().getColorBase());
        panelPrimeraFila.add(labelNombre);
        panelPrimeraFila.add(labelInscripcion);
        panelPrimeraFila.add(labelEstado);
        panelSuperior.add(panelPrimeraFila);
        /**
         * Segunda fila.
         */
        JLabel labelCurso = new JLabel(/*Curso del alumno*/"Curso: "+"Inglés 1. Febrero - Julio 2017");
        FlowLayout flowSegundaFila = new FlowLayout(FlowLayout.LEFT);
        flowSegundaFila.setHgap(10);
        JPanel panelSegundaFila = new JPanel(flowSegundaFila);
        panelSegundaFila.setBackground(new Colores().getColorBase());
        panelSegundaFila.add(labelCurso);
        panelSuperior.add(panelSegundaFila);
        /**
         * Tercera fila.
         */
        JLabel labelModulo = new JLabel("Módulo: ");
        this.comboModulo = new ComboBox(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")));
        JLabel labelSeccion = new JLabel("Seccion: ");
        this.comboSeccion = new ComboBox(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")));
        FlowLayout flowTerceraFila = new FlowLayout(FlowLayout.LEFT);
        flowTerceraFila.setHgap(10);
        JPanel panelTerceraFila = new JPanel(flowTerceraFila);
        panelTerceraFila.setBackground(new Colores().getColorBase());
        panelTerceraFila.add(labelModulo);
        panelTerceraFila.add(this.comboModulo.getComboBox());
        panelTerceraFila.add(labelSeccion);
        panelTerceraFila.add(this.comboSeccion.getComboBox());
        panelSuperior.add(panelTerceraFila);
    }
    public void inicializarPanelCentral(){
        JPanel panelCentral = new JPanel();
        panelCentral.setBackground(new Colores().getColorBase());
        this.contenedor.add(panelCentral, BorderLayout.CENTER);
        GridLayout gridPanelCentral = new GridLayout(1, 2);
        gridPanelCentral.setHgap(10);
        panelCentral.setLayout(gridPanelCentral);
        /**
         * Columna 1.
         */
        JLabel labelActividades = new JLabel("Actividades realizadas:");
        this.panelActividades = new JPanel();
        BoxLayout boxPanelActividades = new BoxLayout(this.panelActividades, BoxLayout.Y_AXIS);
        this.panelActividades.setLayout(boxPanelActividades);
        JScrollPane scrollActividades = new JScrollPane(this.panelActividades);
        BorderLayout borderColumna1 = new BorderLayout();
        JPanel panelColumna1 = new JPanel(borderColumna1);
        panelColumna1.setBackground(new Colores().getColorBase());
        panelColumna1.add(labelActividades, BorderLayout.NORTH);
        panelColumna1.add(scrollActividades, BorderLayout.CENTER);
        panelCentral.add(panelColumna1);
        /**
         * Columna 2.
         */
        JLabel labelObservaciones = new JLabel("Observaciones:");
        this.textAreaObservacion = new JTextArea();
        JScrollPane scrollTextObservacion = new JScrollPane(this.textAreaObservacion);
        BorderLayout borderColumna2 = new BorderLayout();
        JPanel panelColumna2 = new JPanel(borderColumna2);
        panelColumna2.setBackground(new Colores().getColorBase());
        panelColumna2.add(labelObservaciones, BorderLayout.NORTH);
        panelColumna2.add(scrollTextObservacion, BorderLayout.CENTER);
        panelCentral.add(panelColumna2);
    }
    public void inicializarPanelInferior(){
        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(new Colores().getColorBase());
        this.contenedor.add(panelInferior, BorderLayout.SOUTH);
        FlowLayout flowPanelInferior = new FlowLayout();
        flowPanelInferior.setVgap(0);
        flowPanelInferior.setHgap(0);
        panelInferior.setLayout(flowPanelInferior);
        this.botonRegistrar = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoMasOscuro.png")), "Registrar actividad");
        this.botonSalir = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoEliminarOscuro.png")), "Salir");
        panelInferior.add(this.botonRegistrar.getButton());
        panelInferior.add(this.botonSalir.getButton());
    }
    public void establecerPropiedades(){
        this.contenedor.setBackground(new Colores().getColorBase());
        this.textAreaObservacion.setMargin(new Insets(10, 10, 10, 10));
        this.textAreaObservacion.setEditable(false);
        this.textAreaObservacion.setWrapStyleWord(true);
        this.textAreaObservacion.setLineWrap(true);
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
}
