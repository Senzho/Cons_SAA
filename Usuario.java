package LogicaNegocio.Entidades;

import java.util.ArrayList;

public class Usuario {
    private String matricula;
    private String nombre;
    private ArrayList<Inscripcion> inscripciones;

    public Usuario(String matricula, String nombre, ArrayList<Inscripcion> inscripciones) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.inscripciones = inscripciones;
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
