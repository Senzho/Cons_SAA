package LogicaNegocio.DAO;

import LogicaNegocio.Entidades.Actividad;
import LogicaNegocio.Entidades.ActividadRegistrada;
import java.util.ArrayList;

public interface ActividadDAO {
    public int getIdActividad(String nombreActividad);
    public boolean agregarActividad(Actividad actividad);
    public Actividad getActividad(int idActividad);
    public ArrayList<Actividad> getListaActividades();
    public ArrayList<Actividad> getListaActividades(int nrc, int modulo, int seccion);
    public boolean registrarActividad(ActividadRegistrada actividad, int idInscripcion, String numeroPersonal);
    public ArrayList<ActividadRegistrada> getListaActividadesRegistradas(int idInscripcion);
    public boolean actiualizarActividad(Actividad actividad);
    public boolean eliminarActividad(int idActividad);
    public int getUltimoId();
}
