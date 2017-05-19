package InterfazGrafica;

import javax.swing.JFrame;
import LogicaNegocio.Logica.Button;
import LogicaNegocio.Logica.Colores;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;

public class VentanaMostrarActividad extends JFrame{
    private Button btnEditar;
    private Button btnAgregar;
    private Button btnEliminar;
    private Button btnSalir;
    private JPanel panelPrincipal;
    private JPanel panelBotones;
    private JScrollPane scrollActividades;
    private JPanel panelActividades;
    public VentanaMostrarActividad(){
        setSize(730,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Calendario de actividades");
        setVisible(true);
        this.inicializarComponentes();
        this.agregarComponentes();
    }
    public void inicializarComponentes(){
        btnEditar = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoEditarOscuro.png")), "Editar");
        btnAgregar = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoMasOscuro.png")), "Agregar");
        btnEliminar = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoEliminarOscuro.png")), "Eliminar");
        btnSalir = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoAbajoOscuro.png")), "Salir");
        panelPrincipal = new JPanel();
        panelBotones = new JPanel();
        panelActividades = new JPanel();
        scrollActividades = new JScrollPane(panelActividades);
    }  
    public void agregarComponentes(){
        add(panelPrincipal);
        panelPrincipal.setLayout(new BorderLayout());
        panelBotones.setLayout(new FlowLayout());
        panelBotones.add(btnEditar.getButton());
        panelBotones.add(btnAgregar.getButton());
        panelBotones.add(btnEliminar.getButton());
        panelBotones.add(btnSalir.getButton());
        panelBotones.setBackground(new Colores().getColorBase());
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        panelPrincipal.add(scrollActividades, BorderLayout.CENTER);
    }
}
