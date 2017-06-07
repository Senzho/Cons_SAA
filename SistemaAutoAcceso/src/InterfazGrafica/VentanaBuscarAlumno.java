package InterfazGrafica;

import LogicaNegocio.DAO.ExperienciaEducativaDAOSql;
import LogicaNegocio.DAO.CursoDAOSql;
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
import LogicaNegocio.Entidades.Curso;
import LogicaNegocio.Entidades.ExperienciaEducativa;
import LogicaNegocio.Entidades.Inscripcion;
import LogicaNegocio.Entidades.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VentanaBuscarAlumno extends JFrame implements CursorListener{
    private Button btnBuscar;
    private Button btnCancelar;
    private JPanel panelPrincipal;
    private JPanel panelBotones;
    private JTextField txtMatricula;
    private Asesor asesor;
    private boolean opcion;
    public VentanaBuscarAlumno(Asesor asesor, boolean opcion){
        this.asesor = asesor;
        this.opcion = opcion;
        inicializarVentana();
        configurarVentana();
        agregarComponentes();
    }
    public void inicializarVentana(){
        setTitle("Buscar alumno");
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
        btnBuscar.addCursorListener(this);
        btnCancelar.addCursorListener(this);
    }    

    @Override
    public void cursorClicked(Button boton) {
        if(boton.equals(this.btnBuscar)){
            if(opcion == true){
                mostrarVentanaRegistroActividad();
            }else{
                mostrarVentanaSeguimiento();
            }
        }
        if(boton.equals(this.btnCancelar)){
            dispose();
        }
    }
    public void mostrarVentanaSeguimiento(){
        String matricula = this.txtMatricula.getText();
        InscripcionDAOSql inscripcionDao = new InscripcionDAOSql();
        Inscripcion inscripcion = null;
        ExperienciaEducativa experienciaEducativa = null;
        ExperienciaEducativaDAOSql experienciaEducativaDao = new ExperienciaEducativaDAOSql();
        UsuarioDAOSql usuarioDao = new UsuarioDAOSql();
        Usuario usuario = usuarioDao.getUsuario(matricula);
        if(usuario!=null){
            ArrayList<Inscripcion> listaInscripciones = inscripcionDao.getListaInscripciones(matricula);
            for(int i = 0; i<listaInscripciones.size(); i++){
                if(listaInscripciones.get(i).getCurso().getIdioma().equals(asesor.getIdioma())){
                    inscripcion = listaInscripciones.get(i);//.getIdInscripcion()
                    experienciaEducativa = experienciaEducativaDao.getExperienciaEducativa(inscripcion.getCurso().getIdExperiencia());
                    new VentanaSeguimiento(inscripcion, matricula, this.asesor.getNumeroPersonal(),inscripcion.getIdInscripcion(), experienciaEducativa.getIdExperiencia());
                    dispose();
                    break;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Usuario no encontrado");
        }
    }
    public void mostrarVentanaRegistroActividad(){
        String matricula = this.txtMatricula.getText();
        InscripcionDAOSql inscripcionDao = new InscripcionDAOSql();
        Inscripcion inscripcion = null;
        ExperienciaEducativa experienciaEducativa = null;
        ExperienciaEducativaDAOSql experienciaEducativaDao = new ExperienciaEducativaDAOSql();
        UsuarioDAOSql usuarioDao = new UsuarioDAOSql();
        Usuario usuario = usuarioDao.getUsuario(matricula);
        if(usuario!=null){
            ArrayList<Inscripcion> listaInscripciones = inscripcionDao.getListaInscripciones(matricula);
            for(int i = 0; i<listaInscripciones.size(); i++){
                if(listaInscripciones.get(i).getCurso().getIdioma().equals(asesor.getIdioma())){
                    inscripcion = listaInscripciones.get(i);
                    experienciaEducativa = experienciaEducativaDao.getExperienciaEducativa(inscripcion.getCurso().getIdExperiencia());
                    new VentanaRegistrarActividad(this.asesor.getNumeroPersonal(), inscripcion.getIdInscripcion(), experienciaEducativa.getIdExperiencia());
                    dispose();
                    break;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Usuario no encontrado");
        }
    }
}