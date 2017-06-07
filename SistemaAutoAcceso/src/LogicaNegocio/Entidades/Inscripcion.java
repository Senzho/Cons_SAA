package LogicaNegocio.Entidades;

public class Inscripcion {
    private int idInscripcion;
    private String estadoInscripcion;
    private int numeroInscripcion;
    private int calificacionFinal;
    private Curso curso;

    public Inscripcion(int idInscripcion, String estadoInscripcion, int numeroInscripcion, int calificacionFinal, Curso curso) {
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
    public String getEstadoInscripcion() {
        return estadoInscripcion;
    }
    public void setEstadoInscripcion(String estadoInscripcion) {
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