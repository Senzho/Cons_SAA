package LogicaNegocio.DAO;

import LogicaNegocio.Entidades.Inscripcion;
import java.util.ArrayList;

public interface InscripcionDAO {
     public ArrayList<Inscripcion> getListaInscripciones(String matricula);
}
