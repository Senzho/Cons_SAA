package InterfazGrafica;

import LogicaNegocio.Entidades.Actividad;
import LogicaNegocio.DAO.ExperienciaEducativaDAOSql;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class BloqueActividad implements MouseListener{
    private JPanel panelActividad;
    private JPanel panelConversacionCupo;
    private Actividad actividad;
    private JLabel labelFechas;
    private JLabel labelExperiencia;
    private JLabel labelActividad;
    private JLabel labelCupo;
    private JLabel labelSalon;
    private Colores colores;
    private SelectionListener selectionListener;
    private boolean seleccionado;
    private final Color COLOR_RESALTE = new Color(55,127,100);
    
    public BloqueActividad(Actividad actividad){
        this.seleccionado = false;
        this.actividad = actividad;
        this.panelActividad = new JPanel();
        this.colores = new Colores();
        configurarPanel();
        establecerPropiedades();
    }
    public JPanel getPanel(){
        return this.panelActividad;
    }
    public Actividad getActividad(){
        return this.actividad;
    }
    public void configurarPanel(){
        Font fuente = new Font("Arial", Font.PLAIN, 20);
        panelConversacionCupo = new JPanel();
        panelConversacionCupo.setLayout(new GridLayout(1,2));
        panelConversacionCupo.setBackground(this.colores.getColorBase());
        BorderLayout borderActividad = new BorderLayout();
        borderActividad.setVgap(20);
        borderActividad.setHgap(20);
        panelActividad.setLayout(borderActividad);
        panelActividad.setBorder(BorderFactory.createLineBorder(panelActividad.getBackground(), 10));
        panelActividad.setBackground(this.colores.getColorBase());
        ExperienciaEducativaDAOSql experienciaEducativa = new ExperienciaEducativaDAOSql();
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaInicio = formatoFecha.format(actividad.getDatosActividad().getFechaInicio());
        String fechaFin = formatoFecha.format(actividad.getDatosActividad().getFechaFin());
        String cupo = actividad.getDatosActividad().getCupo();
        String nombreActividad = actividad.getDatosActividad().getNombreActividad();
        String nombreExperiencia = experienciaEducativa.getExperienciaEducativa(actividad.getDatosExperiencia().getIdExperiencia()).getNombreExperiencia();
        String salon =  actividad.getDatosActividad().getSalon();
        labelFechas = new JLabel(fechaInicio+" - "+fechaFin);
        labelFechas.setFont(fuente);
        panelActividad.add(labelFechas, BorderLayout.NORTH);
        labelExperiencia = new JLabel(nombreExperiencia);
        labelExperiencia.setFont(fuente);
        panelActividad.add(labelExperiencia, BorderLayout.WEST);
        labelActividad = new JLabel(nombreActividad);
        labelActividad.setFont(fuente);
        panelConversacionCupo.add(labelActividad);
        labelCupo = new JLabel("Cupo: "+cupo);
        labelCupo.setFont(fuente);
        panelConversacionCupo.add(labelCupo);
        panelActividad.add(panelConversacionCupo, BorderLayout.CENTER);
        labelSalon = new JLabel("Salón: "+salon);
        labelSalon.setFont(fuente);
        panelActividad.add(labelSalon,BorderLayout.SOUTH);
    }
    public void establecerPropiedades(){
        this.panelActividad.addMouseListener(this);
        this.labelActividad.addMouseListener(this);
        this.labelCupo.addMouseListener(this);
        this.labelExperiencia.addMouseListener(this);
        this.labelFechas.addMouseListener(this);
        this.labelSalon.addMouseListener(this);
        this.panelConversacionCupo.addMouseListener(this);
    }
    public void cambiarColorFondo(Color color){
        this.panelActividad.setBackground(color);
        this.panelConversacionCupo.setBackground(color);
    }
    public void cambiarColorLetra(Color color){
        this.labelActividad.setForeground(color);
        this.labelCupo.setForeground(color);
        this.labelExperiencia.setForeground(color);
        this.labelFechas.setForeground(color);
        this.labelSalon.setForeground(color);
    }
    public boolean panelResaltado(Object objeto){
        boolean seleccionado = false;
        if (objeto.equals(this.panelActividad) || objeto.equals(this.labelActividad) || objeto.equals(this.labelCupo) || objeto.equals(this.labelExperiencia) || objeto.equals(this.labelFechas) || objeto.equals(this.labelSalon) || objeto.equals(this.panelConversacionCupo)){
            seleccionado = true;
        }
        return seleccionado;
    }
    public void addSelectionListener(SelectionListener listener){
        this.selectionListener = listener;
    }
    public boolean estaSeleccionado(){
        return this.seleccionado;
    }
    public void deseleccionar(){
        cambiarColorFondo(colores.getColorBase());
        cambiarColorLetra(Color.black);
        this.seleccionado = false;
    }
    public void setPanel(JPanel panel){
        this.panelActividad = panel;
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        
    }
    @Override
    public void mousePressed(MouseEvent evento) {
        Object objetoFuente = evento.getSource();
        if (panelResaltado(objetoFuente) && !this.seleccionado){
            cambiarColorFondo(this.colores.getColorPresion());
        }
    }
    @Override
    public void mouseReleased(MouseEvent evento) {
        Object objetoFuente = evento.getSource();
        if (panelResaltado(objetoFuente)){
            if (this.seleccionado){
                cambiarColorFondo(this.colores.getColorResalte());
                if (this.selectionListener != null){
                    this.selectionListener.bloqueDeseleccionado(this);
                }
                deseleccionar();
            }else{
                cambiarColorFondo(this.COLOR_RESALTE);
                if (this.selectionListener != null){
                    this.selectionListener.bloqueSeleccionado(this);
                }
                cambiarColorLetra(Color.white);
                this.seleccionado = true;
            }
        }
    }
    @Override
    public void mouseEntered(MouseEvent evento) {
        Object objetoFuente = evento.getSource();
        if (panelResaltado(objetoFuente) && !this.seleccionado){
            cambiarColorFondo(this.colores.getColorResalte());
        }
    }
    @Override
    public void mouseExited(MouseEvent evento) {
        Object objetoFuente = evento.getSource();
        if (panelResaltado(objetoFuente) && !this.seleccionado){
            cambiarColorFondo(this.colores.getColorBase());
        }
    }
}
