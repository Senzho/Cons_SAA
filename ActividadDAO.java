package LogicaNegocio.DAO;

import LogicaNegocio.Entidades.Actividad;
import LogicaNegocio.Entidades.ActividadRegistrada;
import java.util.ArrayList;

public interface ActividadDAO {
    public ArrayList<ActividadRegistrada> getListaActividadesRegistradas(int idInscripcion);
    public Actividad getActividad(int idActividad);
    public ArrayList<Actividad> getListaActividades(int nrc, int modulo, int seccion);
    public boolean registrarActividad(ActividadRegistrada actividad, int idInscripcion, String numeroPersonal);
}
