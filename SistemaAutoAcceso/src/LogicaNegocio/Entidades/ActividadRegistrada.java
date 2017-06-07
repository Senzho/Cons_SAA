package LogicaNegocio.Entidades;

import java.util.Date;

public class ActividadRegistrada {
    private int porcentaje;
    private Date fecha;
    private String observacion;
    private int idActividad;

    public ActividadRegistrada(int porcentaje, Date fecha, String observacion, int idActividad) {
        this.porcentaje = porcentaje;
        this.fecha = fecha;
        this.observacion = observacion;
        this.idActividad = idActividad;
    }

    public int getPorcentaje() {
        return porcentaje;
    }
    public Date getFecha() {
        return fecha;
    }
    public String getObservacion() {
        return observacion;
    }
    public int getIdActividad(){
        return idActividad;
    }
}
