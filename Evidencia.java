package LogicaNegocio.Entidades;

public class Evidencia {
    private int idEvidencia;
    private String tipoEvidencia;

    public Evidencia(int idEvidencia, String tipoEvidencia) {
        this.idEvidencia = idEvidencia;
        this.tipoEvidencia = tipoEvidencia;
    }
    public int getIdEvidencia() {
        return idEvidencia;
    }
    public void setIdEvidencia(int idEvidencia) {
        this.idEvidencia = idEvidencia;
    }
    public String getTipoEvidencia() {
        return tipoEvidencia;
    }
    public void setTipoEvidencia(String tipoEvidencia) {
        this.tipoEvidencia = tipoEvidencia;
    }    
}
