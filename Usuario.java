package LogicaNegocio.Entidades;

import java.util.ArrayList;

public class Usuario {
    private String matricula;
    private String nombre;
    private String telefono;
    private String correo;
    private ArrayList<Inscripcion> inscripciones;

    public Usuario(String matricula, String nombre,  ArrayList<Inscripcion> inscripciones, String telefono, String correo) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.inscripciones = inscripciones;
    }

    public String getTelefono() {
        return telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public String getMatricula() {
        return matricula;
    }
    public String getNombre() {
        return nombre;
    }
    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }
}
