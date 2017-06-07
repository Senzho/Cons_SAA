package sistemaautoacceso;

import InterfazGrafica.VentanaConfiguracionIp;
import InterfazGrafica.VentanaEditarAgregarActividad;
import InterfazGrafica.VentanaInicioSesion;
import InterfazGrafica.VentanaMostrarActividad;
import InterfazGrafica.VentanaPrincipalCoordinador;
import InterfazGrafica.VentanaRegistrarActividad;
import InterfazGrafica.VentanaSeguimiento;
import LogicaNegocio.DAO.ActividadDAOSql;
import LogicaNegocio.Entidades.Actividad;
import LogicaNegocio.Logica.Hash;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

public class SistemaAutoAcceso {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        new VentanaInicioSesion();
    }
    
}
