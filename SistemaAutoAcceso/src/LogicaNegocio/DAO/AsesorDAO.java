package LogicaNegocio.DAO;

import LogicaNegocio.Entidades.Asesor;
import java.util.ArrayList;

public interface AsesorDAO {
    public ArrayList<Asesor> getListaAsesores();
    public Asesor getAsesor(String numeroPersonal);
    public Asesor getAsesorId(int idUsuarioSistema);
}
