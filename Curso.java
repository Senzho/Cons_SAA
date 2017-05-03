package LogicaNegocio.Entidades;

import java.util.ArrayList;

public class Curso {
    private int capacidadCupo;
    private String nombreCurso;
    private int nrc;
    private ArrayList<Modulo> modulos;

    public Curso(int capacidadCupo, String nombreCurso, int nrc, ArrayList<Modulo> modulos) {
        this.capacidadCupo = capacidadCupo;
        this.nombreCurso = nombreCurso;
        this.nrc = nrc;
        this.modulos = modulos;
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
    public ArrayList<Modulo> getModulos() {
        return modulos;
    }
}
