package InterfazGrafica;

import LogicaNegocio.Entidades.Actividad;
import LogicaNegocio.DAO.ExperienciaEducativaDAOSql;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class BloqueActividad {
    private JPanel panelActividad;
    private Actividad actividad;
    
    public BloqueActividad(Actividad actividad){
        this.actividad = actividad;
        this.panelActividad = new JPanel();
    }
    public JPanel getPanel(){
        return this.panelActividad;
    }
    public Actividad getActividad(){
        return this.actividad;
    }
    public void configurarPanel(){
        JPanel panelConversacionCupo = new JPanel();
        panelConversacionCupo.setLayout(new GridLayout(1,2));
        panelActividad.setLayout(new BorderLayout());
        ExperienciaEducativaDAOSql experienciaEducativa = new ExperienciaEducativaDAOSql();
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaInicio = formatoFecha.format(actividad.getDatosActividad().getFechaInicio());
        String fechaFin = formatoFecha.format(actividad.getDatosActividad().getFechaFin());
        String cupo = actividad.getDatosActividad().getCupo();
        String nombreActividad = actividad.getDatosActividad().getNombreActividad();
        String nombreExperiencia = experienciaEducativa.getExperienciaEducativa(actividad.getDatosExperiencia().getIdExperiencia()).getNombreExperiencia();
        String salon =  actividad.getDatosActividad().getSalon();
        panelActividad.add(new JLabel(fechaInicio+" - "+fechaFin), BorderLayout.NORTH);
        panelActividad.add(new JLabel(nombreExperiencia), BorderLayout.EAST);
        panelConversacionCupo.add(new JLabel(nombreActividad));
        panelConversacionCupo.add(new JLabel(cupo));
        panelActividad.add(panelConversacionCupo, BorderLayout.CENTER);
        panelActividad.add(new JLabel("Sala de conversación"+salon),BorderLayout.SOUTH);
    }
}
