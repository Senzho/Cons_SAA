package sistemaautoacceso;

import InterfazGrafica.VentanaEditarAgregarActividad;
import InterfazGrafica.VentanaInicioSesion;
import InterfazGrafica.VentanaMostrarActividad;
import InterfazGrafica.VentanaPrincipalAsesor;
import InterfazGrafica.VentanaPrincipalCoordinador;
import InterfazGrafica.VentanaRegistrarActividad;
import InterfazGrafica.VentanaSeguimiento;
import LogicaNegocio.DAO.ActividadDAOSql;
import LogicaNegocio.Entidades.Actividad;

public class SistemaAutoAcceso {

    public static void main(String[] args) {
        /*ActividadDAOSql actividadDao = new ActividadDAOSql();
        Actividad actividad = actividadDao.getActividad(1);*/
        //new VentanaEditarAgregarActividad(true, null);
        //new VentanaMostrarActividad();
        //new VentanaSeguimiento();
        
        //new VentanaRegistrarActividad("1",1,1);*/
        //new VentanaPrincipalCoordinador(null);
        new VentanaInicioSesion();
    }
    
}
