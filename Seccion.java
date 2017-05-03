package LogicaNegocio.Entidades;

import java.util.ArrayList;

public class Seccion {
    private int idSeccion;
    private ArrayList<Actividad> actividades;

    public Seccion(int idSeccion, ArrayList<Actividad> actividades) {
        this.idSeccion = idSeccion;
        this.actividades = actividades;
    }

    public int getIdSeccion() {
        return idSeccion;
    }
    public ArrayList<Actividad> getActividades() {
        return actividades;
    }
}
