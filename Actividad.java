package LogicaNegocio;

import java.util.Date;
import java.util.ArrayList;

public class Actividad {
    private int idActividad;
    private int codigoActividad;
    private Date fechaActividad;
    private String nombreActividad;
    private ArrayList<Evidencia> listaEvidencias;

    public Actividad(int idActividad, int codigoActividad, Date fechaActividad, String nombreActividad, ArrayList<Evidencia> listaEvidencias) {
        this.idActividad = idActividad;
        this.codigoActividad = codigoActividad;
        this.fechaActividad = fechaActividad;
        this.nombreActividad = nombreActividad;
        this.listaEvidencias = listaEvidencias;
    }
    public int getIdActividad() {
        return idActividad;
    }
    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
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
    public String getNombreActividad() {
        return nombreActividad;
    }
    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }
    public ArrayList<Evidencia> getListaEvidencias() {
        return listaEvidencias;
    }
    public void setListaEvidencias(ArrayList<Evidencia> listaEvidencias) {
        this.listaEvidencias = listaEvidencias;
    }
}
