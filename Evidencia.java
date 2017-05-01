package LogicaNegocio;

public class Evidencia {
    private String  nombreActividad;
    private int numeroUsuario;
    private String tipoEvidencia;

    public Evidencia(String nombreActividad, int numeroUsuario, String tipoEvidencia) {
        this.nombreActividad = nombreActividad;
        this.numeroUsuario = numeroUsuario;
        this.tipoEvidencia = tipoEvidencia;
    }
    public String getNombreActividad() {
        return nombreActividad;
    }
    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }
    public int getNumeroUsuario() {
        return numeroUsuario;
    }
    public void setNumeroUsuario(int numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }
    public String getTipoEvidencia() {
        return tipoEvidencia;
    }
    public void setTipoEvidencia(String tipoEvidencia) {
        this.tipoEvidencia = tipoEvidencia;
    }
}
