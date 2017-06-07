package InterfazGrafica;

import LogicaNegocio.DAO.ActividadDAOSql;
import LogicaNegocio.Entidades.Actividad;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;

public class VentanaMostrarActividad extends JFrame implements SelectionListener, CursorListener, ComunicationListener{
    private Button btnGuardar;
    private Button btnAgregar;
    private Button btnEliminar;
    private Button btnSalir;
    private JPanel panelPrincipal;
    private JPanel panelBotones;
    private JScrollPane scrollActividades;
    private JPanel panelActividades;
    private ArrayList<BloqueActividad> listaBloqueActividades;
    private BloqueActividad bloqueActividad;
    
    public VentanaMostrarActividad(){
        this.listaBloqueActividades = new ArrayList();
        this.bloqueActividad = null;
        this.inicializarComponentes();
        this.agregarComponentes();
        this.cargarActividades();
        this.mostrarActividades();
        setSize(730,480);
        setLocationRelativeTo(null);
        setTitle("Calendario de actividades");
        setVisible(true);
    }
    
    public void inicializarComponentes(){
        btnGuardar = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoEditarOscuro.png")), "Editar");
        btnAgregar = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoMasOscuro.png")), "Agregar");
        btnEliminar = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoMenosOscuro.png")), "Eliminar");
        btnSalir = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoEliminarOscuro.png")), "Salir");
        panelPrincipal = new JPanel();
        panelBotones = new JPanel();
        panelActividades = new JPanel();
        scrollActividades = new JScrollPane(panelActividades);
        scrollActividades.setBorder(BorderFactory.createLineBorder(panelActividades.getBackground(), 10));
    }  
    public void agregarComponentes(){
        add(panelPrincipal);
        panelPrincipal.setLayout(new BorderLayout());
        FlowLayout flowBotones = new FlowLayout();
        flowBotones.setVgap(0);
        flowBotones.setHgap(0);
        panelActividades.setLayout(new BoxLayout(panelActividades, BoxLayout.Y_AXIS));
        panelBotones.setLayout(flowBotones);
        panelBotones.add(btnGuardar.getButton());
        panelBotones.add(btnAgregar.getButton());
        panelBotones.add(btnEliminar.getButton());
        panelBotones.add(btnSalir.getButton());
        panelBotones.setBackground(new Colores().getColorBase());
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        panelPrincipal.add(scrollActividades, BorderLayout.CENTER);
        this.btnSalir.addCursorListener(this);
        this.btnAgregar.addCursorListener(this);
        this.btnGuardar.addCursorListener(this);
        this.btnEliminar.addCursorListener(this);
    }
    public void cargarActividades(){
        ArrayList<Actividad> listaActividades = new ArrayList<>();
        ActividadDAOSql actividadDao = new ActividadDAOSql();
        listaActividades = actividadDao.getListaActividades();
        for(int i = 0; i<listaActividades.size(); i++){
            BloqueActividad bloqueActividadLista = new BloqueActividad(listaActividades.get(i));
            bloqueActividadLista.addSelectionListener(this);
            listaBloqueActividades.add(bloqueActividadLista);
        }
    }
    public void mostrarActividades(){
        panelActividades.removeAll();
        for(int i = 0; i< listaBloqueActividades.size(); i++){
            panelActividades.add(listaBloqueActividades.get(i).getPanel());
        }
        recargarPanelActividades();
    }
    public void editarActividad(BloqueActividad bloque){
        BloqueActividad bloqueLista;
        for(int i = 0; i< listaBloqueActividades.size(); i++){
            bloqueLista = listaBloqueActividades.get(i);
            int idActividadBloque = bloque.getActividad().getDatosActividad().getIdActividad();
            int idActividadLista = bloqueLista.getActividad().getDatosActividad().getIdActividad();
            if (idActividadLista == idActividadBloque){
                listaBloqueActividades.remove(i);
                listaBloqueActividades.add(i, bloque);
                bloque.addSelectionListener(this);
                panelActividades.remove(bloqueLista.getPanel());
                panelActividades.add(bloque.getPanel(), i);
            }
        }
        recargarPanelActividades();
    }
    public void agregarActividad(BloqueActividad bloque){
        listaBloqueActividades.add(bloque);
        bloque.addSelectionListener(this);
        panelActividades.add(bloque.getPanel());
        recargarPanelActividades();
    }
    public void borrarActividad(int idActividad){
        BloqueActividad bloqueLista;
        for(int i = 0; i< listaBloqueActividades.size(); i++){
            bloqueLista = listaBloqueActividades.get(i);
            if (bloqueLista.getActividad().getDatosActividad().getIdActividad() == idActividad){
                listaBloqueActividades.remove(i);
                panelActividades.remove(bloqueLista.getPanel());
                this.bloqueActividad = null;
            }
        }
        recargarPanelActividades();
    }
    public void deseleccionarBloque(){
        int numeroElementos = this.listaBloqueActividades.size();
        for (int i = 0; i < numeroElementos; i++){
            BloqueActividad bloque = this.listaBloqueActividades.get(i);
            if (bloque.estaSeleccionado()){
                bloque.deseleccionar();
            }
        }
    }
    public void recargarPanelActividades(){
        panelActividades.setVisible(false);
        panelActividades.setVisible(true);
    }
    
    @Override
    public void bloqueSeleccionado(BloqueActividad bloque) {
        this.bloqueActividad = bloque;
        if (this.bloqueActividad!=null){
            deseleccionarBloque();
        }
    }
    @Override
    public void bloqueDeseleccionado(BloqueActividad bloque) {
        this.bloqueActividad = null;
    }

    @Override
    public void cursorClicked(Button boton) {
        if (boton.equals(this.btnSalir)){
            dispose();
        }else if (boton.equals(this.btnAgregar)){
            VentanaEditarAgregarActividad ventanaAgregar = new VentanaEditarAgregarActividad(true, 0);
            ventanaAgregar.addComunicationListener(this);
        }else if (boton.equals(this.btnGuardar)){
            if (this.bloqueActividad != null){
                VentanaEditarAgregarActividad ventanaEditar = new VentanaEditarAgregarActividad(false, this.bloqueActividad.getActividad().getDatosActividad().getIdActividad());
                ventanaEditar.addComunicationListener(this);
            }else{
                JOptionPane.showMessageDialog(null, "No hay actividad seleccionada");
            }
        }else if (boton.equals(this.btnEliminar)){
            if (this.bloqueActividad != null){
                int res = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quiere eliminar la actividad?");
                if(res == 0){
                    ActividadDAOSql actividadDao = new ActividadDAOSql();
                    int idActividad = this.bloqueActividad.getActividad().getDatosActividad().getIdActividad();
                    boolean eliminada = actividadDao.eliminarActividad(idActividad);
                    String mensaje = "";
                    if (eliminada){
                        borrarActividad(idActividad);
                        mensaje = "Actividad eliminada";
                    }else{
                        mensaje = "La actividad no se pudo eliminar :(";
                    }
                    JOptionPane.showMessageDialog(null, mensaje);
                }
            }else{
                JOptionPane.showMessageDialog(null, "No hay actividad seleccionada");
            }
        }
    }

    @Override
    public void actividadEditada(BloqueActividad bloque) {
        this.bloqueActividad = null;
        this.editarActividad(bloque);
    }
    @Override
    public void actividadAgregada(BloqueActividad bloque) {
        this.bloqueActividad = null;
        agregarActividad(bloque);
    }
}
