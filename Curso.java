package LogicaNegocio;

public class Curso {
    private int capacidadCupo;
    private String nombreCurso;
    private int nrc;
    private String periodo;

    public Curso(int capacidadCupo, String nombreCurso, int nrc, String periodo) {
        this.capacidadCupo = capacidadCupo;
        this.nombreCurso = nombreCurso;
        this.nrc = nrc;
        this.periodo = periodo;
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
}
