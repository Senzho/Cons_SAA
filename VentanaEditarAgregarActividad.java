package InterfazGrafica;

import LogicaNegocio.Logica.Button;
import LogicaNegocio.Logica.Colores;
import LogicaNegocio.Logica.ComboBox;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaEditarAgregarActividad extends JFrame{
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
    private Button botonGuardarAgregar;
    private Button botonCancelar;
    
    public VentanaEditarAgregarActividad(){
        this.inicializarComponentes();
        setTitle("Agregar actividad");
        setSize(400,400);
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
        JLabel labelCupo = new JLabel("Cupo: ");
        contantesGrid.gridx = 0;
        contantesGrid.gridy = 6;
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
    }
    public void cargarCombos(){
        this.comboExperiencia.addString("Experiencia educativa");
        this.comboAsesor.addString("Asesor");
        this.comboSalon.addString("Aula 12");
        cargarDias(this.comboInicioDia);
        cargarMeses(this.comboInicioMes);
        cargarAnos(this.comboInicioAno);
        cargarDias(this.comboFinDia);
        cargarMeses(this.comboFinMes);
        cargarAnos(this.comboFinAno);
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
}
