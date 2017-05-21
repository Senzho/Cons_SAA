package InterfazGrafica;

import LogicaNegocio.DAO.ActividadDAOSql;
import LogicaNegocio.Entidades.ActividadRegistrada;
import LogicaNegocio.Entidades.Actividad;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.text.DateFormat;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VentanaRegistrarActividad extends JFrame implements CursorListener, ListListener{
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
    private DateFormat formatoFecha;
    private Date fechaActual;
    private String numeroPersonal;
    private int idInscripcion;
    private int idExperiencia;
    
    public VentanaRegistrarActividad(String numeroPersonal, int idInscripcion, int idExperiencia){
        this.numeroPersonal = numeroPersonal;
        this.idInscripcion = idInscripcion;
        this.idExperiencia = idExperiencia;
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
        CombosModuloSeccion combos = new CombosModuloSeccion();
        combos.cargarComboMoulo(this.comboModulo);
        combos.cargarComboSeccion(this.comboSeccion);
        this.cargarComboPuntaje();
        this.cargarComboActividad();
    }
    public void inicializarComponentes(){
        panelPrincipal = new JPanel();
        panelBotones = new JPanel();
        panelObservaciones = new JPanel();
        panelAtributos = new JPanel();
        txtObservacion = new JTextArea();
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaActual = new Date();
        String fecha = formatoFecha.format(fechaActual);
        lblFecha = new JLabel(fecha);
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
        this.btnRegistrar.addCursorListener(this);
        this.btnCancelar.addCursorListener(this);
        this.comboModulo.addListListener(this);
        this.comboSeccion.addListListener(this);
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
    public void cargarComboActividad(){
       ActividadDAOSql actividadDao = new ActividadDAOSql();
       int modulo = Integer.parseInt(this.comboModulo.getSelectedItem());
       int seccion = Integer.parseInt(this.comboSeccion.getSelectedItem());
       ArrayList<Actividad> listaActividades = actividadDao.getListaActividades(idExperiencia,modulo,seccion);
       for(int i = 0; i< listaActividades.size(); i++){
           this.comboActividad.addString(listaActividades.get(i).getDatosActividad().getNombreActividad());
       }
    }
    public void cargarComboPuntaje(){
        for(int i = 1; i<100; i++){
            this.comboPuntaje.addString(""+i);
        }
    }

    @Override
    public void cursorClicked(Button boton) {
        if(boton.equals(btnRegistrar)){
            ActividadDAOSql actividadDao = new ActividadDAOSql();
            String nombreActividad = this.comboActividad.getSelectedItem();
            int porcentaje = Integer.parseInt(this.comboPuntaje.getSelectedItem());
            Date fecha = java.sql.Date.valueOf(this.lblFecha.getText());
            String observacion = this.txtObservacion.getText();
            int idActividad = actividadDao.getIdActividad(nombreActividad);
            ActividadRegistrada actividadRegistrada = new ActividadRegistrada(porcentaje, fecha, observacion, idActividad);
            boolean exito = actividadDao.registrarActividad(actividadRegistrada, idInscripcion, numeroPersonal);
            String mensaje="";
            if (exito){
                mensaje = "Actividad registrada con éxito";
            }else{
                mensaje = "No se pudo registrar la actividad";
            }
            JOptionPane.showMessageDialog(null, mensaje);
        }else if (boton.equals(this.btnCancelar)){
            dispose();
        }
    }

    @Override
    public void ItemSelected(ComboBox combo) {
        if (combo.equals(this.comboModulo) || combo.equals(this.comboSeccion)){
            
        }
    }
}
