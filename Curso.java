package LogicaNegocio;

import java.util.ArrayList;

public class Curso {
    private int idCurso;
    private int capacidadCupo;
    private String nombreCurso;
    private int nrc;
    private String periodo;
    private ArrayList<Modulo> modulos;

    public Curso(int idCurso, int capacidadCupo, String nombreCurso, int nrc, String periodo, ArrayList<Modulo> modulos) {
        this.idCurso = idCurso;
        this.capacidadCupo = capacidadCupo;
        this.nombreCurso = nombreCurso;
        this.nrc = nrc;
        this.periodo = periodo;
        this.modulos = modulos;
    }
    public int getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
    public int getCapacidadCupo() {
        return capacidadCupo;
    }
    public void setCapacidadCupo(int capacidadCupo) {
        this.capacidadCupo = capacidadCupo;
    }
    public String getNombreCurso() {
        return nombreCurso;
    }
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    public int getNrc() {
        return nrc;
    }
    public void setNrc(int nrc) {
        this.nrc = nrc;
    }
    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    public ArrayList<Modulo> getModulos() {
        return modulos;
    }
}
