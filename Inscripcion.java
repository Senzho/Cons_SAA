package LogicaNegocio.Entidades;

import java.util.ArrayList;

public class Inscripcion {
    private int idInscripcion;
    private int estadoInscripcion;
    private int numeroInscripcion;
    private int calificacionFinal;
    private Curso curso;

    public Inscripcion(int idInscripcion, int estadoInscripcion, int numeroInscripcion, int calificacionFinal, Curso curso) {
        this.idInscripcion = idInscripcion;
        this.estadoInscripcion = estadoInscripcion;
        this.numeroInscripcion = numeroInscripcion;
        this.calificacionFinal = calificacionFinal;
        this.curso = curso;
    }
    public int getIdInscripcion() {
        return idInscripcion;
    }
    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }
    public int getEstadoInscripcion() {
        return estadoInscripcion;
    }
    public void setEstadoInscripcion(int estadoInscripcion) {
        this.estadoInscripcion = estadoInscripcion;
    }
    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }
    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }
    public int getCalificacionFinal() {
        return calificacionFinal;
    }
    public void setCalificacionFinal(int calificacionFinal) {
        this.calificacionFinal = calificacionFinal;
    }
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}