package InterfazGrafica;

import LogicaNegocio.DAO.InscripcionDAOSql;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import LogicaNegocio.DAO.UsuarioDAOSql;
import LogicaNegocio.Entidades.Asesor;
import LogicaNegocio.Entidades.Usuario;

public class VentanaBuscarAlumno extends JFrame implements CursorListener{
    private Button btnBuscar;
    private Button btnCancelar;
    private JPanel panelPrincipal;
    private JPanel panelBotones;
    private JTextField txtMatricula;
    private Asesor asesor;
    public VentanaBuscarAlumno(Asesor asesor){
        inicializarVentana();
        configurarVentana();
        agregarComponentes();
        this.asesor = asesor;
    }
    public void inicializarVentana(){
        setTitle("Buscar alumno");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,150);
        setLocationRelativeTo(null);
        setVisible(true);        
    }
    public void configurarVentana(){
        panelPrincipal = new JPanel();
        panelBotones = new JPanel();
        btnBuscar = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoMasOscuro.png")), "Buscar");
        btnCancelar = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoEliminarOscuro.png")), "Salir");
        txtMatricula = new JTextField();
    }
    public void agregarComponentes(){
        add(panelPrincipal);
        panelPrincipal.setLayout(new BorderLayout());
        panelBotones.setLayout(new GridLayout(1,2));
        panelBotones.add(this.btnBuscar.getButton());
        panelBotones.add(this.btnCancelar.getButton());
        panelPrincipal.add(new JLabel("Matricula:"), BorderLayout.LINE_START);
        panelPrincipal.add(this.txtMatricula, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
    }    

    @Override
    public void cursorClicked(Button boton) {
        if(boton.equals(this.btnBuscar)){
            /**
             * falta buscar un usuario
             * validar que exista el usuario
             * numeroPersonal idInscripcion idSistema
             */
            InscripcionDAOSql inscripcionDao = new InscripcionDAOSql();
        }
    }
}