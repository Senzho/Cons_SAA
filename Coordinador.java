package LogicaNegocio.Entidades;

public class Coordinador {
    private String numeroPersonal;
    private String nombre;
    private String correo;
    private String telefono;

    public Coordinador(String numeroPersonal, String nombre, String correo, String telefono) {
        this.numeroPersonal = numeroPersonal;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNumeroPersonal() {
        return numeroPersonal;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public String getTelefono() {
        return telefono;
    }
}
