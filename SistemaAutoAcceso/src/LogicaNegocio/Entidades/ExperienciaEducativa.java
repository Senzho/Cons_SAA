package LogicaNegocio.Entidades;

public class ExperienciaEducativa {
    private int idExperiencia;
    private String nombreExperiencia;
    
    public ExperienciaEducativa(int idExperiencia, String nombreExperiencia){
        this.idExperiencia = idExperiencia;
        this.nombreExperiencia = nombreExperiencia;
    }

    public int getIdExperiencia() {
        return idExperiencia;
    }
    public String getNombreExperiencia() {
        return nombreExperiencia;
    }
}
