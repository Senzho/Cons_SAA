package LogicaNegocio.Entidades;

import java.util.ArrayList;

public class Modulo {
    private int idModulo;
    private ArrayList<Seccion> secciones;

    public Modulo(int idModulo, ArrayList<Seccion> secciones) {
        this.idModulo = idModulo;
        this.secciones = secciones;
    }

    public int getIdModulo() {
        return idModulo;
    }
    public ArrayList<Seccion> getSecciones() {
        return secciones;
    }
}
