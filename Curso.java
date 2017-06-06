package LogicaNegocio.Entidades;

import java.util.ArrayList;

public class Curso {
    private int capacidadCupo;
    private String nombreCurso;
    private int nrc;
    private ArrayList<Modulo> modulos;
    private String idioma;
    private int idExperiencia;

    public Curso(int capacidadCupo, String nombreCurso, int nrc, ArrayList<Modulo> modulos, String idioma, int idExperiencia) {
        this.capacidadCupo = capacidadCupo;
        this.nombreCurso = nombreCurso;
        this.nrc = nrc;
        this.modulos = modulos;
        this.idioma = idioma;
        this.idExperiencia = idExperiencia;
    }
    public String getIdioma(){
        return idioma;
    }
    public int getIdExperiencia() {
        return idExperiencia;
    }
    public void setIdExperiencia(int idExperiencia) {
        this.idExperiencia = idExperiencia;
    }
    public void setIdioma(String idioma){
        this.idioma = idioma;
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
