package LogicaNegocio.Entidades;

import java.util.Date;

public class DatosActividad {
    private int idActividad;
    private String nombreActividad;
    private Date fechaInicio;
    private Date fechaFin;
    private String cupo;
    private String salon;

    public DatosActividad(int idActividad, String nombreActividad, Date fechaInicio, Date fechaFin, String cupo, String salon) {
        this.idActividad = idActividad;
        this.nombreActividad = nombreActividad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cupo = cupo;
        this.salon = salon;
    }
    public int getIdActividad() {
        return idActividad;
    }
    public String getNombreActividad() {
        return nombreActividad;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public String getCupo() {
        return cupo;
    }
    public String getSalon(){
        return salon;
    }
}
