package LogicaNegocio.DAO;

import LogicaNegocio.Entidades.Actividad;
import LogicaNegocio.Entidades.ActividadRegistrada;
import java.util.ArrayList;

public interface ActividadDAO {
    public boolean agregarActividad(Actividad actividad, String numeroPersonal);
    public Actividad getActividad(int idActividad);
    public ArrayList<Actividad> getListaActividades();
    public ArrayList<Actividad> getListaActividades(int nrc, int modulo, int seccion);
    public boolean registrarActividad(ActividadRegistrada actividad, int idInscripcion, String numeroPersonal);
    public ArrayList<ActividadRegistrada> getListaActividadesRegistradas(int idInscripcion);
    public boolean actiualizarActividad(Actividad actividad, String numeroPersonal);
    public boolean eliminarActividad(int idActividad);
    public int getIdActividad(String nombreActividad);
}
