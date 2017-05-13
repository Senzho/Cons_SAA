package LogicaNegocio.Entidades;

import java.util.Date;

public class Actividad {
    private int idActividad;
    private Date fechaActividad;
    private String nombreActividad;

    public Actividad(int idActividad, Date fechaActividad, String nombreActividad) {
        this.idActividad = idActividad;
        this.fechaActividad = fechaActividad;
        this.nombreActividad = nombreActividad;
    }
    public int getIdActividad() {
        return idActividad;
    }
    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }
    public Date getFechaActividad() {
        return fechaActividad;
    }
    public void setFechaActividad(Date fechaActividad) {
        this.fechaActividad = fechaActividad;
    }
    public String getNombreActividad() {
        return nombreActividad;
    }
    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }
}
