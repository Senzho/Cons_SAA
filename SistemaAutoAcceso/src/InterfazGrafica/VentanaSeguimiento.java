package InterfazGrafica;

import LogicaNegocio.DAO.ActividadDAOSql;
import LogicaNegocio.Entidades.Actividad;
import LogicaNegocio.Entidades.ActividadRegistrada;
import LogicaNegocio.Entidades.Inscripcion;
import LogicaNegocio.DAO.UsuarioDAOSql;
import LogicaNegocio.Entidades.Usuario;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaSeguimiento extends JFrame implements ListListener, CursorListener{
    private Inscripcion inscripcion;
    private Container contenedor;
    private ComboBox comboModulo;
    private ComboBox comboSeccion;
    private Button botonRegistrar;
    private Button botonSalir;
    private JPanel panelActividades;
    private JTextArea textAreaObservacion;
    private  ActividadDAOSql actividadDao;
    private ArrayList<ActividadRegistrada> listaActividades;
    private String matricula;
    private String numeroPersonal;
    private int idInscripcion;
    private int idExperiencia;
    
    public VentanaSeguimiento(Inscripcion inscripcion, String matricula,String numeroPersonal, int idInscripcion, int idExperiencia){
        this.inscripcion = inscripcion;
        this.matricula = matricula;
        this.numeroPersonal = numeroPersonal;
        this.idInscripcion = idInscripcion;
        this.idExperiencia = idExperiencia;
        this.inicializarComponentes();
        this.establecerPropiedades();
        CombosModuloSeccion combos = new CombosModuloSeccion();
        combos.cargarComboMoulo(this.comboModulo);
        combos.cargarComboSeccion(this.comboSeccion);
        setTitle("Seguimiento");
        setSize(730,480);
        setLocationRelativeTo(null);
        setVisible(true);
        getListaActividadesRegistradas();
        mostrarActividadesRegistradas();
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
        UsuarioDAOSql usuarioDao = new UsuarioDAOSql();
        Usuario usuario = usuarioDao.getUsuario(this.matricula);
        JLabel labelNombre = new JLabel(/*Nombre del alumno*/usuario.getNombre());
        JLabel labelInscripcion = new JLabel(/*Numero de inscripción del alumno*/"Inscripción: "+inscripcion.getNumeroInscripcion()+"° oprtunidad");
        JLabel labelEstado = new JLabel(/*Estado del alumno*/"Estado: "+inscripcion.getEstadoInscripcion());
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
        JLabel labelCurso = new JLabel(/*Curso del alumno*/"Curso: "+inscripcion.getCurso().getNombreCurso());
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
        comboModulo.addListListener(this);
        comboSeccion.addListListener(this);
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
        panelActividades.setBorder(BorderFactory.createLineBorder(panelActividades.getBackground(),10));
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
        this.botonRegistrar.addCursorListener(this);
        this.botonSalir.addCursorListener(this);
    }
    public void establecerPropiedades(){
        this.contenedor.setBackground(new Colores().getColorBase());
        this.textAreaObservacion.setMargin(new Insets(10, 10, 10, 10));
        this.textAreaObservacion.setEditable(false);
        this.textAreaObservacion.setWrapStyleWord(true);
        this.textAreaObservacion.setLineWrap(true);
        this.textAreaObservacion.setBackground(null);
    }
    public void getListaActividadesRegistradas(){
        actividadDao = new ActividadDAOSql();
        this.listaActividades = actividadDao.getListaActividadesRegistradas(this.inscripcion.getIdInscripcion());
    }
    public void mostrarActividadesRegistradas(){
        Actividad actividad;
        Fecha fecha = new Fecha();
        int modulo = Integer.parseInt(this.comboModulo.getSelectedItem());
        int seccion = Integer.parseInt(this.comboSeccion.getSelectedItem());
        panelActividades.removeAll();
        for(int i= 0; i< this.listaActividades.size(); i++){
           actividad = actividadDao.getActividad(listaActividades.get(i).getIdActividad());
           if(actividad.getDatosExperiencia().getModulo() == modulo && actividad.getDatosExperiencia().getSeccion() == seccion){
                JPanel panelActividad = new JPanel();
                panelActividad.setBackground(new Colores().getColorBase());
                panelActividad.setBorder(BorderFactory.createLineBorder(panelActividades.getBackground(),10));
                panelActividad.setLayout(new BorderLayout());
                panelActividad.add(new JLabel("Actividad: "+actividad.getDatosActividad().getNombreActividad()),BorderLayout.NORTH);
                panelActividad.add(new JLabel("Entrega: "+listaActividades.get(i).getFecha()), BorderLayout.CENTER);
                Date fechaFin = actividad.getDatosActividad().getFechaFin();
                Date fechaEntrega = listaActividades.get(i).getFecha();
                boolean valido = fecha.validarFechas(fechaFin, fechaEntrega);
                if(valido){
                     panelActividad.add(new JLabel("Entrego a tiempo: Si"),BorderLayout.SOUTH);
                }else{
                    panelActividad.add(new JLabel("Entrego a tiempo: No"),BorderLayout.SOUTH);
                }
                this.panelActividades.add(panelActividad);
           }
        }
        panelActividades.setVisible(false);
        panelActividades.setVisible(true);
    }

    @Override
    public void ItemSelected(ComboBox combo) {
        if(combo.equals(this.comboModulo)){
            mostrarActividadesRegistradas();
        }
        if(combo.equals(this.comboSeccion)){
            mostrarActividadesRegistradas();
        }
    }

    @Override
    public void cursorClicked(Button boton) {
        if(boton.equals(this.botonRegistrar)){
           new VentanaRegistrarActividad(this.numeroPersonal, this.idInscripcion, this.idExperiencia);
        }else if(boton.equals(this.botonSalir)){
            dispose();
        }
    }
}