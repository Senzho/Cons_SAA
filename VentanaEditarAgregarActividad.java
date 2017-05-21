package InterfazGrafica;

import LogicaNegocio.DAO.ActividadDAOSql;
import LogicaNegocio.DAO.AsesorDAOSql;
import LogicaNegocio.DAO.ExperienciaEducativaDAOSql;
import LogicaNegocio.Entidades.Actividad;
import LogicaNegocio.Entidades.Asesor;
import LogicaNegocio.Entidades.DatosActividad;
import LogicaNegocio.Entidades.DatosExperiencia;
import LogicaNegocio.Entidades.ExperienciaEducativa;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaEditarAgregarActividad extends JFrame implements CursorListener{
    private Container contenedor;
    private ComboBox comboExperiencia;
    private JTextField textoActividad;
    private ComboBox comboAsesor;
    private ComboBox comboSalon;
    private ComboBox comboInicioDia;
    private ComboBox comboInicioMes;
    private ComboBox comboInicioAno;
    private ComboBox comboFinDia;
    private ComboBox comboFinMes;
    private ComboBox comboFinAno;
    private ComboBox comboCupo;
    private ComboBox comboModulo;
    private ComboBox comboSeccion;
    private Button botonGuardarAgregar;
    private Button botonCancelar;
    
    private ArrayList<ExperienciaEducativa> listaExperiencias;
    private ArrayList<Asesor> listaAsesores;
    
    public VentanaEditarAgregarActividad(){
        inicializarComponentes();
        establecerPropiedades();
        setTitle("Agregar actividad");
        setSize(450,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos/iconoDrakzo3.png")).getImage());
        setVisible(true);
    }
    
    public void inicializarComponentes(){
        this.contenedor = getContentPane();
        inicializarCombos();
        cargarCombos();
        this.contenedor.setLayout(new BorderLayout());
        /**
         * Panel central:
         */
        JPanel panelCentral = new JPanel();
        panelCentral.setBackground(new Colores().getColorBase());
        this.contenedor.add(panelCentral, BorderLayout.CENTER);
        panelCentral.setLayout(new GridBagLayout());
        GridBagConstraints contantesGrid = new GridBagConstraints();
        JLabel labelExperiencia = new JLabel("Experiencia: ");
        contantesGrid.insets = new Insets(5, 5, 5, 5);
        contantesGrid.gridx = 0;
        contantesGrid.gridy = 0;
        contantesGrid.gridwidth = 1;
        contantesGrid.gridheight = 1;
        contantesGrid.anchor = GridBagConstraints.NORTHWEST;
        contantesGrid.fill = GridBagConstraints.NONE;
        panelCentral.add(labelExperiencia, contantesGrid);
        contantesGrid.gridx = 1;
        contantesGrid.gridwidth = 3;
        contantesGrid.fill = GridBagConstraints.BOTH;
        panelCentral.add(this.comboExperiencia.getComboBox(), contantesGrid);
        JLabel labelActividad = new JLabel("Actividad: ");
        contantesGrid.gridx = 0;
        contantesGrid.gridy = 1;
        contantesGrid.gridwidth = 1;
        contantesGrid.fill = GridBagConstraints.NONE;
        panelCentral.add(labelActividad, contantesGrid);
        this.textoActividad = new JTextField("Actividad");
        contantesGrid.gridx = 1;
        contantesGrid.gridwidth = 3;
        contantesGrid.fill = GridBagConstraints.BOTH;
        panelCentral.add(this.textoActividad, contantesGrid);
        JLabel labelAsesor = new JLabel("Asesor: ");
        contantesGrid.gridx = 0;
        contantesGrid.gridy = 2;
        contantesGrid.gridwidth = 1;
        contantesGrid.fill = GridBagConstraints.NONE;
        panelCentral.add(labelAsesor, contantesGrid);
        contantesGrid.gridx = 1;
        contantesGrid.gridwidth = 3;
        contantesGrid.fill = GridBagConstraints.BOTH;
        panelCentral.add(this.comboAsesor.getComboBox(), contantesGrid);
        JLabel labelSalon = new JLabel("Salón: ");
        contantesGrid.gridx = 0;
        contantesGrid.gridy = 3;
        contantesGrid.gridwidth = 1;
        contantesGrid.fill = GridBagConstraints.NONE;
        panelCentral.add(labelSalon, contantesGrid);
        contantesGrid.gridx = 1;
        contantesGrid.gridwidth = 3;
        contantesGrid.fill = GridBagConstraints.BOTH;
        panelCentral.add(this.comboSalon.getComboBox(), contantesGrid);
        JLabel fechaInicio = new JLabel("Fecha inicio: ");
        contantesGrid.gridx = 0;
        contantesGrid.gridy = 4;
        contantesGrid.gridwidth = 1;
        contantesGrid.fill = GridBagConstraints.NONE;
        panelCentral.add(fechaInicio, contantesGrid);
        contantesGrid.gridx = 1;
        contantesGrid.fill = GridBagConstraints.BOTH;
        panelCentral.add(this.comboInicioDia.getComboBox(), contantesGrid);
        contantesGrid.gridx = 2;
        panelCentral.add(this.comboInicioMes.getComboBox(), contantesGrid);
        contantesGrid.gridx = 3;
        panelCentral.add(this.comboInicioAno.getComboBox(), contantesGrid);
        JLabel fechaFin = new JLabel("Fecha fin: ");
        contantesGrid.gridx = 0;
        contantesGrid.gridy = 5;
        contantesGrid.gridwidth = 1;
        contantesGrid.fill = GridBagConstraints.NONE;
        panelCentral.add(fechaFin, contantesGrid);
        contantesGrid.gridx = 1;
        contantesGrid.fill = GridBagConstraints.BOTH;
        panelCentral.add(this.comboFinDia.getComboBox(), contantesGrid);
        contantesGrid.gridx = 2;
        panelCentral.add(this.comboFinMes.getComboBox(), contantesGrid);
        contantesGrid.gridx = 3;
        panelCentral.add(this.comboFinAno.getComboBox(), contantesGrid);
        JLabel labelModulo = new JLabel("Módulo: ");
        contantesGrid.gridx = 0;
        contantesGrid.gridy = 6;
        contantesGrid.fill = GridBagConstraints.NONE;
        panelCentral.add(labelModulo, contantesGrid);
        contantesGrid.gridx = 1;
        contantesGrid.fill = GridBagConstraints.BOTH;
        panelCentral.add(this.comboModulo.getComboBox(), contantesGrid);
        JLabel labelSeccion = new JLabel("Sección: ");
        contantesGrid.gridx = 2;
        contantesGrid.fill = GridBagConstraints.NONE;
        panelCentral.add(labelSeccion, contantesGrid);
        contantesGrid.gridx = 3;
        contantesGrid.fill = GridBagConstraints.BOTH;
        panelCentral.add(this.comboSeccion.getComboBox(), contantesGrid);
        JLabel labelCupo = new JLabel("Cupo: ");
        contantesGrid.gridx = 0;
        contantesGrid.gridy = 7;
        contantesGrid.fill = GridBagConstraints.NONE;
        panelCentral.add(labelCupo, contantesGrid);
        contantesGrid.gridx = 1;
        contantesGrid.fill = GridBagConstraints.BOTH;
        panelCentral.add(this.comboCupo.getComboBox(), contantesGrid);
        /**
         * Panel Botones:
         */
        FlowLayout flowBotones = new FlowLayout();
        flowBotones.setVgap(0);
        flowBotones.setHgap(0);
        JPanel panelBotones = new JPanel(flowBotones);
        panelBotones.setBackground(new Colores().getColorBase());
        this.contenedor.add(panelBotones, BorderLayout.SOUTH);
        this.botonGuardarAgregar = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoMasOscuro.png")), "Agregar");
        panelBotones.add(this.botonGuardarAgregar.getButton());
        this.botonCancelar = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoEliminarOscuro.png")), "Cancelar");
        panelBotones.add(this.botonCancelar.getButton());
    }
    public void establecerPropiedades(){
        this.botonGuardarAgregar.addCursorListener(this);
        this.botonCancelar.addCursorListener(this);
    }
    public void inicializarCombos(){
        this.comboExperiencia = new ComboBox(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")));
        this.comboAsesor = new ComboBox(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")));
        this.comboSalon = new ComboBox(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")));
        this.comboInicioDia = new ComboBox(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")));
        this.comboInicioMes = new ComboBox(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")));
        this.comboInicioAno = new ComboBox(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")));
        this.comboFinDia = new ComboBox(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")));
        this.comboFinMes = new ComboBox(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")));
        this.comboFinAno = new ComboBox(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")));
        this.comboCupo = new ComboBox(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")));
        this.comboModulo = new ComboBox(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")));
        this.comboSeccion = new ComboBox(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")));
    }
    public void cargarCombos(){
        cargarComboExperiencia();
        cargarComboAsesor();
        this.comboSalon.addString("Aula 12");
        this.comboSalon.addString("Aula 13");
        this.comboSalon.addString("Aula 15");
        cargarDias(this.comboInicioDia);
        cargarMeses(this.comboInicioMes);
        cargarAnos(this.comboInicioAno);
        cargarDias(this.comboFinDia);
        cargarMeses(this.comboFinMes);
        cargarAnos(this.comboFinAno);
        CombosModuloSeccion combos = new CombosModuloSeccion();
        combos.cargarComboMoulo(this.comboModulo);
        combos.cargarComboSeccion(this.comboSeccion);
        cargarComboCupo();
    }
    public void cargarDias(ComboBox combo){
        for (int c = 1;c < 32; c++){
            combo.addString(""+c);
        }
    }
    public void cargarMeses(ComboBox combo){
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        for (int c = 0;c < 12; c++){
            combo.addString(""+meses[c]);
        }
    }
    public void cargarAnos(ComboBox combo){
        for (int c = 2017;c < 2021; c++){
            combo.addString(""+c);
        }
    }
    public void cargarComboCupo(){
        for (int c = 1; c < 101; c++){
            this.comboCupo.addString(""+c);
        }
    }
    public void cargarComboExperiencia(){
        ExperienciaEducativaDAOSql experienciaDAO = new ExperienciaEducativaDAOSql();
        this.listaExperiencias = experienciaDAO.getListaExperiencias();
        int numeroElementos = listaExperiencias.size();
        for (int i = 0; i < numeroElementos; i++){
            String nombreExperiencia = listaExperiencias.get(i).getNombreExperiencia();
            this.comboExperiencia.addString(nombreExperiencia);
        }
        if (numeroElementos == 0){
            this.comboExperiencia.addString("No hay experiencias");
        }
    }
    public void cargarComboAsesor(){
        AsesorDAOSql asesorDAO = new AsesorDAOSql();
        this.listaAsesores = asesorDAO.getListaAsesores();
        int numeroElementos = listaAsesores.size();
        for (int i = 0; i < numeroElementos; i++){
            String nombreAsesor = listaAsesores.get(i).getNombre();
            this.comboAsesor.addString(nombreAsesor);
        }
        if (numeroElementos == 0){
            this.comboAsesor.addString("No hay asesores");
        }
    }
    public int getIdExperiencia(String nombreExperiencia){
        int idExperiencia = 0;
        int numeroElementos = this.listaExperiencias.size();
        ExperienciaEducativa experiencia;
        for (int i = 0; i < numeroElementos; i++){
            experiencia=this.listaExperiencias.get(i);
            if (experiencia.getNombreExperiencia().equals(nombreExperiencia)){
                idExperiencia = experiencia.getIdExperiencia();
            }
        }
        return idExperiencia;
    }
    public String getNumeroPersonal(String nombreAsesor){
        String numeroPersonal = "";
        int numeroElementos = this.listaAsesores.size();
        Asesor asesor;
        for (int i = 0; i < numeroElementos; i++){
            asesor=this.listaAsesores.get(i);
            if (asesor.getNombre().equals(nombreAsesor)){
                numeroPersonal = asesor.getNumeroPersonal();
            }
        }
        return numeroPersonal;
    }
    public void agregarActividad(){
        ActividadDAOSql actividadDao = new ActividadDAOSql();
        int idActividad = actividadDao.getUltimoId();
        String nombreActividad = this.textoActividad.getText();
        String fechaInicio = this.comboInicioAno.getSelectedItem() +"-"+ getNumeroMes(this.comboInicioMes.getSelectedItem()) +"-"+ this.comboInicioDia.getSelectedItem();
        Date fechaInicioDate = java.sql.Date.valueOf(fechaInicio);
        String fechaFin = this.comboFinAno.getSelectedItem() +"-"+ getNumeroMes(this.comboFinMes.getSelectedItem()) +"-"+ this.comboFinDia.getSelectedItem();
        Date fechaFinDate = java.sql.Date.valueOf(fechaFin);
        String cupo = this.comboCupo.getSelectedItem();
        String seccion = this.comboSeccion.getSelectedItem();
        String modulo = this.comboModulo.getSelectedItem();
        String numeroPersonal = getNumeroPersonal(this.comboAsesor.getSelectedItem());
        int idExperiencia = getIdExperiencia(this.comboExperiencia.getSelectedItem());
        DatosActividad datosActividad = new DatosActividad(idActividad, nombreActividad, fechaInicioDate, fechaFinDate, cupo);
        DatosExperiencia datosExperiencia = new DatosExperiencia(idExperiencia, Integer.valueOf(modulo), Integer.valueOf(seccion));
        Actividad nuevaActividad = new Actividad(datosActividad, datosExperiencia);
        boolean exito = actividadDao.agregarActividad(nuevaActividad, numeroPersonal);
        String mensaje = "";
        if (exito){
            mensaje = "Actividad agregada satisfactoriamente";
        }else{
            mensaje = "La actividad no se pudo crear :(";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public int getNumeroMes(String mes){
        int numeroMes = 0;
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        for (int i = 0; i < 12; i++){
            if (meses[i].equals(mes)){
                numeroMes = i+1;
            }
        }
        return numeroMes;
    }

    /**
     * Eventos: 
     */
    
    @Override
    public void cursorClicked(Button boton) {
        if (boton.equals(this.botonGuardarAgregar)){
            agregarActividad();
        }else if (boton.equals(this.botonCancelar)){
            dispose();
        }
    }
}
