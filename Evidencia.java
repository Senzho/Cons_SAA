package LogicaNegocio;

public class Evidencia {
    private int idEvidencia;
    private String  nombreActividad;
    private int numeroUsuario;
    private String tipoEvidencia;

    public Evidencia(int idEvidencia, String nombreActividad, int numeroUsuario, String tipoEvidencia) {
        this.idEvidencia = idEvidencia;
        this.nombreActividad = nombreActividad;
        this.numeroUsuario = numeroUsuario;
        this.tipoEvidencia = tipoEvidencia;
    }
    public int getIdEvidencia() {
        return idEvidencia;
    }
    public void setIdEvidencia(int idEvidencia) {
        this.idEvidencia = idEvidencia;
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
