package LogicaNegocio;

import java.util.Date;

public class Actividad {
    private int codigoActividad;
    private Date fechaActividad;
    private int modulo;
    private String nombreActividad;
    
    public Actividad(int codigoActividad, Date fechaActividad, int modulo, String nombreActividad) {
        this.codigoActividad = codigoActividad;
        this.fechaActividad = fechaActividad;
        this.modulo = modulo;
        this.nombreActividad = nombreActividad;
    }
    public int getCodigoActividad() {
        return codigoActividad;
    }
    public void setCodigoActividad(int codigoActividad) {
        this.codigoActividad = codigoActividad;
    }
    public Date getFechaActividad() {
        return fechaActividad;
    }
    public void setFechaActividad(Date fechaActividad) {
        this.fechaActividad = fechaActividad;
    }
    public int getModulo() {
        return modulo;
    }
    public void setModulo(int modulo) {
        this.modulo = modulo;
    }
    public String getNombreActividad() {
        return nombreActividad;
    }
    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }
}
