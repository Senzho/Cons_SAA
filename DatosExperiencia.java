package LogicaNegocio.Entidades;

public class DatosExperiencia {
    private int idExperiencia;
    private int modulo;
    private int seccion;

    public DatosExperiencia(int idExperiencia, int modulo, int seccion) {
        this.idExperiencia = idExperiencia;
        this.modulo = modulo;
        this.seccion = seccion;
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
}
