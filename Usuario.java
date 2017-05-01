package LogicaNegocio;

import java.util.ArrayList;

public class Usuario {
    private String matricula;
    private int calificacionFinal;
    private int estadoInscripcion;
    private String nombre;
    private ArrayList<Curso> cursos;

    public Usuario(String matricula, int estadoInscripcion, String nombre, ArrayList<Curso> cursos) {
        this.matricula = matricula;
        this.estadoInscripcion = estadoInscripcion;
        this.nombre = nombre;
        this.cursos = cursos;
    }

    public String getMatricula() {
        return matricula;
    }
    public int getCalificacionFinal() {
        return calificacionFinal;
    }
    public int getEstadoInscripcion() {
        return estadoInscripcion;
    }
    public String getNombre() {
        return nombre;
    }
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
    public void setCalificacionFinal(int calificacionFinal){
        this.calificacionFinal = calificacionFinal;
    }
}
