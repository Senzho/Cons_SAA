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

public class VentanaMostrarActividad extends JFrame implements SelectionListener, CursorListener{
    private Button btnEditar;
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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Calendario de actividades");
        setVisible(true);
    }
    
    public void inicializarComponentes(){
        btnEditar = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoEditarOscuro.png")), "Editar");
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
        panelBotones.add(btnEditar.getButton());
        panelBotones.add(btnAgregar.getButton());
        panelBotones.add(btnEliminar.getButton());
        panelBotones.add(btnSalir.getButton());
        panelBotones.setBackground(new Colores().getColorBase());
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        panelPrincipal.add(scrollActividades, BorderLayout.CENTER);
        this.btnSalir.addCursorListener(this);
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
       panelActividades.setVisible(false);
       panelActividades.setVisible(true);
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

    @Override
    public void bloqueSeleccionado(BloqueActividad bloque) {
        this.bloqueActividad = bloque;
        deseleccionarBloque();
    }
    @Override
    public void bloqueDeseleccionado(BloqueActividad bloque) {
        this.bloqueActividad = null;
    }

    @Override
    public void cursorClicked(Button boton) {
        if (boton.equals(this.btnSalir)){
            dispose();
        }
    }
}
