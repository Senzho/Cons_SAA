package LogicaNegocio.Entidades;

public class Asesor {
    private String numeroPersonal;
    private String nombre;
    private String idioma;
    private String telefono;
    private String correo;

    public Asesor(String numeroPersonal, String nombre, String idioma, String telefono, String correo) {
        this.numeroPersonal = numeroPersonal;
        this.nombre = nombre;
        this.idioma = idioma;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }
    public String getCorreo() {
        return correo;
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
