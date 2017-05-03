package LogicaNegocio.Entidades;

public class Asesor {
    private String numeroPersonal;
    private String nombre;
    private String idioma;

    public Asesor(String numeropersonal, String nombre, String idioma) {
        this.numeroPersonal = numeropersonal;
        this.nombre = nombre;
        this.idioma = idioma;
    }

    public String getNumeroPersonal() {
        return numeroPersonal;
    }
    public String getNombre(){
        return nombre;
    }
    public String getIdioma() {
        return idioma;
    }
}
