package sistemaautoacceso;

import InterfazGrafica.VentanaEditarAgregarActividad;
import InterfazGrafica.VentanaMostrarActividad;
import InterfazGrafica.VentanaRegistrarActividad;
import InterfazGrafica.VentanaSeguimiento;

public class SistemaAutoAcceso {

    public static void main(String[] args) {
        new VentanaEditarAgregarActividad();
        new VentanaMostrarActividad();
        new VentanaRegistrarActividad("1", 1, 1);
        new VentanaSeguimiento();
    }
    
}
