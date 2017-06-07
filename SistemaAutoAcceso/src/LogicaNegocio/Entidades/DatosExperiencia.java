package LogicaNegocio.Entidades;

public class DatosExperiencia {
    private int idExperiencia;
    private int modulo;
    private int seccion;
    private String numeroPersonal;

    public DatosExperiencia(int idExperiencia, int modulo, int seccion, String numeroPersonal) {
        this.idExperiencia = idExperiencia;
        this.modulo = modulo;
        this.seccion = seccion;
        this.numeroPersonal = numeroPersonal;
    }

    public int getIdExperiencia() {
        return idExperiencia;
    }
    public int getModulo() {
        return modulo;
    }
    public int getSeccion() {
        return seccion;
    }
    public String getNumeroPersonal(){
        return numeroPersonal;
    }
}
